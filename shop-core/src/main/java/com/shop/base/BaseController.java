package com.shop.base;

import com.shop.constant.Constant;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	@ModelAttribute
	protected void preMethod(HttpServletRequest request, Model model) {
		String ctx = request.getContextPath();
		model.addAttribute("ctx", ctx);
	}
	
	/**
	 * 成功返回
	 * @return
	 */
	protected ResultInfo success(Object result) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResult(result);
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		resultInfo.setResultMessage(Constant.SUCCESS_MSG);
		return resultInfo;
	}

	/**
	 * 分页查询成功返回结果
	 * @param result
	 * @return
	 */
//	protected ResultListInfo success(PageList result) {
//		ResultListInfo resultListInfo = new ResultListInfo();
//		resultListInfo.setPaginator(result.getPaginator());
//		resultListInfo.setResult(result);
//		resultListInfo.setResultCode(Constant.SUCCESS_CODE);
//		resultListInfo.setResultMessage(Constant.SUCCESS_MSG);
//		return resultListInfo;
//	}


	/**
	 * 返回失败内容
	 * @param code
	 * @param errorMessage
	 * @return
	 */
	protected ResultInfo failure(int code, String errorMessage) {
		ResultInfo result = new ResultInfo();
		result.setResultCode(code);
		result.setResultMessage(errorMessage);
		return result;
	}


	
}
