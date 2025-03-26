package com.git.hub.qy.api.service;

import com.git.hub.qy.api.resp.Response;
import com.git.hub.qy.api.resp.User;

import java.util.List;

public interface UserService {
    Response<String> register(String userName, String password);

    Response<String> login(String userName, String password);

    Response<List<User>> list();

    Response<User> searchUserById(String id);

    Response<User> searchUserByUserName(String userName);

    Response<String> delete(String id);
}
