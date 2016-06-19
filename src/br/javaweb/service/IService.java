package br.javaweb.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IService {

	String execute(HttpServletRequest request, HttpServletResponse response, Object objForm)
			throws ServletException, IOException;
}
