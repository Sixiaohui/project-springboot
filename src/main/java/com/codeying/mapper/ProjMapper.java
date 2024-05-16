package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Proj;
import java.util.List;
/**
*   村务项目
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface ProjMapper extends BaseMapper<Proj> {
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
