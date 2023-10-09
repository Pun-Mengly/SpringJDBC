package com.demo2.demo2.Post.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.demo2.JDBC.DatabaseAccessor;
import com.demo2.demo2.Post.Models.MyResponse;
import com.demo2.demo2.Post.Models.PostModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {

    @Autowired
    private DatabaseAccessor databaseAccessor;

    public MyResponse[] postDataToDataBase(PostModel model) {

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

            return response;
        } catch (Exception e) {
            MyResponse[] res = new MyResponse[1];
            res[0].setSuccess(false);
            res[0].setMessage(e.getMessage());
            return res;
        }

    }

    public PostModel[] getDataFromDataBase() {

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

    // Other methods...
}