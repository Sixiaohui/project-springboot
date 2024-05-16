package com.codeying.service.impl;

import com.codeying.mapper.TousuMapper;
import com.codeying.entity.Tousu;
import com.codeying.service.TousuService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class TousuServiceImpl extends AbsServiceImpl<TousuMapper, Tousu> implements TousuService {

    @Override
    public List<Tousu> sqlSelectList(Tousu qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Tousu e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Tousu e) {
        return baseMapper.sqlSave(e);
    }

}

