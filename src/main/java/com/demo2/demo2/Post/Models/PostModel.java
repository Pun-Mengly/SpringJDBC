package com.demo2.demo2.Post.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostModel {
    @JsonProperty("Id")
    private int Id;
    @JsonProperty("Tiltle")
    private String Title;
    @JsonProperty("CreatedBy")
    private String CreatedBy;
    @JsonProperty("Description")
    private String Description;

}