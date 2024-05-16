package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Shouru;
import java.util.List;
/**
*   经济收入
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface ShouruMapper extends BaseMapper<Shouru> {
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
