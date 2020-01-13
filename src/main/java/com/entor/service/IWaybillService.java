package com.entor.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entor.entity.Waybill;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
public interface IWaybillService extends IService<Waybill> {
	public Map<String, Object> queryByPage(int page, int limit);
}
