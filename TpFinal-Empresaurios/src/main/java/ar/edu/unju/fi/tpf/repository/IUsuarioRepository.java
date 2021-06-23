package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario,Long>{

	Usuario findByNombreU(String nombreU);

}