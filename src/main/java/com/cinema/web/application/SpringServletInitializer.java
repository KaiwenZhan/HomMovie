package com.cinema.web.application;

import javax.servlet.Filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static final String CHARACTER_ENCODING = "UTF-8";

	public static AnnotationConfigWebApplicationContext context
		= new AnnotationConfigWebApplicationContext();

    public SpringServletInitializer() {
        super();
    }
    
	@Override
	protected WebApplicationContext createServletApplicationContext() {
		context.register(SpringWebConfig.class);
		return context;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		context.register(SpringBusinessConfig.class);
		return context;
	}
	@Override
	protected Filter[] getServletFilters() {
	    final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	    encodingFilter.setEncoding(CHARACTER_ENCODING);
	    encodingFilter.setForceEncoding(true);
	    return new Filter[] { encodingFilter };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringBusinessConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { SpringWebConfig.class };
	}

}
