package com.codeying.service.impl;

import com.codeying.mapper.ShiyongMapper;
import com.codeying.entity.Shiyong;
import com.codeying.service.ShiyongService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ShiyongServiceImpl extends AbsServiceImpl<ShiyongMapper, Shiyong> implements ShiyongService {

    @Override
    public List<Shiyong> sqlSelectList(Shiyong qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Shiyong e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Shiyong e) {
        return baseMapper.sqlSave(e);
    }

}

