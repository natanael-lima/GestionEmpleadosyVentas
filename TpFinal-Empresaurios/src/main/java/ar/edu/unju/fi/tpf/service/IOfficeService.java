package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Office;

public interface IOfficeService {

    public void guardarOffice (Office office);
	
	public List<Office> obtenerOffice();
	
	public void eliminarOffice(Long officeCode);
	
	public Office buscarOffice(Long officeCode);
}
