package com.demo2.demo2.LoanApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.demo2.JDBC.DatabaseAccessor;

@Service
public class GetLoanAppService {

    @Autowired
    private DatabaseAccessor databaseAccessor;

    public String getDataFromDatabase() {
        String query = "SELECT TOP(10) *FROM tblLoanApp1";
        return databaseAccessor.accessDatabase(query);
    }

    // Other methods...
}