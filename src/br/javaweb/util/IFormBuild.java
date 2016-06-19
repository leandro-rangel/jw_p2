package br.javaweb.util;

import javax.servlet.http.HttpServletRequest;


public interface IFormBuild {

	Object formBuild(HttpServletRequest request)throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
