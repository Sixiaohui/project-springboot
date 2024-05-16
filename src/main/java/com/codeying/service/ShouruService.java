package com.codeying.service;

import com.codeying.entity.Shouru;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface ShouruService extends MyService<Shouru> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Shouru> sqlSelectList(Shouru qo);

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
    int sqlUpdate(Shouru e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Shouru e);
}

