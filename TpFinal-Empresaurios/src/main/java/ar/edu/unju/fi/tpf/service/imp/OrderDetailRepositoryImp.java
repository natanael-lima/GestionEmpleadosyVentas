package ar.edu.unju.fi.tpf.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.model.Order;
import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.OrderDetailId;
import ar.edu.unju.fi.tpf.model.Product;
import ar.edu.unju.fi.tpf.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpf.service.IOrderDetailService;

@Service
public class OrderDetailRepositoryImp implements IOrderDetailService{

	@Autowired
	IOrderDetailRepository orderDetailRepository;
	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
		
	}

	@Override
	public List<OrderDetail> obtenerOrderDetails() {
		return (List<OrderDetail>)orderDetailRepository.findAll();
	}

	@Override
	public OrderDetail buscarOrderDetail(Order orderNumber, Product productCode) {
		// TODO Auto-generated method stub
		return null;
	//	return orderDetailRepository.findById(new OrderDetailId(productCode,orderNumber)).orElse(null);
	}

	@Override
	public void eliminarOrderDetail(Order orderNumber, Product productCode) {
		
	   orderDetailRepository.delete(buscarOrderDetail(orderNumber,productCode));
		
	}

	

}
