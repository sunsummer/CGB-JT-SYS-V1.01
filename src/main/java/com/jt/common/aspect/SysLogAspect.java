package com.jt.common.aspect;

import java.util.Arrays;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import com.jt.common.util.IPUtils;
import com.jt.common.util.ShiroUtils;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysUser;

/**
 * 日志切面对象
 * @author Administrator
 *
 */
@Order(1)	//数字越小，优先级越高
@Aspect
@Service
public class SysLogAspect {
	
	@Autowired
	private SysLogDao sysLogDao;
	
	/**
	 * 描述的方法为一个环绕通知
	 * 1) 环绕通知：目标执行之前和之后都可以执行通知
	 * 环绕通知内部的bean表达式为一个切入点表达式
	 * 
	 * @param pjp //一个连接点对象:封装特定的参数信息
	 * @return
	 * @throws Throwable 
	 */
	@Around("bean(sysRoleServiceImpl)")	//在所有sysRoleServiceImpl执行之前加一个日志
	public Object aroundMethod(
			ProceedingJoinPoint joinPoint) throws Throwable{
		
		//----------------------------------------------------
		long startTime = System.currentTimeMillis();
		//执行目标方法
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		long time = endTime-startTime;
		System.out.println("执行方法总计耗费时间:"+time);
		//----------------------------------------------------
		//获取日志信息
		Class<?> targetCls = joinPoint.getTarget().getClass();
		Signature s = joinPoint.getSignature();
		String methodName = targetCls.getName();
		Object[] params = joinPoint.getArgs();
		
		//封装日志信息
		//1. 生成SysLog对象，并填充数据
		SysLog log = new SysLog();
		
		log.setIp(IPUtils.getIpAddr());
		log.setMethod(methodName);
		log.setParams(Arrays.toString(params));
		//log.setOperation(operation);
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		log.setUsername(user.getUsername());
		log.setUsername(ShiroUtils.getPrincipal().getUsername());
		log.setTime(time);
		//----------------------------------------------------
		//2. 调用SysLogDao接口，将syslog对象添加到数据库中
		int rows = sysLogDao.insertObject(log);
		
		//3. 控制台打印“日志生成完毕”
		if(rows!=0&&(rows==1||rows==0)){
			System.out.println("日志保存成功");
		} else {
			System.out.println("日志保存失败");
		}
		
		return result;
	}
}
//基于ocp原则进行扩展()















