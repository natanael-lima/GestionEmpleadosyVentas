
package ar.edu.unju.fi.tpf.service;

import ar.edu.unju.fi.tpf.model.Usuario;

public interface IUsuarioService {

	Usuario findbyNombreU(String nombreU);
	
	public void guardarUsuario(Usuario usuario);
	
	

}