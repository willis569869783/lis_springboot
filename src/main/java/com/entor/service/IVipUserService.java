package com.entor.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entor.entity.VipUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
public interface IVipUserService extends IService<VipUser> {
	public Map<String, Object> queryByPage(int page, int limit, String username, String name);
}
