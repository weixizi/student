package com.whx.service;

import com.whx.entity.TGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whx.entity.vo.GroupVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
public interface TGroupService extends IService<TGroup> {

    List<GroupVo> findAll();

    void saves(GroupVo groupVo);

}
