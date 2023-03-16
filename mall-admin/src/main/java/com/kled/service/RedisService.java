package com.kled.service;

import java.util.List;

public interface RedisService {
    /**
     * 储存数据
     */
    void set(String key,String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超时时间
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key,long delta);

    /**
     * 删除属性
     */
    Boolean del(String key);

    /**
     * 批量删除属性
     */
    Long del(List<String> keys);

}
