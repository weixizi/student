package com.whx.mapper;

import com.whx.entity.TGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whx.entity.vo.GroupVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
@Mapper
public interface TGroupMapper extends BaseMapper<TGroup> {

    List<GroupVo> findAll();
}
