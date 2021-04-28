package com.xupt.servicestu.service;

import java.util.Map;

public interface LoginService {

    public Map<String,Object> adminLogin(String username, String password);

    public Map<String,Object> teacherLogin(String username, String password);

    public Map<String,Object> studentLogin(String username, String password);
}
