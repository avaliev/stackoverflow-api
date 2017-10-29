package com.avaliev.stackoverflowsearch.service;

import com.avaliev.stackoverflowsearch.SearchParams;
import com.avaliev.stackoverflowsearch.model.Question;
import com.avaliev.stackoverflowsearch.model.QuestionDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Айрат on 13.08.2017.
 */
@Service
public class SearchQuestionsService {

    public static final String endpoint = "http://api.stackexchange.com/2.2/search";

    @Autowired
    RestTemplate restTemplate;


    public List<Question> findQuestions(SearchParams params) {
        String queryStr = buildQueryString(params);

        QuestionDeserializer.Root object =
                restTemplate.getForObject(queryStr, QuestionDeserializer.Root.class);

        return object.questions;
    }


    private String buildQueryString(SearchParams params) {
        StringBuilder stringBuilder = new StringBuilder(endpoint);
        stringBuilder.append('?')
                .append("pagesize=50&")
                .append("order=desc&sort=")
                .append(params.getSort()).append('&')
                .append("intitle=").append(params.getKey()).append('&')
                .append("site=stackoverflow");

        return stringBuilder.toString();
    }
}
