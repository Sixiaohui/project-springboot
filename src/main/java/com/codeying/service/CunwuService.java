package com.codeying.service;

import com.codeying.entity.Cunwu;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface CunwuService extends MyService<Cunwu> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Cunwu> sqlSelectList(Cunwu qo);

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
    int sqlUpdate(Cunwu e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Cunwu e);
}

