package lu.atozdigital.api.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.atozdigital.api.dto.OrderDTO;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.repositories.OrderRepository;
import lu.atozdigital.api.services.OrderService;

@Service
public class OrderServiceImplement implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Override
    public Order convertDtoToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		Article article = articleRepository.findByName(orderDTO.getArticle());
		
		order.setId(order.getId());
		order.setReference(orderDTO.getReference());
		order.setDate(orderDTO.getDate());
		order.setArticle(article);
        return order;
    }
	
	@Override
    public OrderDTO convertOrderToDto(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setReference(order.getReference());
		orderDTO.setDate(order.getDate());
		orderDTO.setArticle(order.getArticle().getName());    
        return orderDTO;
    }
	
	@Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
		Order order  = convertDtoToOrder(orderDTO);
        return convertOrderToDto(orderRepository.save(order));
    }
	
	@Override
    public List<OrderDTO> allOrders(){
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTO = new ArrayList<>();
        orders.forEach(order -> {
        	orderDTO.add(convertOrderToDto(order));
        });
        return orderDTO;
    }

}
