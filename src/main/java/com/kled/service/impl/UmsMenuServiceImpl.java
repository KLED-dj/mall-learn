package com.kled.service.impl;

import com.kled.dto.UmsMenuNode;
import com.kled.mbg.mapper.UmsMenuMapper;
import com.kled.mbg.model.UmsMenu;
import com.kled.mbg.model.UmsMenuExample;
import com.kled.service.UmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper menuMapper;

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = menuMapper.selectByExample(new UmsMenuExample());
        List<UmsMenuNode> result = menuList.stream().filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> coverMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }


    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode coverMenuNode(UmsMenu menu,List<UmsMenu> menuList){
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu,node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> coverMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
