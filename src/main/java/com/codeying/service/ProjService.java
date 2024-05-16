package com.codeying.service;

import com.codeying.entity.Proj;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface ProjService extends MyService<Proj> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Proj> sqlSelectList(Proj qo);

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
    int sqlUpdate(Proj e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Proj e);
}

