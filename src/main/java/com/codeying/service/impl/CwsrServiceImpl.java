package com.codeying.service.impl;

import com.codeying.mapper.CwsrMapper;
import com.codeying.entity.Cwsr;
import com.codeying.service.CwsrService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class CwsrServiceImpl extends AbsServiceImpl<CwsrMapper, Cwsr> implements CwsrService {

    @Override
    public List<Cwsr> sqlSelectList(Cwsr qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Cwsr e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Cwsr e) {
        return baseMapper.sqlSave(e);
    }

}

