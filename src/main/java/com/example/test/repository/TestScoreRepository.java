package com.example.test.repository;

import com.example.test.model.TestScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestScoreRepository extends JpaRepository<TestScore, Long> {
}
