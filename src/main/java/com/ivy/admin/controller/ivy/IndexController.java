package com.ivy.admin.controller.ivy;

import com.ivy.admin.aspect.log.Log;
import com.ivy.admin.entity.ivy.User;
import com.ivy.admin.service.ivy.UserService;
import com.ivy.admin.utils.ResultMsg;
import com.ivy.admin.vo.ivy.UserVo;
import com.ivy.system.jwt.JwtUtils;
import com.ivy.tools.sys.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: Administrator
 * @date: 2020-12-16
 */
@RestController
@RequestMapping("/auth")
public class IndexController {

    @Autowired
    private UserService userService;

    @Log("sys.User")
	@PostMapping("/getToken")
    public ResultMsg getToken(@RequestBody UserVo userVo, HttpServletRequest request, HttpServletResponse response){
        if (StringUtils.isBlank(userVo.getEmail()) || StringUtils.isBlank(userVo.getPassword())){
            return ResultMsg.failed("用户名或密码不能为空!");
        }
        userVo.setPassword(MD5Utils.md5(userVo.getPassword()));
        userVo.setEnable(true);
        User user = userService.selectOne(userVo);
        if(user == null){
            return ResultMsg.failed("用户未注册!");
        }
        String accessToken = JwtUtils.getToken(user);

        //页面提交上来的时候，是否选择了自动登录
        if(userVo.getRememberMe() != null && userVo.getRememberMe()) {
            //发送cookie给客户端
            Cookie cookie = new Cookie("ivy_auto_login", accessToken);
            cookie.setMaxAge(60 * 60 * 24 * 7);//7天有效期
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }

        Map<String,Object> userData = new HashMap<>();
        userData.put("username",user.getUsername());
        userData.put("email",user.getEmail());
        userData.put("userRole", "admin");

        Map<String,Object> data = new HashMap<>();
        data.put("accessToken",accessToken);
        data.put("userData",userData);
        return ResultMsg.success(data);
    }


	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @PostMapping("/insert")
    public ResultMsg insert(User user){
        if(user == null){
            return ResultMsg.failed();
        }
        int i = userService.insert(user);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

}
