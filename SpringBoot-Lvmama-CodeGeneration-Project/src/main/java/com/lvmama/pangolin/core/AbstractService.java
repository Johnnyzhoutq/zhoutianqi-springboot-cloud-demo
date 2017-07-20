package com.lvmama.pangolin.core;


import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Service接口的实现
 */
public abstract class AbstractService<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        mapper.save(model);
    }

    public void save(List<T> models) {
        mapper.save(models);
    }

    public void deleteById(String id) {
        mapper.deleteById(id);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    public void update(T model) {
        mapper.update(model);
    }

    public T findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public T findByMap(Map<String,String> paramMap) throws TooManyResultsException {
        return mapper.findByMap(paramMap);
    }

    public List<T> findByIds(String ids) {
        return mapper.findByIds(ids);
    }

    public List<T> findListByMap(Map<String,String> paramMap) {
        return mapper.findListByMap(paramMap);
    }

    public List<T> findAll() {
        return mapper.findAll();
    }
}
