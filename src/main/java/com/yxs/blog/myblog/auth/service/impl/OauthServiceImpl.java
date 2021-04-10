package com.yxs.blog.myblog.auth.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yxs.blog.common.base.domain.Result;
import com.yxs.blog.common.constant.Constants;
import com.yxs.blog.common.enums.ErrorEnum;
import com.yxs.blog.common.util.ExceptionUtil;
import com.yxs.blog.common.util.JwtUtil;
import com.yxs.blog.myblog.auth.dao.AuthTokenDao;
import com.yxs.blog.myblog.auth.dao.AuthUserDao;
import com.yxs.blog.myblog.auth.domain.po.AuthToken;
import com.yxs.blog.myblog.auth.domain.po.AuthUser;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;
import com.yxs.blog.myblog.auth.service.OauthService;
import com.yxs.blog.system.enmus.RoleEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/5 20:36
 */
public class OauthServiceImpl implements OauthService {

    @Autowired
    private AuthUserDao authUserDao;
    @Autowired
    private AuthTokenDao authTokenDao;


    /**
     * create by: Yxs
     * description: 管理员登陆具体逻辑实现
     * create time: 20:36 2021/4/5
     * @param authUserVO
     * @return com.yxs.blog.common.base.domain.Result
     */
    @Override
    public Result login(AuthUserVO authUserVO) {
        //若authUserVO为空，或用户名（邮箱）或密码为空，则回滚
        if (authUserVO == null || StringUtils.isBlank(authUserVO.getEmail()) || StringUtils.isBlank(authUserVO.getPassword())) {
            ExceptionUtil.rollback(ErrorEnum.PARAM_ERROR);
        }
        AuthUser authUser = authUserDao.selectOne(new LambdaQueryWrapper<AuthUser>()
                .eq(AuthUser::getRoleId, RoleEnum.ADMIN.getRoleId())//用户是管理员还是普通用户
                .eq(AuthUser::getEmail, authUserVO.getEmail()));//用户的用户名（邮箱）
        //如果用户名不存在，则抛出异常
        ExceptionUtil.rollback(authUser == null,ErrorEnum.ACCOUNT_NOT_EXIST);

        //密码加密
        String psw = SecureUtil.md5(authUserVO.getPassword());
        //判断密码是否错误，若错误返回
        ExceptionUtil.rollback(!authUser.getPassword().equals(psw),ErrorEnum.PASSWORD_ERROR);
        //设置类别名字
        authUserVO.setRoles(Collections.singletonList(RoleEnum.getEnumTypeMap().get(authUser.getRoleId()).getRoleName()));
        //设置创建日期
        authUserVO.setCreateTime(authUser.getCreateTime());
        //获取token
        String token = JwtUtil.getToken(new AuthUserVO().setPassword(authUser.getPassword()).setName(authUser.getName()).setId(authUser.getId()));
        //设置token
        authUserVO.setToken(token);
        //数据库写入token
        authTokenDao.insert(new AuthToken().setUserId(authUser.getId()).setToken(token).setExpireTime(new Date(Constants.EXPIRE_TIME + System.currentTimeMillis()).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime()));
        return Result.createWithModel(authUserVO);
    }
}
