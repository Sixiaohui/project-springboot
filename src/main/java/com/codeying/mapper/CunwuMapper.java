package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Cunwu;
import java.util.List;
/**
*   村务信息
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface CunwuMapper extends BaseMapper<Cunwu> {
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
