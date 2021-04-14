package com.yxs.blog.common.util;

import com.yxs.blog.common.enums.ErrorEnum;
import com.yxs.blog.common.exception.BusinessException;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/5 20:51
 */
public class ExceptionUtil {
    public static void rollbacke(String message){ throw new BusinessException(message); }

    public static void rollback(ErrorEnum paramError) { throw new BusinessException(paramError); }

    public static void rollback(boolean flag, ErrorEnum accountNotExist) {
        if(flag){
            rollback(accountNotExist);
        }
    }

    public static void rollback(String message, String resultCode) {
        throw new BusinessException(message, resultCode);
    }

    public static void isRollback(boolean flag, ErrorEnum errorEnum) {
        if (flag){
            rollback(errorEnum);
        }
    }
}
