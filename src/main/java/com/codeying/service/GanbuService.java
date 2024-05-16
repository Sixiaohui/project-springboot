package com.codeying.service;

import com.codeying.entity.Ganbu;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface GanbuService extends MyService<Ganbu> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Ganbu> sqlSelectList(Ganbu qo);

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
    int sqlUpdate(Ganbu e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Ganbu e);
}

