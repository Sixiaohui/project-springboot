package com.codeying.service.impl;

import com.codeying.mapper.ProjMapper;
import com.codeying.entity.Proj;
import com.codeying.service.ProjService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ProjServiceImpl extends AbsServiceImpl<ProjMapper, Proj> implements ProjService {

    @Override
    public List<Proj> sqlSelectList(Proj qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Proj e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Proj e) {
        return baseMapper.sqlSave(e);
    }

}

