package eu.europa.ec.estat.esa.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession()
				.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
		if (defaultSavedRequest != null) {
			getRedirectStrategy().sendRedirect(request, response, defaultSavedRequest.getRedirectUrl());
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}
}
