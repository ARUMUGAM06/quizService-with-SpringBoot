package com.QuizApplication.StarterProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResponse {
    private Integer id;
    private String answer;
}
