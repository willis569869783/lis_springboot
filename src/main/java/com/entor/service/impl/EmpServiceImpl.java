package com.entor.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Emp;
import com.entor.mapper.EmpMapper;
import com.entor.service.IEmpService;
import com.entor.util.MyUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

	@Override
	public Map<String, Object> queryByPage(int page, int limit, Object... objects) {
		QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
		return MyUtil.getPage(page, limit, queryWrapper, this);
	}

}
