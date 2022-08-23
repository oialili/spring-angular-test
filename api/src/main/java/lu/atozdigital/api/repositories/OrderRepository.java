package lu.atozdigital.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lu.atozdigital.api.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
