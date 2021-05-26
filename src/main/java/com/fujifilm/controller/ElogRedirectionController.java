package com.fujifilm.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("elog")
public class ElogRedirectionController {
	
	private static final Logger LOGGER = Logger.getLogger(ElogRedirectionController.class.getName());
	
	@Secured("ROLE_CUSTOMER")
	@PostMapping("redirect")
	public ResponseEntity<String> redirect(
			Principal principal, 
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse){
		LOGGER.info(principal.getName()+" requested");
		return ResponseEntity.ok("Yes We are redirecting to \"Elog Apps\" legacy aplication, Request from "+principal.getName());
		/*try {
			httpResponse.sendRedirect("https://elog-fbau.fujifilm.com/elog/login.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}