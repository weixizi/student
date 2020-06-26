package com.whx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whx.entity.TStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whx.entity.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface TStudentMapper extends BaseMapper<TStudent> {

    Page<StudentVo> findAll(StudentVo studentVo, Page<StudentVo> studentVoPage);
}
