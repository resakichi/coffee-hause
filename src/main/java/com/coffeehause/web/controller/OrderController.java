package com.coffeehause.web.controller;

import com.coffeehause.web.entity.*;
import com.coffeehause.web.proxyClass.CreateOrder;
import com.coffeehause.web.repository.*;
import com.coffeehause.web.services.ClientService;
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
public class OrderController {
    @Autowired
    private OrderServices servicesOrder;
    @Autowired
    private ClientService clientService;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final EventRepository eventRepository;
    private final StageRepository stageRepository;
    private final  EmployeeRepository employeeRepository;

    OrderController(OrderRepository orderRepository, ProductRepository productRepository,
                    EventRepository eventRepository, StageRepository stageRepository,
                    EmployeeRepository employeeRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.eventRepository = eventRepository;
        this.stageRepository = stageRepository;
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/order/create")
    public String newOrder(Map<String, Object> model){
        model.put("order", new Order());
        model.put("client", new Client());
        model.put("queryOrder", new CreateOrder());
        List<Product> productList = productRepository.findAll();
        for (Product product:
             productList) {
            Calendar time = Calendar.getInstance();
            time.add(Calendar.MINUTE, product.getCook_time().getMinutes());
            Time new_ts = new Time(time.getTime().getTime());
            product.setCook_time(new_ts);
        }
        model.put("productList", productList);
        return "order_form.html";
    }
    @PostMapping("/order/save")
    public String saveOrder(CreateOrder createOrder,
                            RedirectAttributes rd){
//      CLIENT
        Client client = new Client();
        client.setName(createOrder.client_name);
        clientService.save(client);

//      ORDER
        Order order = new Order();
        Time time = new Time(System.currentTimeMillis());
        order.setClient_id(client);
        order.setCreate_time(time);
        order.setStage(stageRepository.getById(1L));
        servicesOrder.save(order);
//      EVENT
        Event event = new Event();
        event.setClient_id(client);
        event.setStage(stageRepository.getById(1L));

        int randEmployee = (int) (Math.random() * (4 - 2)) + 2;
        event.setEmployee_id(employeeRepository.getById(Long.valueOf(randEmployee)));
        event.setOrder_id(order);

        List<Product> productList = productRepository.findAll();
        event.setProduct_id(productList.get(createOrder.product_id));
        Calendar currentTime = Calendar.getInstance();
        time = new Time(currentTime.getTime().getTime());
        event.setTime(time);

        currentTime.add(Calendar.MINUTE, productList.get(createOrder.product_id).getCook_time().getMinutes());
        time = new Time(currentTime.getTime().getTime());
        event.setDelivery_time(time);
        eventRepository.save(event);
        rd.addFlashAttribute("message", "Заказ успешно создан.");
//        создать страницу с номером заказа
        return "redirect:/";
    }
}
