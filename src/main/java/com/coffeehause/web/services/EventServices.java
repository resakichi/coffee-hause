package com.coffeehause.web.services;

import com.coffeehause.web.entity.Event;
import com.coffeehause.web.entity.Order;
import com.coffeehause.web.exception.NotFoundException;
import com.coffeehause.web.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EventServices {
    @Autowired
    private EventRepository eventRepository;
}
