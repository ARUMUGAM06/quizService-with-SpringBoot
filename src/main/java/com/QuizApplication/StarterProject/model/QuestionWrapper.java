package com.QuizApplication.StarterProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class QuestionWrapper {
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String category;
}
