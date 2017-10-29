package com.avaliev.stackoverflowsearch;

import com.avaliev.stackoverflowsearch.model.Question;
import com.avaliev.stackoverflowsearch.service.SearchQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Айрат on 12.08.2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    SearchQuestionsService service;

    @RequestMapping("search")
    public List<Question> hello(@RequestParam("key") String key) {
        SearchParams params = new SearchParams();
        params.setKey(key);
        List<Question> list = service.findQuestions(params);
        return list;
    }
}
