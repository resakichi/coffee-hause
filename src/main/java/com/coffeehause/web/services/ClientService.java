package com.coffeehause.web.services;

import com.coffeehause.web.entity.Client;
import com.coffeehause.web.entity.Employee;
import com.coffeehause.web.repository.ClientRepository;
import com.coffeehause.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired private ClientRepository repository;
    public void save(Client client){
        repository.save(client);
    }
}
