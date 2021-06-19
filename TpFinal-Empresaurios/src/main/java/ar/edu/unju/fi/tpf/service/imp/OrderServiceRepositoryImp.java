package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.repository.IOrderRepository;
import ar.edu.unju.fi.tpf.service.IOrderService;

@Service
public class OrderServiceRepositoryImp implements IOrderService{
    
	@Autowired
	IOrderRepository orderRepository;

	@Override
	public void guardarOrder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public List<Order> obtenerOrders() {
		// TODO Auto-generated method stub
		return (List<Order>)orderRepository.findAll();
	}

	@Override
	public Order buscarOrder(long orderNumber) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderNumber).orElse(null);
	}

	@Override
	public void eliminarOrder(long orderNumber) {
		orderRepository.deleteById(orderNumber);
		
	}
	 
	

}
