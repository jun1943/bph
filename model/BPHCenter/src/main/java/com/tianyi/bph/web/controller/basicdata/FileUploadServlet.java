package com.tianyi.bph.web.controller.basicdata;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

import com.tianyi.bph.domain.basicdata.Icons;

@SuppressWarnings("serial") 
public class FileUploadServlet extends HttpServlet {

	 
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;

		PreparedStatement ps = null;
		int iconId = 0;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1000 * 1024 * 1024);
		List itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadBase.SizeLimitExceededException e) {
			// 请求数据的size超出了规定的大小.
			e.printStackTrace();
			request.setAttribute("uploadError", "请求数据的size超出了规定的大小");
			request.getRequestDispatcher("/basicdata/icons/iconsAdd.jsp?optType=0").forward(request,
					response);
			return;
		} catch (FileUploadBase.InvalidContentTypeException e) {
			// 无效的请求类型,即请求类型enctype != "multipart/form-data"
			request.setAttribute("uploadError",
					"请求类型enctype != multipart/form-data");
			request.getRequestDispatcher("/basicdata/icons/iconsAdd.jsp?optType=1").forward(request,
					response);
			return;
		} catch (FileUploadException e) {
			// 如果都不是以上子异常,则抛出此总的异常,出现此异常原因无法说明.
			request.setAttribute("uploadError", "上传过程异常，导致其原因可能是磁盘已满或者其它原因");
			request.getRequestDispatcher("/basicdata/icons/iconsAdd.jsp?optType=2").forward(request,
					response);
			return;
		}
		if (itemList != null) {
			Iterator it = itemList.iterator();
			Icons icons = new Icons();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (item.isFormField()) {
					// 非文件流
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");

					if (item.getFieldName().equals("iconsType")) {
						if (value.isEmpty() || value.equals("")
								|| value.equals("0")) {
							request.setAttribute("uploadError", "请选择图片类型");
							request.getRequestDispatcher

							("/basicdata/icons/iconsAdd.jsp?optType=3").forward(request, response);
							return;
						} else {
							icons.setTypeId(Integer.parseInt(value));
						}
					}

					if (item.getFieldName().equals("iconsName")) {
						if (value.isEmpty() || value.equals("")
								|| value.equals("0")) {
							request.setAttribute("uploadError", "请输入图标名称");
							request.getRequestDispatcher

							("/basicdata/icons/iconsAdd.jsp?optType=4").forward(request, response);
							return;
						} else {
							icons.setName(value);
						}
					}

					icons.setSyncState(true);
					icons.setPlatformId(1);

					if (item.getFieldName().equals("iconsId")) {
						if (value.equals("0")) {
							icons.setId(0);
						} else {
							icons.setId(Integer.parseInt(value));
						}
					}
					// System.out.println(value);
					// System.out.println(value);
				} else {
					String uploadPath = request.getRealPath("uploadIcon");
					String totalName = item.getName();
					String name = "temp";
					if (totalName != "") {
						int index = totalName.lastIndexOf("\\");
						name = totalName.substring(index + 1);
						name = new String(name.getBytes("ISO-8859-1"), "UTF-8");

						// System.out.println(name);
					} else {
						name = "temp";
					}

					String path = uploadPath + "/" + name; 
					String sql = "insert into t_icon (type_id,name,icon_url,sync_state, platform_id) values (?,?,?,?,?)";	
					try {
						item.write(new File(path));
						BufferedImage bi = ImageIO.read(new File(path));
						if(bi == null){ 
							request.setAttribute("uploadError", "上传文件格式出错，不是png格式的图片文件，请重新选择文件上传");
							request.getRequestDispatcher

							("/basicdata/icons/iconsAdd.jsp?optType=5").forward(request, response);
							return;
						}else{

							List<String> s = new ArrayList<String>();
							s.add("zhangsan");
							s.add("zhangsan");
							s.add("zhangsan");
							s.add("zhangsan");
							request.setAttribute("uploadError", "图片上传成功"); 
							
							try {
								conn = DBClassMysql.getMysql(); 
								ps = conn.prepareStatement(sql);
								ps.setInt(1, icons.getTypeId());
								ps.setString(2, icons.getName());
								ps.setString(3, "uploadIcon/" + name);
								ps.setBoolean(4, true);
								ps.setInt(5, 1);

								iconId = ps.executeUpdate();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								request.setAttribute("uploadError", "写入数据库出错");
								request.getRequestDispatcher

								("/basicdata/icons/iconsAdd.jsp?optType=5").forward(request, response);
								return;
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("uploadError", "写入磁盘错误");
						request.getRequestDispatcher

						("/basicdata/icons/iconsAdd.jsp?optType=5").forward(request, response);
						return;
					}	
				}
			}
		} else {
			request.setAttribute("uploadError", "请选择要上传的图标！");
			request.getRequestDispatcher("/basicdata/icons/iconsAdd.jsp?optType=6").forward(request,
					response);
			return;
		} 
		request.getRequestDispatcher("/basicdata/icons/iconsAdd.jsp").forward(request,
				response);
	}
//	public void save(final Icons icons,final String name ) {
//		String sql = "insert into t_icon (type_id,name,icon_url,sync_state, platform_id) values (?,?,?,?,?)";  
//		// 插入日志信息
//		try {
//			jdbcTemplate.update(sql, new PreparedStatementSetter() {
//				public void setValues(PreparedStatement ps) throws SQLException { 
//					ps.setInt(1, icons.getTypeId());
//					ps.setString(2, icons.getName());
//					ps.setString(3, "uploadIcon/" + name);
//					ps.setBoolean(4, true);
//					ps.setInt(5, 1);
//				}
//			});
//		} catch (UncategorizedSQLException e) {
//			SQLException sqle = e.getSQLException();
//			String tableNotExist = "Table has no partition for value"; 
//				throw e; 
//		}
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
