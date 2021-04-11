package com.hrm.bokingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrm.bokingservice.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

	Optional<DepartmentEntity> findByDepartmentName(String trim);

	List<DepartmentEntity> findByFlag(int flag);

	
	

}
