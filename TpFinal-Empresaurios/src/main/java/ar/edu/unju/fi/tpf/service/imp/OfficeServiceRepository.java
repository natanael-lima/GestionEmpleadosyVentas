package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpf.model.Office;
import ar.edu.unju.fi.tpf.repository.IOfficeRepository;
import ar.edu.unju.fi.tpf.service.IOfficeService;

@Service
public class OfficeServiceRepository implements IOfficeService{

	@Autowired
	IOfficeRepository officeRepo;

	@Override
	public void guardarOffice(Office office) {
		// TODO Auto-generated method stub
	    officeRepo.save(office);
	}

	@Override
	public List<Office> obtenerOffice() {
		// TODO Auto-generated method stub
		return (List<Office>) officeRepo.findAll();
	}

	@Override
	public void eliminarOffice(Long officeCode) {
		// TODO Auto-generated method stub
		officeRepo.deleteById(officeCode);
	}

	@Override
	public Office buscarOffice(Long officeCode) {
		// TODO Auto-generated method stub
		return officeRepo.findById(officeCode).orElse(null);
	}

	
}
