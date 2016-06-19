package br.javaweb.util;

import javax.servlet.http.HttpServletRequest;

public class MsgUtil {

	public static void addMsgSucess(HttpServletRequest request, String msg){
		request.setAttribute("msg", msg);
		request.setAttribute("tipoMsg", "SUCESS");
	}
	
	public static void addMsgError(HttpServletRequest request, String msg){
		request.setAttribute("msg", msg);
		request.setAttribute("tipoMsg", "ERRO");
	}
	
	public static void addMsgWarn(HttpServletRequest request, String msg){
		request.setAttribute("msg", msg);
		request.setAttribute("tipoMsg", "WARN");
	}
}
