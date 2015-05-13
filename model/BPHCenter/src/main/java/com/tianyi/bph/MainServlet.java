

package com.tianyi.bph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.AbstractAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * 
* @Title: MainServlet.java
* @Package com.tianyi.bph
* @Description: TODO(配置实体类)
* @author wangxing  
* @date 2015年4月27日 下午3:54:02
* @version V1.0
 */
public class MainServlet extends GenericServlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(MainServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private boolean INIT_CONTEXT = false;
	
	private DispatcherServlet dispacher = new DispatcherServlet();
	
	private ContextLoaderListener contextLoader = new ContextLoaderListener();
	
	private ServletConfig config = null;
	
	private InstallStepManager installer = new InstallStepManager();
	
	private final static String INITED_FILE_NAME = ".AppInitContext";
	
	private final static String COLON = ":";  // 冒号
	
	private final static String SLASH = "/";  // 斜杠
	
	private final static String QUESTION_MARK = "?";  // 斜杠
	
	private final static String RUN = "run";
	
	private final static String NET_SF_LOG4JDBC_DRIVERSPY = "net.sf.log4jdbc.DriverSpy";
	
	/** oracle容器 *//*
	private final static String ORACLE_JDBC_ORACLEDRIVER = "oracle.jdbc.OracleDriver";
	
	private final static String JDBC_LOG4JDBC_ORACLE_THIN = "jdbc:log4jdbc:oracle:thin:@";
	
	private final static String JDBC_ORACLE_THIN = "jdbc:oracle:thin:@";*/
	
	/** mySQL容器 */
	private final static String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private final static String MYSQL_CONTAINER = "allowMultiQueries=true&autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
	
	private final static String JDBC_LOG4JJDBC_MYSQL = "jdbc:log4jdbc:mysql://";
	
	private final static String JDBC_MYSQL = "jdbc:mysql://";
	
	private static MainServlet uniqueInstance = null;
	
	
	public static MainServlet getInstance() {
	
		if (uniqueInstance == null) {
			uniqueInstance = new MainServlet();
		}
		return uniqueInstance;
	}
	
	
	public static boolean contextInited() {
	
		return MainServlet.getInstance().INIT_CONTEXT;
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	
		this.config = config;
		
		// 检查系统是否已未完成配置
		URL initFileUrl = getClass().getClassLoader().getResource(INITED_FILE_NAME);
		if (initFileUrl != null) {
			this.initAppContext(config);
		}
	}
	
	
	private void initAppContext(ServletConfig config) throws ServletException {
	
		this.contextLoader.initWebApplicationContext(config.getServletContext());
		this.dispacher.init(config);
		MainServlet.getInstance().INIT_CONTEXT = true;
	}
	
	
	@Override
	public void destroy() {
	
		if (MainServlet.getInstance().INIT_CONTEXT) {
			contextLoader.closeWebApplicationContext(config.getServletContext());
			dispacher.destroy();
		}
		MainServlet.getInstance().INIT_CONTEXT = false;
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
			if (MainServlet.getInstance().INIT_CONTEXT) {
				dispacher.service(req, res);
			} else {
				String step = req.getParameter("step");
				
				if ("setting".equals(step)) {
					req.getRequestDispatcher("install/view/setting.jsp").forward(req, res);
				} else if ("testConnect".equals(step)) {
					//installer.testConnect(req, res);
					return;
				} else if ("install".equals(step)) {
					installer.doInstall(req, res);
				} else {	
					LOG.info("进入安装页面！");
					req.getRequestDispatcher("install/view/setting.jsp").forward(req, res);
				}
			}
	}
	
	class InstallStepManager {
		
		/**
		 * 安装配置文件
		 * @param req
		 * @throws IOException
		 */
		private void doInstall(ServletRequest req, ServletResponse res) throws IOException {
		
			System.out.println("【mysql：】" + req.getParameter("mysqlId"));
			
			String dataMySQL = req.getParameter("mysqlId");
			
			final String mapperLocations_mysql = "classpath*:/mybatis/mysql/**/*Mapper.xml";
			
			/*
			 * jdbc:log4jdbc:mysql://25.30.5.155:3306/orcl?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf-8
			 * jdbc:mysql://25.30.5.155:3306/orcl
			 */
			if (dataMySQL.equals("MySQL")) {
				String dbhost = req.getParameter("dbhost1");
				String dbname = req.getParameter("dbname1");
				String dbport = req.getParameter("dbport1");
				final String pwd = req.getParameter("pwd1");
				final String uname = req.getParameter("uname1");
				final String runModel = req.getParameter("runModel1");
				final String driverClass = RUN.equals(runModel) ? NET_SF_LOG4JDBC_DRIVERSPY : COM_MYSQL_JDBC_DRIVER;
				final String dbUrl = new StringBuilder().append(RUN.equals(runModel) ? JDBC_LOG4JJDBC_MYSQL : JDBC_MYSQL).append(dbhost).append(COLON).append(dbport).append(SLASH).append(dbname).append(QUESTION_MARK).append(MYSQL_CONTAINER).toString();
				
				System.out.println("===" + dbUrl);
				
				ClassLoader load = getClass().getClassLoader();
				try {
					SAXReader reader = new SAXReader();
					File file = new File(load.getResource("spring/applicationContext.xml").getFile());
					LOG.info("配置数据库文件：" + file.getAbsolutePath());
					Document doc = reader.read(file);
					doc.accept(new VisitorSupport() {
						
						@SuppressWarnings("rawtypes")
						public void visit(Element el) {
						
							List elementList = el.attributes();
							for (Iterator iter1 = elementList.iterator(); iter1.hasNext();) {
								// 将每个属性转化为一个抽象属性，然后获取其名字和值
								AbstractAttribute aa = (AbstractAttribute) iter1.next();
								System.out.println("Name:" + aa.getName() + ";Value:" + aa.getValue());
								
								if ("name".equals(aa.getName()) && "mapperLocations".equals(aa.getValue())) {
									el.addAttribute("value", mapperLocations_mysql);
								}
								
							}
							
							if (el != null && el.getParent() != null && el.getParent().getParent() != null && el.getParent().getParent().attribute("profile") != null && "development".equals(el.getParent().getParent().attribute("profile").getText())) {
								String name = el.attribute("name").getText();
								if (!"validationQuery".equals(name) && !"testWhileIdle".equals(name) 
										&& !"filters".equals(name) && !"proxyFilters".equals(name)
										&& !"dataSource".equals(name)) {
									
									String value = "";
									
									if ("url".equals(name)) {
										
										value = dbUrl;
									} else if ("driverClassName".equals(name)) {
										
										value = driverClass;
									} else if ("username".equals(name)) {
										
										value = uname;
									} else if ("password".equals(name)) {
										
										value = pwd;
									}
									
									LOG.info("获取节点名：" + name + ",值：" + value);
									el.addAttribute("value", value);
								}
							}
						}
					});
					OutputFormat outFmt = new OutputFormat("\t", true);  
				    outFmt.setEncoding("UTF-8");  
				    XMLWriter writer = new XMLWriter(new FileOutputStream(file), outFmt); 
					//XMLWriter writer = new XMLWriter(new FileWriter(file));
					writer.write(doc);
					writer.close();
					LOG.info("系统完成配置，开始启动！");
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
					res.getWriter().write("{\"success\":false,\"errMsg\":\"" + e.getMessage().replace("\n", "") + "\"}");
					return;
				}
				try {
					System.out.println(MainServlet.this.config);
					MainServlet.this.initAppContext(MainServlet.this.config);
					MainServlet.this.config.getServletContext().log("系统完成配置，开始启动应用！");
					
					String rootClassPath = req.getServletContext().getRealPath("WEB-INF/classes");
					File initFile = new File(rootClassPath + File.separator + INITED_FILE_NAME);
					LOG.info("创建初始配置文件：" + initFile.getAbsolutePath());
					
					if (!initFile.createNewFile()) {
						req.getServletContext().log("创建初始配置文件[" + initFile.getAbsolutePath() + "]失败！请检查！");
					}
					
					LOG.info("系统完成配置，开始启动！");
				} catch (ServletException e) {
					MainServlet.this.destroy();
					LOG.error(e.getMessage(), e);
					res.getWriter().write("{\"success\":false,\"errMsg\":\"" + e.getMessage().replace("\n", "") + "\"}");
					return;
				}
				res.getWriter().write("{\"success\":true}");
			}
		}
	}
}
