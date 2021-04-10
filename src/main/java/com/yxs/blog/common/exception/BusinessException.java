package com.yxs.blog.common.exception;

import com.yxs.blog.common.enums.ErrorEnum;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/5 20:54
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -4214098630082643472L;
    // 异常编码
    private String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ErrorEnum paramError) {
        super(paramError.getMsg(paramError.getCode()));
        this.code = paramError.getCode();
    }

    public BusinessException(String message, Exception cause) {
        super(message, cause);
    }
}
