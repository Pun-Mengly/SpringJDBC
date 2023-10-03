package com.demo2.demo2.JDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class DatabaseAccessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String accessDatabase(String query) {
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
            System.out.println("Results: " + rows);
            ObjectMapper objectMapper = new ObjectMapper();
            List<ObjectNode> jsonList = new ArrayList<>();

            for (Map<String, Object> row : rows) {
                ObjectNode json = objectMapper.createObjectNode();
                for (Map.Entry<String, Object> entry : row.entrySet()) {
                    json.set(entry.getKey(), objectMapper.valueToTree(entry.getValue()));
                }
                jsonList.add(json);
            }
            String jsonString = objectMapper.writeValueAsString(jsonList);
            return jsonString;

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    // Other methods...
}