package com.whx.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whx.entity.TStudent;
import com.whx.entity.vo.StudentVo;
import com.whx.mapper.TStudentMapper;
import com.whx.service.TStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements TStudentService {

    private final int page = 5;

    @Override
    public Page<StudentVo> findAll(StudentVo studentVo,Integer pageNow) {
        Page<StudentVo> studentVoPage = new Page<>(pageNow,page);
        return  baseMapper.findAll(studentVo,studentVoPage);
    }
}
