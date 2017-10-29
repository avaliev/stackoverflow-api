package com.avaliev.stackoverflowsearch.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Айрат on 13.08.2017.
 */
public class QuestionDeserializer extends StdDeserializer<QuestionDeserializer.Root> {




    public QuestionDeserializer() {
        super(Root.class);
    }

    @Override
    public Root deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        List<Question> questions = new LinkedList<>();
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode arrayNode = (ArrayNode) root.get("items");
        for (int i = 0; i < arrayNode.size(); i++) {
            questions.add(convertItemNode(arrayNode.get(i)));
        }
        return new Root(questions);
    }

    private Question convertItemNode(JsonNode node) {
        Question question = new Question();
        question.setDate(node.get("creation_date").asLong() * 1000);
        question.setId(node.get("question_id").asLong());
        question.setTitle(node.get("title").textValue());
        question.setUrl(node.get("link").textValue());
        question.setAnswered(node.get("is_answered").asBoolean());
        question.setAuthor(node.get("owner").get("display_name").textValue());
        return question;
    }


    public static class Root {

        public List<Question> questions;

        public Root(List<Question> questions) {
            this.questions = questions;
        }
    }

}
