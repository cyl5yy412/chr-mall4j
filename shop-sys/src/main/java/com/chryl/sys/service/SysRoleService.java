/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chryl.sys.model.SysRole;

import java.util.List;

/**
 * 角色
 *
 * @author lgh
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据id批量删除
     *
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);

    /**
     * 保存角色 与 角色菜单关系
     *
     * @param role
     */
    void saveRoleAndRoleMenu(SysRole role);

    /**
     * 更新角色 与 角色菜单关系
     *
     * @param role
     */
    void updateRoleAndRoleMenu(SysRole role);

    /**
     * 根据用户ID，获取角色ID列表
     *
     * @param userId 用户id
     * @return 角色id列表
     */
    List<Long> listRoleIdByUserId(Long userId);

}
