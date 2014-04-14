package com.springhibxml.startup;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InitializeApp implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	AnnotationConfigWebApplicationContext appctx=new AnnotationConfigWebApplicationContext();
	appctx.register(WebServletDescriptorconfig.class);
	
	servletContext.addListener(new ContextLoaderListener(appctx));
	appctx.setServletContext(servletContext);
	//load web xml config values here
	Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(appctx));
	servlet.addMapping("/");
	servlet.setLoadOnStartup(1);


}

}
