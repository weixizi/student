package com.whx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whx.entity.TClazz;
import com.whx.entity.TGroup;
import com.whx.entity.vo.GroupVo;
import com.whx.mapper.TGroupMapper;
import com.whx.service.TClazzService;
import com.whx.service.TGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TGroupServiceImpl extends ServiceImpl<TGroupMapper, TGroup> implements TGroupService {

    @Autowired
    private TClazzService tClazzService;

    @Override
    public List<GroupVo> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public void saves(GroupVo groupVo) {

        QueryWrapper<TClazz> wrapper = new QueryWrapper<>();
        wrapper.eq("name",groupVo.getClazzname());
        TClazz tClazz = tClazzService.getOne(wrapper);

        TGroup tGroup = new TGroup();
        tGroup.setClazzid(tClazz.getId());
        tGroup.setContent(groupVo.getContent());
        tGroup.setName(groupVo.getName());
        this.save(tGroup);

    }
}
