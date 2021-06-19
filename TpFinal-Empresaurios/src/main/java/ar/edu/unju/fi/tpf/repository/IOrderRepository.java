package ar.edu.unju.fi.tpf.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpf.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Long>{

}
