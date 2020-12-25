/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chryl.security.model.AppConnect;
import org.apache.ibatis.annotations.Param;

public interface AppConnectMapper extends BaseMapper<AppConnect> {

    AppConnect getByBizUserId(@Param("bizUserId") String bizUserId, @Param("appId") Integer appId);

    AppConnect getByUserId(@Param("userId") String userId, @Param("appId") Integer appId);

    String getUserIdByUnionId(@Param("bizUnionId") String bizUnionId);
}