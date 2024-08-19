package com.QuizApplication.StarterProject.DAO;

import com.QuizApplication.StarterProject.model.Question;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
    List<Question> getQuestionByCategory(String category);

    @Query(nativeQuery = true,value = "Select * from Question q where q.category=:topic order by rand() limit :numLimit")
    List<Question> findByRandom(String topic,int numLimit);

    @Query(nativeQuery = true,value = "SELECT json_arrayagg(json_object('quiz_id',quiz_id,'question_question_id',question_question_id)) FROM quizapplication.quiz_question")
    String ret();

}
