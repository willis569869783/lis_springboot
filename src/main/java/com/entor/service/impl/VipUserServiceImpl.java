package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.VipUser;
import com.entor.mapper.VipUserMapper;
import com.entor.service.IVipUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@Service
public class VipUserServiceImpl extends ServiceImpl<VipUserMapper, VipUser> implements IVipUserService {

	@Override
	public Map<String, Object> queryByPage(int page, int limit, String username, String name) {
		QueryWrapper queryWrapper = new QueryWrapper<>();
		if (username != null && !username.equals("")) {
			queryWrapper.like("username", username);
		}
		if (name != null && !name.equals("")) {
			queryWrapper.like("name", name);
		}
		PageHelper.startPage(page, limit);
		List<VipUser> list = super.list(queryWrapper);
		PageInfo<VipUser> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

}
