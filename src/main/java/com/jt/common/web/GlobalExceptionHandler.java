package com.jt.common.web;
import java.util.logging.Logger;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jt.common.vo.JsonResult;
/**全局异常处理类*/
@ControllerAdvice
public class GlobalExceptionHandler {
	//JDK中的自带的日志API
	private Logger log=Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	/**Shiro全局异常处理*/
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doShiroException(
			ShiroException e){
		JsonResult jsonResult = new JsonResult();
		jsonResult.setState(0);
		jsonResult.setMessage("密码不正确");
		
		return jsonResult;//封装异常信息
	}
	
	@ExceptionHandler(RuntimeException.class)
    @ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
    	e.printStackTrace();//也可以写日志
		log.info(e.getMessage());
		return new JsonResult(e);//封装异常信息
	}
}


