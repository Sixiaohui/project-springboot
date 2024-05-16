package com.codeying.service.impl;

import com.codeying.mapper.CunwuMapper;
import com.codeying.entity.Cunwu;
import com.codeying.service.CunwuService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class CunwuServiceImpl extends AbsServiceImpl<CunwuMapper, Cunwu> implements CunwuService {

    @Override
    public List<Cunwu> sqlSelectList(Cunwu qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Cunwu e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Cunwu e) {
        return baseMapper.sqlSave(e);
    }

}

