<%@ tag import="java.util.Map"%>
<%@ tag import="com.tianyi.bph.common.Pager"%>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="Pager" required="true"%>

<div id="pager">
<%

String uri=request.getAttribute("URI").toString();	
out.print("<a href='"+uri+"'>首页</a>");
if(page.getCurrentPage()>0){
	out.print("<a href='"+uri+"?pageNo="+(page.getCurrentPage()-1)+"'>上一页</a>");
}
if(page.getCurrentPage()<(page.getTotalPages()-1)){
	out.print("<a href='"+uri+"?pageNo="+(page.getCurrentPage()+1)+">下一页</a>");
}
out.print("<a href='"+uri+"?pageNo="+(page.getTotalPages()-1)+"'>尾页</a>");
%>
</div>