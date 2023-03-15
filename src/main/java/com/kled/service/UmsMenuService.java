package com.kled.service;

import com.kled.dto.UmsMenuNode;

import java.util.List;

public interface UmsMenuService {
    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();
}
