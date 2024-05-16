package com.codeying.service.impl;

import com.codeying.mapper.GanbuMapper;
import com.codeying.entity.Ganbu;
import com.codeying.service.GanbuService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class GanbuServiceImpl extends AbsServiceImpl<GanbuMapper, Ganbu> implements GanbuService {

    @Override
    public List<Ganbu> sqlSelectList(Ganbu qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Ganbu e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Ganbu e) {
        return baseMapper.sqlSave(e);
    }

}

