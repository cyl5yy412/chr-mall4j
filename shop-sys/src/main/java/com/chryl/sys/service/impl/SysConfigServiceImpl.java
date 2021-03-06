/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chryl.sys.dao.SysConfigMapper;
import com.chryl.sys.model.SysConfig;
import com.chryl.sys.service.SysConfigService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lgh
 */
@Service("sysConfigService")
@AllArgsConstructor
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

    private final SysConfigMapper sysConfigMapper;

    @Override
    public void updateValueByKey(String key, String value) {
        sysConfigMapper.updateValueByKey(key, value);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysConfigMapper.deleteBatch(ids);
    }

    @Override
    public String getValue(String key) {
        SysConfig config = sysConfigMapper.queryByKey(key);
        return config == null ? null : config.getParamValue();
    }
}
