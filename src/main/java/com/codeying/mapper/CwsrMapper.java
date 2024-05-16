package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Cwsr;
import java.util.List;
/**
*   财务收入
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface CwsrMapper extends BaseMapper<Cwsr> {
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