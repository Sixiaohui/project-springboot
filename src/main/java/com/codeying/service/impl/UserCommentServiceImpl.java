package com.codeying.service.impl;

import com.codeying.mapper.UserCommentMapper;
import com.codeying.entity.UserComment;
import com.codeying.service.UserCommentService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class UserCommentServiceImpl extends AbsServiceImpl<UserCommentMapper, UserComment> implements UserCommentService {

    @Override
    public List<UserComment> sqlSelectList(UserComment qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(UserComment e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(UserComment e) {
        return baseMapper.sqlSave(e);
    }

}

