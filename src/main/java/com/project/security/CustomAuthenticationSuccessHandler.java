package com.project.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {
		StatusMessageDto statusMessageDto = new StatusMessageDto();
		
		statusMessageDto.setStatus(HttpServletResponse.SC_OK);
		statusMessageDto.setMessage("Authentication has been successful");
		
		String json = new Gson().toJson(statusMessageDto);		
		response.getWriter().print(json);
		
	}

}
