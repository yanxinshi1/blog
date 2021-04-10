package com.yxs.blog.common.base.domain;

import com.yxs.blog.common.constant.Constants;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: Yxs
 * @time: 2021/4/10 16:09
 */

@Data
@Accessors(chain = true)
public class PageInfo {
    private long page = Constants.DEFAULT_PAGE_INDEX;
    private long size = Constants.DEFAULT_PAGE_SIZE;
    private Long total;
}
