package com.entor.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Waybill;
import com.entor.mapper.WaybillMapper;
import com.entor.service.IWaybillService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Willis
 * @since 2020-01-15
 */
@Service
public class WaybillServiceImpl extends ServiceImpl<WaybillMapper, Waybill> implements IWaybillService {

	@Override
	public Map<String, Object> queryByPage(int page, int limit, Object... objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
