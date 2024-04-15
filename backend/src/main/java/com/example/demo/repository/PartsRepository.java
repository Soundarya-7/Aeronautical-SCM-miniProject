package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Parts;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Integer> {

}
