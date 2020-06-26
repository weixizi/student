package com.whx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whx.entity.TStudent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whx.entity.vo.StudentVo;



/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
public interface TStudentService extends IService<TStudent> {

    Page<StudentVo> findAll(StudentVo studentVo,Integer pageNow);

}
