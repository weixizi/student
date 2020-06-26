package com.whx.service;

import com.whx.entity.TClazz;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whx.entity.vo.ClazzVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
public interface TClazzService extends IService<TClazz> {
    List<ClazzVo> findAll();

    void saves(ClazzVo clazzVo);

}
