package com.codeying.service;

import com.codeying.entity.Zjsy;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface ZjsyService extends MyService<Zjsy> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<Zjsy> sqlSelectList(Zjsy qo);

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
    int sqlUpdate(Zjsy e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Zjsy e);
}

