package com.yxs.blog.myblog.auth.dao;

import com.yxs.blog.common.base.dao.BaseDao;
import com.yxs.blog.myblog.auth.domain.po.AuthUser;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/5 21:33
 */
public interface AuthUserDao extends BaseDao<AuthUser> {
    String selectAvatar();
    AuthUser selectAdmin();
}
