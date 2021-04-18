package com.cat.dao;

import com.cat.pojo.HealthCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCardRepository extends JpaRepository<HealthCard, Long> {

}