package com.whx.service.impl;

import com.whx.entity.TUser;
import com.whx.mapper.TUserMapper;
import com.whx.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
