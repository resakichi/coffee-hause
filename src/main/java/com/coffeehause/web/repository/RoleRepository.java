package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Product;
import com.coffeehause.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}