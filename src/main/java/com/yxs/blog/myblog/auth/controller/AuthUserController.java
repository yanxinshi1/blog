package com.yxs.blog.myblog.auth.controller;

import com.byteblogs.helloblog.integration.dto.UserDTO;
import com.yxs.blog.common.base.domain.Result;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;
import com.yxs.blog.myblog.auth.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
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

    /**
     * create by: Yxs
     * description:注册
     * create time: 15:16 2021/4/13
     * @return
     */
    @PostMapping("/admin/v1/register")
    public Result adminRegister(@RequestBody UserDTO userDTO){ return oauthService.registerAdmin(userDTO);}


}
