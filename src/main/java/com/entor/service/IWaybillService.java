package com.entor.service;

import java.util.Map;

import com.entor.entity.Waybill;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
public interface IWaybillService extends IMyService<Waybill> {
	public Map<String, Object> queryByPage(int page, int limit, String waybillNo, String wName);
}
