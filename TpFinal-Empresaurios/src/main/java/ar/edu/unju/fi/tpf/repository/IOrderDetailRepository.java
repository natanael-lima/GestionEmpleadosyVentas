package ar.edu.unju.fi.tpf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.OrderDetail;
import ar.edu.unju.fi.tpf.model.OrderDetailId;

public interface IOrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId>{
   
}
