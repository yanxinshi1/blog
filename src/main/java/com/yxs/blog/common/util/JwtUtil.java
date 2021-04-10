package com.yxs.blog.common.util;

import com.auth0.jwt.algorithms.Algorithm;
import com.yxs.blog.common.constant.Constants;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;
import com.auth0.jwt.JWT;

import java.util.Date;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/10 15:34
 */
public class JwtUtil {
    /**
     * create by: Yxs
     * description:
     * create time: 15:35 2021/4/10
     * @param authUserVO
     * @return java.lang.String
     */
    public static String getToken(AuthUserVO authUserVO){
        String sign = authUserVO.getPassword();
        return JWT.create().withExpiresAt(new Date(System.currentTimeMillis() + Constants.EXPIRE_TIME)).withAudience(JsonUtil.toJsonString(authUserVO.setPassword(null)))
                .sign(Algorithm.HMAC256(sign));
    }
}
