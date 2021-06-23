package ar.edu.unju.fi.tpf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TpFinalEmpresauriosApplication implements CommandLineRunner{
	
	@Autowired
	//private BCryptPasswordEncoder passEncoder;
	

	public static void main(String[] args) {
		SpringApplication.run(TpFinalEmpresauriosApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		//String pass1 ="user";
		
		//System.out.println(passEncoder.encode(pass1));
		
	}

	/*Integrantes:
     * Nahuel Maximiliano Gaitan - "maxi1103"
     * Natanael Ever Lima Gutierrez - "natanael-lima"
     * Mateo Ignacio Loto - "LMateo42"
     * Raquel Ayelen Virreyra Ruiz - "raquelvirreyra"
     */	
}
