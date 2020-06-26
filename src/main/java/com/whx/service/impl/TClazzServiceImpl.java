package com.whx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whx.entity.TClazz;
import com.whx.entity.TTag;
import com.whx.entity.vo.ClazzVo;
import com.whx.mapper.TClazzMapper;
import com.whx.service.TClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whx.service.TTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weixi
 * @since 2020-06-22
 */
@Transactional
@Service
public class TClazzServiceImpl extends ServiceImpl<TClazzMapper, TClazz> implements TClazzService {

    @Autowired
    private TTagService tTagService;

    @Override
    public List<ClazzVo> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public void saves(ClazzVo clazzVo) {
        TClazz tClazz = new TClazz();
        tClazz.setName(clazzVo.getName());
        // 查询tagid
        String tagname = clazzVo.getTagname();
        QueryWrapper<TTag> wrapper = new QueryWrapper<>();
        wrapper.eq("name",tagname);
        TTag tTag = tTagService.getOne(wrapper);
        Integer id = tTag.getId();

        tClazz.setTagid(id);
        this.save(tClazz);
    }
}
