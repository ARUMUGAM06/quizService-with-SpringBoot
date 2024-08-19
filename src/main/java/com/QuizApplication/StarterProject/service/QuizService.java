package com.QuizApplication.StarterProject.service;

import com.QuizApplication.StarterProject.DAO.QuestionDAO;
import com.QuizApplication.StarterProject.DAO.QuizDao;
import com.QuizApplication.StarterProject.model.Question;
import com.QuizApplication.StarterProject.model.QuestionWrapper;
import com.QuizApplication.StarterProject.model.Quiz;
import com.QuizApplication.StarterProject.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> getRandomQuestion(String topic,int numLimit,String title) {
        List<Question> questions=questionDAO.findByRandom(topic,numLimit);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
    public ResponseEntity<String> deleteQuiz(int id){
        quizDao.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(Integer qId) {
        Optional<Quiz> quiz=quizDao.findById(qId);
        List<Question> questionOnDB=quiz.get().getQuestion();
        List<QuestionWrapper> question=new ArrayList<>();
        for(Question ques: questionOnDB ){
            question.add(new QuestionWrapper(ques.getQuestionTitle(),ques.getOption1(),ques.getOption2(),ques.getOption3(),ques.getOption4(),ques.getCategory()));
        }
        return new ResponseEntity<>(question,HttpStatus.OK);
    }

    public ResponseEntity<String> submitQuiz(Integer id, List<QuizResponse> responses) {
        int count=0,i=0;
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questions=quiz.get().getQuestion();
        for(QuizResponse response: responses){
            if(response.getAnswer().equals(questions.get(i).getCorrectAnswer()))
                count++;
            i++;
        }
        return new ResponseEntity<>("your Score was "+count,HttpStatus.OK);
    }

    public ResponseEntity<String> getData(){
        return  new ResponseEntity<String>(questionDAO.ret(),HttpStatus.OK);
    }
}
