package br.javaweb.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class FormBuild implements IFormBuild, Serializable{

	private static final long serialVersionUID = -2356963273022896510L;

	@Override
	public Object formBuild(HttpServletRequest request) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		if(request.getParameter("form") == null){
			return null;
		}
		
		String nomeClazz = ((Map<String, String>)request.getServletContext().getAttribute(
				WebResource.MAPA_FORMS)).get(request.getParameter("form"));
		
		Object obj = Class.forName(nomeClazz).newInstance();
		
		Class clazz = obj.getClass();
		
		for(Field field: clazz.getDeclaredFields()){
			
			if(request.getParameter(field.getName()) != null){
				preencheCampo(field, obj, request.getParameter(field.getName()));
			}
			
		}
		
		return obj;
	}

	private void preencheCampo(Field field, Object obj, String valor){
		
		Object objValor = null;
		
		try {
			if(field.getType().equals(String.class)){
				objValor = valor;
			}else if(field.getType().equals(Long.class)){
				objValor = toLong(valor);
			}else if(field.getType().equals(Integer.class)){
				objValor = toInteger(valor);
			}else if(field.getType().equals(Double.class)){
				objValor = Double.parseDouble(valor);
			}

			if(objValor == null){return;}
			
			invokeSetMethod(field.getName(), obj, objValor);

		} catch (Exception e) {
			System.out.println("preencheCampo() " + e.getMessage());
		}
		
	}
	
	private Long toLong(String valor){
		valor = valor.replaceAll("\\D|\\+|\\-", "");
		return !"".equals(valor)?Long.valueOf(valor):null;
	} 
	
	private Integer toInteger(String valor){
		return toLong(valor)!=null?toLong(valor).intValue():null;
	}
	
	private void invokeSetMethod(String nameField, Object obj, Object valor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		String methodName = "set" + nameField.substring(0,1).toUpperCase() + nameField.substring(1);
		
		Method method = obj.getClass().getMethod(methodName, valor.getClass());
		
		method.invoke(obj.getClass().cast(obj) , valor.getClass().cast(valor));
		
	}
}
