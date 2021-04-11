package com.hrm.bokingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrm.bokingservice.entity.FeedbackEntity;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
	
	Optional<FeedbackEntity> findByFeedbackId(Long id);

	List<FeedbackEntity> findByDepartmetId(int id);


}
