package com.codeying.service.impl;

import com.codeying.mapper.WanggeMapper;
import com.codeying.entity.Wangge;
import com.codeying.service.WanggeService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class WanggeServiceImpl extends AbsServiceImpl<WanggeMapper, Wangge> implements WanggeService {

    @Override
    public List<Wangge> sqlSelectList(Wangge qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Wangge e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Wangge e) {
        return baseMapper.sqlSave(e);
    }

}

