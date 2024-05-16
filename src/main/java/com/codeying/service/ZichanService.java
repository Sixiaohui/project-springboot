package com.codeying.service;

import com.codeying.entity.Zichan;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface ZichanService extends MyService<Zichan> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Zichan> sqlSelectList(Zichan qo);

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
    int sqlUpdate(Zichan e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Zichan e);
}

