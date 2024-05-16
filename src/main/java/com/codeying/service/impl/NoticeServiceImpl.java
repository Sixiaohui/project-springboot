package com.codeying.service.impl;

import com.codeying.mapper.NoticeMapper;
import com.codeying.entity.Notice;
import com.codeying.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class NoticeServiceImpl extends AbsServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public List<Notice> sqlSelectList(Notice qo) {
        return baseMapper.sqlSelectList(qo);
    }

    @Override
    public int sqlDeleteById(String id) {
        return baseMapper.sqlDeleteById(id);
    }

    @Override
    public int sqlUpdate(Notice e) {
        return baseMapper.sqlUpdate(e);
    }

    @Override
    public int sqlSave(Notice e) {
        return baseMapper.sqlSave(e);
    }

}

