package com.demo2.demo2.Post.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.demo2.IService.IService;
import com.demo2.demo2.JDBC.DatabaseAccessor;
import com.demo2.demo2.Post.Models.MyResponse;
import com.demo2.demo2.Post.Models.PostModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService implements IService<PostModel>{

    @Autowired
    private DatabaseAccessor databaseAccessor;

    @Override
    public PostModel post(PostModel model) {
        try {
            String sql = "DECLARE @success bit, @message nvarchar(100); " +
                    "EXEC [dbo].[InsertToTblPost] " +
                    "@id =" + model.getId() + "," +
                    "@title = " + model.getTitle() + "," +
                    "@createdBy =" + model.getCreatedBy() + "," +
                    "@description = " + model.getDescription() + "," +
                    "@success = @success OUTPUT, " +
                    "@message = @message OUTPUT; " +
                    "SELECT @success AS 'success', @message AS 'message';";

            String jsonString = databaseAccessor.accessDatabase(sql);

            ObjectMapper objectMapper = new ObjectMapper();
            MyResponse[] response = objectMapper.readValue(jsonString, MyResponse[].class);

            return model;
        } catch (Exception e) {
            MyResponse[] res = new MyResponse[1];
            res[0].setSuccess(false);
            res[0].setMessage(e.getMessage());
            return model;
        }
    }

    @Override
    public PostModel[] get() {
         try {
            String sql = "EXEC GetAllTblPost";
            String jsonString = databaseAccessor.accessDatabase(sql);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            PostModel[] responses = objectMapper.readValue(jsonString, PostModel[].class);
            return responses;
        } catch (Exception e) {
            PostModel[] res = new PostModel[1];
            return res;
        }
    }

    @Override
    public String test() {
       return "Post Service";
    }

    
}