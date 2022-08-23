package lu.atozdigital.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.dto.OrderDTO;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repositories.OrderRepository;
import lu.atozdigital.api.services.OrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping(path = "")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }
	
	@GetMapping(path = "")
    public List<OrderDTO> getAllOrders() {
        return orderService.allOrders();
    }
	
	@PutMapping(path = "")
    public Order editOrder(@RequestBody OrderDTO orderDTO) {
		Order order  = orderService.convertDtoToOrder(orderDTO);
        return orderRepository.save(order);
    }

}
