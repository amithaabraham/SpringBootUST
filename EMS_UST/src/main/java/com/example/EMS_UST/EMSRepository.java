package com.example.EMS_UST;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EMSRepository extends JpaRepository<EMS, String>,EMSRepositoryCustom{


}