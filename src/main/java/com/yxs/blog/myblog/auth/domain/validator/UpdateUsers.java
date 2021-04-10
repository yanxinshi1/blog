package com.yxs.blog.myblog.auth.domain.validator;

import org.apache.ibatis.annotations.Update;

import javax.validation.GroupSequence;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/5 21:22
 */
@GroupSequence({Update.class})
public interface UpdateUsers {
}
