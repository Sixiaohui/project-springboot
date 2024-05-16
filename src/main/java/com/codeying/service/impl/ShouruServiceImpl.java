package com.codeying.service.impl;

import com.codeying.mapper.ShouruMapper;
import com.codeying.entity.Shouru;
import com.codeying.service.ShouruService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ShouruServiceImpl extends AbsServiceImpl<ShouruMapper, Shouru> implements ShouruService {

    @Override
    public List<Shouru> sqlSelectList(Shouru qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Shouru e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Shouru e) {
        return baseMapper.sqlSave(e);
    }

}

