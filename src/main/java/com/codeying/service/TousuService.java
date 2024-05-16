package com.codeying.service;

import com.codeying.entity.Tousu;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface TousuService extends MyService<Tousu> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Tousu> sqlSelectList(Tousu qo);

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
    int sqlUpdate(Tousu e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Tousu e);
}

