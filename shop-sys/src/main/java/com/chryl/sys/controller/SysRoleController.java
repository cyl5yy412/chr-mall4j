/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.chryl.sys.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chryl.common.annotation.SysLog;
import com.chryl.common.util.PageParam;
import com.chryl.sys.model.SysRole;
import com.chryl.sys.service.SysMenuService;
import com.chryl.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色管理
 *
 * @author lgh
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 角色列表
     */
    @GetMapping("/page")
    @PreAuthorize("@pms.hasPermission('sys:role:page')")
    public ResponseEntity<IPage<SysRole>> page(String roleName, PageParam<SysRole> page) {
        IPage<SysRole> sysRoles = sysRoleService.page(page, new LambdaQueryWrapper<SysRole>().like(StrUtil.isNotBlank(roleName), SysRole::getRoleName, roleName));
        return ResponseEntity.ok(sysRoles);
    }

    /**
     * 角色列表
     */
    @GetMapping("/list")
    @PreAuthorize("@pms.hasPermission('sys:role:list')")
    public ResponseEntity<List<SysRole>> list() {
        List<SysRole> list = sysRoleService.list();
        return ResponseEntity.ok(list);
    }

    /**
     * 角色信息
     */
    @GetMapping("/info/{roleId}")
    @PreAuthorize("@pms.hasPermission('sys:role:info')")
    public ResponseEntity<SysRole> info(@PathVariable("roleId") Long roleId) {
        SysRole role = sysRoleService.getById(roleId);

        //查询角色对应的菜单
        List<Long> menuList = sysMenuService.listMenuIdByRoleId(roleId);
        role.setMenuIdList(menuList);

        return ResponseEntity.ok(role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sys:role:save')")
    public ResponseEntity<Void> save(@RequestBody SysRole role) {
        sysRoleService.saveRoleAndRoleMenu(role);
        return ResponseEntity.ok().build();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @PutMapping
    @PreAuthorize("@pms.hasPermission('sys:role:update')")
    public ResponseEntity<Void> update(@RequestBody SysRole role) {
        sysRoleService.updateRoleAndRoleMenu(role);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @DeleteMapping
    @PreAuthorize("@pms.hasPermission('sys:role:delete')")
    public ResponseEntity<Void> delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return ResponseEntity.ok().build();
    }
}
