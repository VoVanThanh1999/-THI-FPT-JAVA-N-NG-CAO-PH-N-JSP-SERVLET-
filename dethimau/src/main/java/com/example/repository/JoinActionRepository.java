package com.example.repository;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.JoinAction;

@Repository
public interface JoinActionRepository extends JpaRepository<JoinAction, Integer>{
	
	@Query("Select j from JoinAction as j order by j.pointLeader")
	List<JoinAction> loadAllBySortPointLeader();
}
