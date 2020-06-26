package com.whx.mapper;

import com.whx.entity.TClazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whx.entity.vo.ClazzVo;
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
public interface TClazzMapper extends BaseMapper<TClazz> {

    List<ClazzVo> findAll();
}
