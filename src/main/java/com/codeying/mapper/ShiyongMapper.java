package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Shiyong;
import java.util.List;
/**
*   村土地使用
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface ShiyongMapper extends BaseMapper<Shiyong> {
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
