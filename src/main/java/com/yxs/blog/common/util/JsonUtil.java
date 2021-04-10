package com.yxs.blog.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yxs.blog.common.config.JacksonConfig;
import com.yxs.blog.common.exception.BusinessException;
import com.yxs.blog.myblog.auth.domain.vo.AuthUserVO;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/10 15:43
 */
public class JsonUtil {
    /**
     * create by: Yxs
     * description:将java对象转成Json字符串
     * create time: 15:45 2021/4/10
     * @param object:Java对象
     * @return java.lang.String
     */
    public static String toJsonString(Object object) {
        return JsonMapper.toJsonString(object);
    }

    /**
     * create by: Yxs
     * description:内部类，处理Json
     * create time: 15:47 2021/4/10
     */
    private static class JsonMapper{

        //jackson objectmapper：序列化java对象为json以及json字符串反序列化为java对象
        private static ObjectMapper objectMapper = JacksonConfig.jacksonObjectMapper();


        public static String toJsonString(Object object) {
            try {
                return objectMapper.writeValueAsString(object);
            } catch (Exception e) {
                throw new BusinessException("对象转Json失败！", e);
            }
        }
    }
}
