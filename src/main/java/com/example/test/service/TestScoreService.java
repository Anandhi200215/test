package com.example.test.service;


import org.springframework.stereotype.Service;

@Service
public class TestScoreService {

    // Define score ranges for depression levels
    private static final String MINIMAL_DEPRESSION = "Minimal depression";
    private static final String MILD_DEPRESSION = "Mild depression";
    private static final String MODERATE_DEPRESSION = "Moderate depression";
    private static final String SEVERE_DEPRESSION = "Severe depression";
    private static final String EXTREME_DEPRESSION = "Extreme depression";

    // Method to calculate depression level based on score
    public String getDepressionLevel(int score) {
        if (score >= 0 && score <= 5) {
            return MINIMAL_DEPRESSION;
        } else if (score >= 6 && score <= 10) {
            return MILD_DEPRESSION;
        } else if (score >= 11 && score <= 25) {
            return MODERATE_DEPRESSION;
        } else if (score >= 26 && score <= 50) {
            return SEVERE_DEPRESSION;
        } else {
            return EXTREME_DEPRESSION;
        }
    }

    // Method to return recommendations based on depression level
    public String[] getRecommendations(String depressionLevel) {
        return switch (depressionLevel) {
            case MINIMAL_DEPRESSION -> new String[]{
                    "Continue practicing self-care and maintaining a healthy lifestyle.",
                    "Engage in regular exercise and maintain a balanced diet.",
                    "Practice mindfulness or meditation to manage stress."
            };
            case MILD_DEPRESSION -> new String[]{
                    "Consider talking to a trusted friend or family member about your feelings.",
                    "Explore self-help books or online resources on managing mood.",
                    "Establish a regular sleep schedule and prioritize getting enough rest."
            };
            case MODERATE_DEPRESSION -> new String[]{
                    "Consider seeking professional help from a therapist or counselor.",
                    "Look into cognitive-behavioral therapy (CBT) techniques.",
                    "Ensure you're maintaining social connections and not isolating yourself."
            };
            case SEVERE_DEPRESSION -> new String[]{
                    "Strongly recommend consulting with a mental health professional.",
                    "Consider discussing medication options with a psychiatrist.",
                    "Ensure you have a support system in place and don't hesitate to reach out for help."
            };
            case EXTREME_DEPRESSION -> new String[]{
                    "Urgent: Please seek immediate professional help from a mental health expert.",
                    "Contact a crisis helpline if you're having thoughts of self-harm.",
                    "Consider inpatient treatment options for intensive care and support."
            };
            default -> new String[]{};
        };
    }
}
