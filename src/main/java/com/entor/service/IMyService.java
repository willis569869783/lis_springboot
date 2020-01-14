package com.entor.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

public interface IMyService<T> extends IService<T> {

	public Map<String, Object> queryByPage(int page, int limit, Object... objects);

}
