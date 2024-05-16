package com.codeying.service.impl;

import com.codeying.mapper.AdminMapper;
import com.codeying.entity.Admin;
import com.codeying.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class AdminServiceImpl extends AbsServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public List<Admin> sqlSelectList(Admin qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Admin e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Admin e) {
        return baseMapper.sqlSave(e);
    }

}

