package com.QuizApplication.StarterProject.controller;

import com.QuizApplication.StarterProject.model.Question;
import com.QuizApplication.StarterProject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @RequestMapping("/allQuestions")
    public ResponseEntity<List<Question>> getQuestions(){
        return questionService.getQuestions();
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PutMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> DeleteQuestion(@PathVariable("id") int questionId ){
        return questionService.deleteQuestion(questionId);
    }
}
