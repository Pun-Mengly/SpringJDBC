package com.demo2.demo2.LoanApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.LoanApp.Services.GetLoanAppByIdService;
import com.demo2.demo2.LoanApp.Services.GetLoanAppService;

@RestController
public class LoanAppController {
    @Autowired
    private GetLoanAppService repo;
    @Autowired
    private GetLoanAppByIdService getById;

    @GetMapping("/get-loan-apps")
    public String getLoanApps() {
        return repo.getDataFromDatabase();
    }

    @GetMapping("/get-loan-app/{id}")
    public String getLoanAppById(@PathVariable String id) {
        return getById.getDataByIdFromDatabase(id);
    }
}