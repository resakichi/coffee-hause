package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Employee;
import com.coffeehause.web.entity.Event;
import com.coffeehause.web.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT ev FROM Event ev JOIN ev.order_id ord WHERE ord.order_id = ?1")
    List<Event> findEventByOrderId(Long value);
}

// "SELECT new UserServiceDTO(u.name, s.userName) FROM User u LEFT OUTER JOIN Service s where u.name LIKE :userName");
//SELECT new UserServiceDTO(u.name, s.serviceName) FROM User u LEFT OUTER JOIN u.service s WHERE u.name LIKE :userName