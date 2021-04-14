package com.yxs.blog.common.base.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:用户信息VO
 * @author: Yxs
 * @time: 2021/4/14 14:23
 */

@Data
@Accessors(chain = true)
public class UserSessionVO {
    private Long id;

    private String socialId;

    private String name;

    private String avatar;

    private Integer gender;

    private Long roleId;

    private String token;
}
