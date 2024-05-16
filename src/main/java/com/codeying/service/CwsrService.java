package com.codeying.service;

import com.codeying.entity.Cwsr;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface CwsrService extends MyService<Cwsr> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Cwsr> sqlSelectList(Cwsr qo);

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
    int sqlUpdate(Cwsr e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Cwsr e);
}

