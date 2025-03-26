package com.git.hub.qy.api.ctl;

import com.git.hub.qy.api.resp.Response;
import com.git.hub.qy.api.resp.User;
import com.git.hub.qy.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TestApiController {
    private final UserService userService;

    //注册(新增user);
    @PostMapping("/register")
    public Response<String> register(@RequestParam("userName")String userName,@RequestParam("password")String password) {
        return userService.register(userName,password);
    }

    //登录;
    @PostMapping("/login")
    public Response<String> login(@RequestParam("userName")String userName,@RequestParam("password")String password) {
        return userService.login(userName,password);
    }

    //查询所有; 判断状态码以及success;
    @GetMapping("/list")
    public Response<List<User>> list() {
        //jdk1jj
        return userService.list();
    }
    //通过ID查询;
    @GetMapping("/{id}")
    public Response<User> searchUserById(@PathVariable("id")String id) {
        return userService.searchUserById(id);
    }
    //通过UserName查询;
    @GetMapping("/get")
    public Response<User> searchUserByUserName(@RequestParam("userName")String userName) {
        return userService.searchUserByUserName(userName);
    }
    //删除 通过ID删除; delete
    @DeleteMapping("/{id}")
    public Response<String> delete(@PathVariable("id")String id) {
        return userService.delete(id);
    }
}
