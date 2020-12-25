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
import com.chryl.sys.model.SysUser;


/**
 * 系统用户
 *
 * @author lgh
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param newPassword 新密码
     */
    void updatePasswordByUserId(Long userId, String newPassword);

    /**
     * 保存用户与用户角色关系
     *
     * @param user
     */
    void saveUserAndUserRole(SysUser user);


    /**
     * 更新用户与用户角色关系
     *
     * @param user
     */
    void updateUserAndUserRole(SysUser user);

    /**
     * 根据用户id 批量删除用户
     *
     * @param userIds
     */
    void deleteBatch(Long[] userIds, Long shopId);

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUser getByUserName(String username);

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    SysUser getSysUserById(Long userId);

}