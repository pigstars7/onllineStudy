package com.xupt.servicestu.controller;


import com.wf.captcha.SpecCaptcha;
import com.xupt.commonutils.R;
import com.xupt.servicebase.exceptionhandler.ZxException;
import com.xupt.servicestu.entity.Login;
import com.xupt.servicestu.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuxingxin
 * @since 2021-03-07
 */
@RestController
@CrossOrigin
@RequestMapping("/onlinestudy/")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    //登录
    @PostMapping("login")
    public R loginStudent(@RequestBody Login login, HttpServletRequest request) {
        String userId = login.getUserId();
        String password = login.getPassword();
        String captcha = login.getCaptchaCode();
        String sessionCode = request.getSession().getAttribute("CAPTCHA").toString();
        System.out.println("sssssss" + request.getSession().getAttribute("CAPTCHA") + request.getSession().getId());
        if (!captcha.equalsIgnoreCase(sessionCode)) {
            throw new ZxException(-1, "验证码错误");
        }
        Map<String,Object> adminRes = loginService.adminLogin(userId, password);
        if (adminRes != null) {
            return R.ok().data("user", adminRes);
        }

        Map<String,Object> teacherRes = loginService.teacherLogin(userId, password);
        if (teacherRes != null) {
            return R.ok().data("user", teacherRes);
        }

        Map<String,Object> studentRes = loginService.studentLogin(userId, password);
        if (studentRes != null) {
            return R.ok().data("user", studentRes);
        }
            return R.error().message("账号或密码错误");
    }

    //获取验证码
    @GetMapping("captcha")
    public R captcha(HttpServletRequest request, HttpServletResponse response) {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 40, 5);
        String verCode = specCaptcha.text().toLowerCase();
        request.getSession().setAttribute("CAPTCHA",verCode);  //存入session
        System.out.println("tttttttttt" + request.getSession().getAttribute("CAPTCHA") + request.getSession().getId());
        return R.ok().data("captcha", specCaptcha.toBase64());
    }


}

