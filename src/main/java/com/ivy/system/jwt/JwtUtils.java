package com.ivy.system.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ivy.admin.entity.ivy.User;

public class JwtUtils {

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        return JWT.create().withAudience(user.getEmail()).sign(Algorithm.HMAC256(user.getPassword()));
    }

}
