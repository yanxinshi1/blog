package com.yxs.blog.myblog.auth.domain.vo;

import com.sun.istack.internal.NotNull;
import com.yxs.blog.common.base.domain.vo.BaseVO;
import com.yxs.blog.common.validator.annotion.IntegerNotNull;
import com.yxs.blog.myblog.auth.domain.validator.UpdateUsers;
import lombok.Data;
import lombok.experimental.Accessors;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class AuthUserVO extends BaseVO {
    /**
     * 主键
     */
    @IntegerNotNull(groups = {UpdateUsers.class})
    private Long id;

    /**
     * 社交账户ID
     */
    private String socialId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    private String passwordOld;

    private String verifyCode;

    /**
     * 角色主键 1 普通用户 2 admin
     */
    private Long roleId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    private String token;

    private List<String> roles;

    private String introduction;

    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    private String accessKey;

    private String secretKey;

}
