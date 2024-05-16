package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Wangge;
import java.util.List;
/**
*   网格
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface WanggeMapper extends BaseMapper<Wangge> {
    /**
     * 查询
     * @param qo
     * @return
     */
    List<Wangge> sqlSelectList(Wangge qo);

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
    int sqlUpdate(Wangge e);

    /**
     * 保存
     * @param e
     * @return
     */
    int sqlSave(Wangge e);

}
