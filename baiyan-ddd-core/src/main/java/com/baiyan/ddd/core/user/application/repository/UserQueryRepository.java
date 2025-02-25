package com.baiyan.ddd.core.user.application.repository;

import com.baiyan.ddd.base.model.query.KeywordQuery;
import com.baiyan.ddd.base.model.result.Page;
import com.baiyan.ddd.core.user.application.model.dto.UserPageDTO;

/**
 * CQRS模式
 *
 * 用户查询仓储
 *
 * @author baiyan
 */
public interface UserQueryRepository{

    /**
     * 用户分页数据查询
     *
     * @param query
     * @return
     */
    Page<UserPageDTO> userPage(KeywordQuery query);
}
