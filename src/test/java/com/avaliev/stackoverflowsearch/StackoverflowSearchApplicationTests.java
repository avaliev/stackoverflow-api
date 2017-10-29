package com.avaliev.stackoverflowsearch;

import com.avaliev.stackoverflowsearch.model.Question;
import com.avaliev.stackoverflowsearch.service.SearchQuestionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StackoverflowSearchApplicationTests {

    @Autowired
    SearchQuestionsService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testsearchRequest() {
        SearchParams params = new SearchParams();
        params.setKey("java");
        List<Question> questions = service.findQuestions(params);
    }

}
