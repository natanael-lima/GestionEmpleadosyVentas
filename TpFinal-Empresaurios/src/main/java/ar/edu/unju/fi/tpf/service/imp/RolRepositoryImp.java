package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Rol;
import ar.edu.unju.fi.tpf.repository.IRolRepository;
import ar.edu.unju.fi.tpf.service.IRolService;

@Service
public class RolRepositoryImp implements IRolService{
	
	@Autowired
	private IRolRepository rolRepo;

	@Override
	public List<Rol> obtenerRoles() {
		return (List<Rol>) rolRepo.findAll();
	}

}
