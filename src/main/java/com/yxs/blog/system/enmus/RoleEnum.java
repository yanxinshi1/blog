package com.yxs.blog.system.enmus;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用户是 管理员 还是 普通用户 的枚举
 * @author: Yxs
 * @time: 2021/4/5 21:39
 */
public enum RoleEnum {

    /**
     * 普通用户
     */
    USER(1L, "user"),

    /**
     * 管理员
     */
    ADMIN(2L, "admin");

    private static final Map<Long, RoleEnum> enumTypeMap = new HashMap<>();

    static {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            enumTypeMap.put(roleEnum.getRoleId(), roleEnum);
        }
    }

    private final Long roleId;

    private final String roleName;

    RoleEnum(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public static Map<Long, RoleEnum> getEnumTypeMap() {
        return enumTypeMap;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

}
