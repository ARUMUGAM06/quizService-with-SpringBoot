package com.QuizApplication.StarterProject.service;


import com.QuizApplication.StarterProject.DAO.QuestionDAO;
import com.QuizApplication.StarterProject.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getQuestions(){
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category){
        try{
            return new ResponseEntity<>(questionDAO.getQuestionByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        try{
            questionDAO.save(question);
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int questionId) {
         try {
             questionDAO.deleteById(questionId);
             return new ResponseEntity<>("Deleted Successfully question no " + questionId,HttpStatus.OK);
         }catch (Exception e){
             e.printStackTrace();
         }return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }
}
