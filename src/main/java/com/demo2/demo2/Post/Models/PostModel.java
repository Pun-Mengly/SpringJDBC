package com.demo2.demo2.Post.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostModel {
    @JsonProperty("id")
    private int Id;
    @JsonProperty("title")
    private String Title;
    @JsonProperty("createdBy")
    private String CreatedBy;
    @JsonProperty("description")
    private String Description;

}