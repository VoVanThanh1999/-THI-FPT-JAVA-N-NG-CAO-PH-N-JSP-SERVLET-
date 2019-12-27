package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{
	
	
}
