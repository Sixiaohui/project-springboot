package com.codeying.service.impl;

import com.codeying.mapper.ZichanMapper;
import com.codeying.entity.Zichan;
import com.codeying.service.ZichanService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ZichanServiceImpl extends AbsServiceImpl<ZichanMapper, Zichan> implements ZichanService {

    @Override
    public List<Zichan> sqlSelectList(Zichan qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Zichan e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Zichan e) {
        return baseMapper.sqlSave(e);
    }

}

