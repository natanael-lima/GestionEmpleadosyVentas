package ar.edu.unju.fi.tpf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=2, max=20, message="El nombre debe tener entre 2 y 20 caracteres")
	@Column(name="usu_nombreu")
	private String nombreU;
	
	@NotBlank(message="Campo obligatorio")
	@Size(min=2,message="La contraseña debe ser de 8 caracteres o mas")
	@Column(name="usu_pass")
	private String pass;
	
	@Column(name="usu_email")
	@Email(message="Campo obligatorio")
	private String email;
	
	//@OneToOne(mappedBy = "employee",fetch = FetchType.LAZY)
	//private Employee employee;

	public Usuario() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreU=" + nombreU + ", pass=" + pass + ", email=" + email + "]";
	}

	
	
		
	
}