package com.codeying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeying.entity.Zichan;
import java.util.List;
/**
*   村资产信息
*   mybatisPlus提供接口，自动实现了各种单表操作
*/
public interface ZichanMapper extends BaseMapper<Zichan> {
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
