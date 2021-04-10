package com.yxs.blog.myblog.auth.controller;

import com.yxs.blog.common.base.domain.Result;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;
import com.yxs.blog.myblog.auth.service.OauthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private OauthService oauthService;

    /**
     * create by: Yxs
     * description:管理员登陆
     * create time: 20:33 2021/4/5
     * @param : AuthUserVO
     * @return
     */
    @PostMapping("/admin/v1/login")
    public Result adminLogin(@RequestBody AuthUserVO authUserVO) {
        return oauthService.login(authUserVO);
    }
}
