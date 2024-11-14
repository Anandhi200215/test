package com.example.test.controller;

import com.example.test.model.TestScore;
import com.example.test.service.TestScoreService;
import com.example.test.repository.TestScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test-scores")
public class TestScoreController {

    @Autowired
    private TestScoreService testScoreService;

    @Autowired
    private TestScoreRepository testScoreRepository;

    // POST endpoint to save test score and calculate depression level
    @PostMapping
    public ResponseEntity<Map<String, Object>> submitTestScore(@RequestBody TestScore testScore) {
        // Step 1: Calculate the depression level based on the score using service
        String depressionLevel = testScoreService.getDepressionLevel(testScore.getScore());

        // Step 2: Set the calculated depression level in the testScore object
        testScore.setDepressionLevel(depressionLevel);

        // Step 3: Save the test score to the database
        TestScore savedTestScore = testScoreRepository.save(testScore);

        // Step 4: Get recommendations based on depression level using service
        String[] recommendations = testScoreService.getRecommendations(depressionLevel);

        // Step 5: Prepare the response data
        Map<String, Object> response = Map.of(
                "score", savedTestScore.getScore(),
                "depressionLevel", depressionLevel,
                "recommendations", recommendations
        );

        // Return the response with the score, depression level, and recommendations
        return ResponseEntity.ok(response);
    }
}
