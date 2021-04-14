package com.yxs.blog.myblog.auth.service;

import com.byteblogs.helloblog.integration.dto.UserDTO;
import com.yxs.blog.common.base.domain.Result;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;

public interface OauthService {


    /**
     * create by: Yxs
     * description:保存管理员
     * create time: 17:25 2021/3/30
     * @return
     */
    Result login(AuthUserVO authUserVO);


    /**
     * create by: Yxs
     * description:注册
     * create time: 15:16 2021/4/13
     * @return
     */
    Result registerAdmin(UserDTO userDTO);


}
