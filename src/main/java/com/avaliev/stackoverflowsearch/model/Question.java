package com.avaliev.stackoverflowsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    Long id;

    String title;

    String author;

    Date date;

    String url;

    Boolean isAnswered;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    public Date getDate() {
        return date;
    }

    public Long getTime() {
        return date.getTime();
    }

    public String getUrl() {
        return url;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(Long time) {
        this.date = new Date(time);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
