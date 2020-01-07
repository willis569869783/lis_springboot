package com.entor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

	@RequestMapping("/v")
	public String v() {
		return "AAAAAAAAAAAAAAAAAAA";
	}
}
