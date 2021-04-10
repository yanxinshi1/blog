package com.yxs.blog.myblog.auth.service;

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


}
