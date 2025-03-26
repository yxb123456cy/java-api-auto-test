package com.git.hub.qy.api.service.impl;

import cn.hutool.core.util.IdUtil;
import com.git.hub.qy.api.resp.Response;
import com.git.hub.qy.api.resp.User;
import com.git.hub.qy.api.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final List<User> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {
            String uuid = IdUtil.fastSimpleUUID();
            User user = User.builder()
                    .ID(uuid)
                    .userName("jdk"+(i+1)+"jj")
                    .name("JAVA高手" + (i + 1) + "号")
                    .password("123456").build();
            list.add(user);
        }
    }

    @Override
    public Response<String> register(String userName, String password) {
        String uuid = IdUtil.fastSimpleUUID();
        User user = User.builder().ID(uuid).userName(userName).password(password).build();
        list.add(user);
        log.info("新增User:{}",user);
        return Response.success("ok");
    }

    @Override
    public Response<String> login(String userName, String password) {
        User dbUser = list.stream().distinct().filter(user -> user.getUserName().equals(userName))
                .findFirst().orElse(null);
        if (dbUser != null) {
            if (dbUser.getPassword().equals(password)) return Response.success("ok");
            else return Response.fail("密码错误");
        } else {
            log.error("error,用户不存在");
            return Response.fail("error,用户不存在");
        }
    }

    @Override
    public Response<List<User>> list() {
        return Response.success(list);
    }

    @Override
    public Response<User> searchUserById(String id) {
        User data = list.stream().distinct().filter(user -> user.getID().equals(id))
                .findFirst().orElse(null);
        log.info("根据ID查询到User:{}",data);
        return Response.success(data);
    }

    @Override
    public Response<User> searchUserByUserName(String userName) {
        User data = list.stream().distinct().filter(user -> user.getUserName().equals(userName))
                .findFirst().orElse(null);
        log.info("根据UserName查询到User:{}",data);
        return Response.success(data);
    }

    @Override
    public Response<String> delete(String id) {
        boolean data = false;
        for (User user : list) {
            if (user.getID().equals(id)) {
                data = list.remove(user);
                break;
            }
        }
        return data ? Response.success("ok") : Response.fail("not found");
    }
}
