package com.coffeehause.web.controller;

import com.coffeehause.web.entity.Event;
import com.coffeehause.web.entity.Order;
import com.coffeehause.web.entity.Product;
import com.coffeehause.web.entity.Stage;
import com.coffeehause.web.exception.NotFoundException;
import com.coffeehause.web.proxyClass.CreateEvent;
import com.coffeehause.web.repository.*;
import com.coffeehause.web.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {
    @Autowired
    private OrderServices orderServices;
    private final EventRepository eventRepository;
    private final StageRepository stageRepository;
    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;

    EventController(EventRepository eventRepository, StageRepository stageRepository,
                    OrderRepository orderRepository, EmployeeRepository employeeRepository,
                    ProductRepository productRepository){
        this.eventRepository = eventRepository;
        this.stageRepository = stageRepository;
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/event/{id}")
    public String showEvent(@PathVariable("id") Integer id, Map<String, Object> model, RedirectAttributes ra){
        try{
            Order order = orderServices.findOrder(id);

            CreateEvent event = new CreateEvent();
            model.put("event", event);
            List<Stage> stageList = null;
            Stage stage = null;
            if (order.getStage().getStage_id().intValue() != 2 &&
                    order.getStage().getStage_id().intValue() != 5){
                System.out.println("fuck"+order.getStage().getStage_id().intValue());
                stageList = stageRepository.findAll();
                for (int i = 0; i < stageList.size(); i++) {
                    stage = stageList.get(i);
                    if (order.getStage().equals(stage) || stage.getStage_id().intValue() == 1){
                        stageList.remove(stage);
                    }
                }
            }
            model.put("stageList", stageList);
            model.put("order", order);
            model.put("path", "");
            List<Event> events = eventRepository.findEventByOrderId(order.getOrder_id());
            model.put("events", events);
            return "event.html";
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/events")
    public String showEvents(Map<String, Object> model){
        List<Event> eventList = eventRepository.findAll();
        model.put("orderList", orderServices.allOrder());
        model.put("eventList", eventList);
        return "eventsList.html";
    }
    @PostMapping("/event")
    @ResponseBody
    public String newEvent(@RequestParam(name="order_id") int orderId,
                           @RequestParam (name="reason") String reason,
                           @RequestParam(name="product_id") int productId,
                           @RequestParam(name = "stage_id") int stageId,
                           @RequestParam(name="delivery_time") Time deliveryTime){
        Stage stage = stageRepository.getById(Long.valueOf(stageId));
        orderServices.updateStage(stage, orderId);
        Order order = orderRepository.getById(Long.valueOf(orderId));

        Event event = new Event();
        event.setClient_id(order.getClient_id());
        event.setStage(stage);
        int randEmployee = (int) (Math.random() * (4 - 2)) + 2;
        event.setEmployee_id(employeeRepository.getById(Long.valueOf(randEmployee)));
        event.setOrder_id(order);

        Product product = productRepository.getById(Long.valueOf(productId));
        event.setProduct_id(product);
        Calendar currentTime = Calendar.getInstance();
        Time time = new Time(currentTime.getTime().getTime());
        event.setTime(time);
        event.setDelivery_time(deliveryTime);
        eventRepository.save(event);
        return "redirect:/event/" + orderId;
    }
}
