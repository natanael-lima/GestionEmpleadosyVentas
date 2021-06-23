package ar.edu.unju.fi.tpf.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Usuario;
import ar.edu.unju.fi.tpf.repository.IUsuarioRepository;
import ar.edu.unju.fi.tpf.service.IUsuarioService;

@Service
public class UsuarioRepositoryImp implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository usuarioRepo; 
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	public Usuario findbyNombreU(String nombreU) {
		return usuarioRepo.findByNombreU(nombreU);
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuario.setPass(passEncoder.encode(usuario.getPass()));
		usuarioRepo.save(usuario);
	}

}
