package org.chengxj.embeded.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;

public class EmbedTomcatHttp {
	
	private static final int PORT = 8089;
	private static final String DOC_BASE = "d:/tmp/tomcat";

	public static void main(String[] args) throws LifecycleException {
		Tomcat server = new Tomcat();
		server.setPort(PORT);
		server.setBaseDir(DOC_BASE);
		server.getHost().setAutoDeploy(false);
		
		String contextPath = "/chengxj";
		StandardContext context = new StandardContext();
		context.setPath(contextPath);
		context.addLifecycleListener(new FixContextListener());
		server.getHost().addChild(context);
		
		server.addServlet(contextPath, "homeServlet", new HomeServlet());
		context.addServletMapping("/home", "homeServlet");
		server.start();
		server.getServer().await();
		
	}

}
