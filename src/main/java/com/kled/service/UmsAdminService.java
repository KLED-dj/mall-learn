package com.kled.service;

import com.kled.mbg.model.UmsAdmin;
import com.kled.mbg.model.UmsPermission;
import com.kled.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员service
 */
public interface UmsAdminService {
    /**
     * 根据用户获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username  用户名
     * @param password  密码
     * @return  生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 获取用户对应角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 根据用户名或分页查询用户
     */
    List<UmsAdmin> list(String keyword,Integer pageSize,Integer pageNum);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId,List<Long> roleIds);

    /**
     * 获取缓存服务
     */
    UmsAdminCacheService getCacheService();

    /**
     * 修改指定用户信息
     */
    int update(Long id,UmsAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);

}
