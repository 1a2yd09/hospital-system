package com.cat.dao;

import com.cat.pojo.Serum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerumRepository extends JpaRepository<Serum, Long> {

}