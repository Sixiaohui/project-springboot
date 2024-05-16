package com.codeying.service.impl;

import com.codeying.mapper.ZjsyMapper;
import com.codeying.entity.Zjsy;
import com.codeying.service.ZjsyService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ZjsyServiceImpl extends AbsServiceImpl<ZjsyMapper, Zjsy> implements ZjsyService {

    @Override
    public List<Zjsy> sqlSelectList(Zjsy qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Zjsy e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Zjsy e) {
        return baseMapper.sqlSave(e);
    }

}

