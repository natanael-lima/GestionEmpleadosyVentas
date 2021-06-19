package ar.edu.unju.fi.tpf.service;

import java.util.List;

import ar.edu.unju.fi.tpf.model.Order;

public interface IOrderService {
	public void guardarOrder(Order order);
	
	public List<Order> obtenerOrders();
	
	public Order buscarOrder(long orderNumber);
	
	public void eliminarOrder(long orderNumber);
	
}
