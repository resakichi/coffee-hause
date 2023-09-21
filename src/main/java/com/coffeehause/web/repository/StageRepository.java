package com.coffeehause.web.repository;

import com.coffeehause.web.entity.Role;
import com.coffeehause.web.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage, Long> {

}