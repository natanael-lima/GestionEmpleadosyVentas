package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.Product;

public interface IOrderDetailService {
	
	public void guardarOrderDetail(OrderDetail orderDetail);
	
	public List<OrderDetail> obtenerOrderDetails();
	
	
	public void eliminarOrderDetail(Order orderNumber,Product productCode);

	public OrderDetail buscarOrderDetail(Order orderNumber, Product productCode);
}
