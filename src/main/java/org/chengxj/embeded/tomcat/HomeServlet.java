package org.chengxj.embeded.tomcat;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("request scheme:" + request.getScheme());
		response.getWriter().print("hello tomcat");
	}

}
