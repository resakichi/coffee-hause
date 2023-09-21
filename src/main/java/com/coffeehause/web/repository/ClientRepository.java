package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Client;
import com.coffeehause.web.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}