package lu.atozdigital.api.services;


import org.springframework.stereotype.Service;

import lu.atozdigital.api.dto.OrderDTO;
import lu.atozdigital.api.entities.Order;

@Service
public interface OrderService {
	public OrderDTO saveOrder(OrderDTO orderDTO);
	public Order convertDtoToOrder(OrderDTO orderDTO);
    public OrderDTO convertOrderToDto(Order order);
}
