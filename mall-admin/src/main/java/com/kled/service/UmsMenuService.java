package com.kled.service;

import com.kled.dto.UmsMenuNode;
import com.kled.mbg.model.UmsMenu;

import java.util.List;

public interface UmsMenuService {
    /**
     * 创建后台菜单
     */
    int create(UmsMenu umsMenu);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 分页查询后台菜单
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 根据ID获取菜单详情
     */
    UmsMenu getItem(Long id);

    /**
     * 根据id修改菜单信息
     */
    int update(Long id,UmsMenu menu);

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id,Integer hidden);

    /**
     * 根据id删除菜单
     */
    int delete(Long id);
}
