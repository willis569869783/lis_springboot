package com.entor.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Result;
import com.entor.entity.VipUser;
import com.entor.service.IVipUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@RestController
@RequestMapping("/vip-user")
public class VipUserController {

	@Autowired
	private IVipUserService vipUserService;

	@RequestMapping("/queryByPage")
	public Map<String, Object> queryByPage(int page, int limit) {
		PageHelper.startPage(page, limit);
		List<VipUser> list = vipUserService.list();
		PageInfo<VipUser> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@RequestMapping("/add")
	public Result add(VipUser vipUser) {
		vipUserService.save(vipUser);
		return new Result(0, "数据添加成功!");
	}

	@RequestMapping("/update")
	public Result update(VipUser vipUser) {
		vipUserService.updateById(vipUser);
		return new Result(0, "数据更新成功!");
	}

	@RequestMapping("/deleteMore")
	public Result deleteMore(String ids) {
		vipUserService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功!");
	}
}
