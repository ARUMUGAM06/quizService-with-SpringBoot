package com.QuizApplication.StarterProject.controller;

import com.QuizApplication.StarterProject.model.Question;
import com.QuizApplication.StarterProject.model.QuestionWrapper;
import com.QuizApplication.StarterProject.model.QuizResponse;
import com.QuizApplication.StarterProject.service.QuizService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/createQuiz")
    public ResponseEntity<String> getQuiz(@RequestParam String topic,@RequestParam int numLimit,@RequestParam String title){
        return quizService.getRandomQuestion(topic,numLimit,title);
    }
    @DeleteMapping("/deleteQuiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable("id") int id){
        return quizService.deleteQuiz(id);
    }
    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable ("id") Integer qId){
        return quizService.getQuizbyId(qId);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id,@RequestBody List<QuizResponse> responses){
        return quizService.submitQuiz(id,responses);
    }

    @GetMapping("/submit/get")
    public ResponseEntity<String> get(){
        return quizService.getData();
    }
}
