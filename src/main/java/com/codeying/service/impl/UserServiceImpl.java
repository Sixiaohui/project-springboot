package com.codeying.service.impl;

import com.codeying.mapper.UserMapper;
import com.codeying.entity.User;
import com.codeying.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class UserServiceImpl extends AbsServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> sqlSelectList(User qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(User e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(User e) {
        return baseMapper.sqlSave(e);
    }

}

