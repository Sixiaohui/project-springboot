package com.codeying.service;

import com.codeying.entity.UserComment;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 */
public interface UserCommentService extends MyService<UserComment> {
    /**
         * 查询
         * @param qo
         * @return
         */
    List<UserComment> sqlSelectList(UserComment qo);

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
    int sqlUpdate(UserComment e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(UserComment e);
}

