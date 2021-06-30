package ar.edu.unju.fi.tpf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ROLES")
public class Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="rol_name")
	private String rolname;
	
	@OneToOne(mappedBy = "rol",fetch = FetchType.LAZY)
	private Usuario usuario;

	public Rol() {
		super();
	}

	public Rol(long id, String rolname, Usuario usuario) {
		super();
		this.id = id;
		this.rolname = rolname;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolname() {
		return rolname;
	}

	public void setRolname(String rolname) {
		this.rolname = rolname;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rolname=" + rolname + ", usuario=" + usuario + "]";
	}
	
	
	

}
