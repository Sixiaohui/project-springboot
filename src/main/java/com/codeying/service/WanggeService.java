package com.codeying.service;

import com.codeying.entity.Wangge;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface WanggeService extends MyService<Wangge> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Wangge> sqlSelectList(Wangge qo);

    /**
     * 删掉
     * @param id
     * @return
     */
    int sqlDeleteById(String id);

    /**
     * 更新
     * @param e
     * @return
     */
    int sqlUpdate(Wangge e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Wangge e);
}

