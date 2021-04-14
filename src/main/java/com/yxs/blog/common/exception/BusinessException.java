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

    /**
     * create by: Yxs
     * description:业务回滚，抛出特定异常：包含错误消息，错误编码
     * create time: 15:27 2021/4/13
     * @param message
     * @param resultCode
     * @return
     */
    public BusinessException(String message, String resultCode) {
        super(message);
        this.code = resultCode;
    }
}
