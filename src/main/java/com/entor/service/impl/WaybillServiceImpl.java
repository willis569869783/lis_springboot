package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Waybill;
import com.entor.mapper.WaybillMapper;
import com.entor.service.IWaybillService;
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
public class WaybillServiceImpl extends ServiceImpl<WaybillMapper, Waybill> implements IWaybillService {

	@Override
	public Map<String, Object> queryByPage(int page, int limit, String waybillNo, String wName) {
		QueryWrapper<Waybill> queryWrapper = new QueryWrapper<>();
		if (waybillNo != null && !waybillNo.equals("")) {
			queryWrapper.like("waybill_no", waybillNo);
		}
		if (wName != null && !wName.equals("")) {
			queryWrapper.like("w_name", wName);
		}
		PageHelper.startPage(page, limit);
		List<Waybill> list = this.list(queryWrapper);
		PageInfo<Waybill> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@Override
	public Map<String, Object> queryByPage(int page, int limit, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
