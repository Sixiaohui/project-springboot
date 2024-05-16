package com.codeying.service;

import com.codeying.entity.Shiyong;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface ShiyongService extends MyService<Shiyong> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Shiyong> sqlSelectList(Shiyong qo);

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
    int sqlUpdate(Shiyong e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Shiyong e);
}

