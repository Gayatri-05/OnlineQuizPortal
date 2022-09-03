package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bean.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	
}
