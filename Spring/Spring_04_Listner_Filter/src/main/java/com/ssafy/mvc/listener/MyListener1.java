package com.ssafy.mvc.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class myListener1
 *
 */
//@WebListener
public class MyListener1 implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션이 시작될 때 호출 1");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션이 종료될 때 호출 1");
	}

}
