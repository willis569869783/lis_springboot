package com.entor.service.impl;

import com.entor.entity.Emp;
import com.entor.mapper.EmpMapper;
import com.entor.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Willis
 * @since 2020-01-07
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
