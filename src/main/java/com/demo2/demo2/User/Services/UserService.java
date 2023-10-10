package com.demo2.demo2.User.Services;

import org.springframework.stereotype.Component;

import com.demo2.demo2.IService.IService;

@Component
class UserService implements IService<String> {

    @Override
    public String post(String t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }

    @Override
    public String[] get() {
        String[] users = new String[3];
        users[0] = "Mengly";
        users[1] = "Jitra";
        users[2] = "Tola";
        return users;
    }

    @Override
    public String test() {
       return "User Service";
    }

}