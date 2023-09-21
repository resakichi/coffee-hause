package com.coffeehause.web.services;

import com.coffeehause.web.entity.Order;
import com.coffeehause.web.entity.Stage;
import com.coffeehause.web.exception.NotFoundException;
import com.coffeehause.web.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;
    public Order findOrder(Integer id) throws NotFoundException {
        Optional<Order> result = orderRepository.findById(Long.valueOf(id));
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("Заказ № " + id + " не найден");
    }
    public List<Order> allOrder(){return orderRepository.findAll();}
    public void save(Order order){
        orderRepository.save(order);
    }
    public void updateStage(Stage stage, int order_id){
        orderRepository.updateOrderStage(stage, order_id);
    }
}
