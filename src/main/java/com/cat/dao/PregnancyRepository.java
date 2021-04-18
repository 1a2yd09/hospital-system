package com.cat.dao;

import com.cat.pojo.Pregnancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregnancyRepository extends JpaRepository<Pregnancy, Long> {

}