package com.entor.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Power;
import com.entor.mapper.PowerMapper;
import com.entor.service.IPowerService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements IPowerService {

	@Override
	public Map<String, Object> queryByPage(int page, int limit, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
