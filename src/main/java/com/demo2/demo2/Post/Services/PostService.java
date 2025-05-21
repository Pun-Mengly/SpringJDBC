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
public class PostService implements IService<MyResponse,PostModel>{

    @Autowired
    private DatabaseAccessor databaseAccessor;

    @Override
    public MyResponse post(PostModel model) {
        try {
            String sql ="EXEC [dbo].sp_insertToTblPost " +
                    "@id =" + model.getId() + "," +
                    "@title = " + model.getTitle() + "," +
                    "@createdBy =" + model.getCreatedBy() + "," +
                    "@description = " + model.getDescription();

            String jsonString = databaseAccessor.accessDatabase(sql);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            MyResponse[] response = objectMapper.readValue(jsonString, MyResponse[].class);
            
            return response[0];
        } catch (Exception e) {
            MyResponse[] res = new MyResponse[1];
            res[0].setSuccess(false);
            res[0].setMessage(e.getMessage());
            return res[0];
        }
    }

    @Override
    public PostModel[] get() {
         try {
            String sql = "EXEC sp_getAllTblPost";
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
    public String welcome() {
       return "Post Service";
    }

    
}