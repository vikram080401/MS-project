package com.ecommerce.shopping.oauth2.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ApplicationController {

	 @GetMapping("/user")
	    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
	        return Collections.singletonMap("name", principal.getAttribute("name"));
	    }
	 @GetMapping("/error")
		@ResponseBody
		public String error(HttpServletRequest request) {
			String message = (String) request.getSession().getAttribute("error.message");
			request.getSession().removeAttribute("error.message");
			return message;
		}
}
