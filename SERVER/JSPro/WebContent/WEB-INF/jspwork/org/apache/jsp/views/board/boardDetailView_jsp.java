/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-03-11 06:14:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.uni.board.model.vo.*;
import com.uni.member.model.vo.Member;

public final class boardDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/board/../common/menubar.jsp", Long.valueOf(1646875811343L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.uni.board.model.vo");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.uni.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");

	Board b = (Board)request.getAttribute("b");
	Attachment at = (Attachment)request.getAttribute("at");

      out.write("  \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer{\r\n");
      out.write("		width:800px;\r\n");
      out.write("		height:500px;\r\n");
      out.write("		background:black;\r\n");
      out.write("		color:white;\r\n");
      out.write("		margin:auto;\r\n");
      out.write("		margin-top:50px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.outer>table, .outer>table tr>*{\r\n");
      out.write("		border:1px solid white;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.outer>table{\r\n");
      out.write("		width:600px;\r\n");
      out.write("		height:300px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.outer>table p{\r\n");
      out.write("		height:230px;\r\n");
      out.write("		margin:0;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.replyArea{\r\n");
      out.write("		width:800px;\r\n");
      out.write("		color:white;\r\n");
      out.write("		background:black;\r\n");
      out.write("		margin:auto;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("  <!-- menubar ?????? -->\r\n");
      out.write("<!-- import -->\r\n");

	Member loginUser = (Member)session.getAttribute("loginUser");//object ???????????? ???????????? ?????????
	
	String msg = (String)session.getAttribute("msg");//(String) ?????? ?????????
	
	String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script> <!-- jQuery ?????? js??? cdm ???????????? ??????, ????????? js ????????????????????? head\r\n");
      out.write("																							????????? ??????????????? ????????? ?????? ?????? ????????????  body ?????? ?????? ????????? ??????. -->\r\n");
      out.write("<style>\r\n");
      out.write("	body{\r\n");
      out.write("		background:url('");
      out.print(request.getContextPath() );
      out.write("/resources/images/bg.jpg') no-repeat; \r\n");
      out.write("		background-size:cover;\r\n");
      out.write("	}\r\n");
      out.write("	/* ????????? ??? ?????? ?????????*/\r\n");
      out.write("	#loginForm, #userInfo{float:right;}\r\n");
      out.write("	.btns button{border-radius:5px;}\r\n");
      out.write("	#enrollBtn, #mypageBtn{background-color:yellowgreen;}\r\n");
      out.write("	#loginBtn, #logoutBtn{background-color:orangered;}\r\n");
      out.write("	#userInfo a{text-decoration:none;color:white;}\r\n");
      out.write("	\r\n");
      out.write("	/* ???????????? ?????? ?????????*/\r\n");
      out.write("	.navWrap{background-color:black; width:100%; height:50px}\r\n");
      out.write("	.navWrap>.nav{width:600px;margin:auto;}\r\n");
      out.write("	.menu{text-align:center;color:white;font-weight:bold;width:150px;height:50px;display:table-cell;font-size:20px;vertical-align:middle;}\r\n");
      out.write("	.menu:hover{background-color:darkgray;}\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("	\r\n");
      out.write("	$(function(){\r\n");
      out.write("		var msg = \"");
      out.print(msg);
      out.write("\";\r\n");
      out.write("		if(msg !=\"null\"){ //null ??? ????????? ????????? ?????? ?????? ??????.\r\n");
      out.write("			alert(msg);\r\n");
      out.write("			");
session.removeAttribute("msg");
      out.write("// ???????????? ?????? ?????? ????????? ??????. ????????? remobeAttribute ??????\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	function loginValidate(){\r\n");
      out.write("		if($(\"#userId\").val().trim().length === 0 ){// userId ??? val ?????? ???????????? trim??? ?????? length ????????? === 0 ?????? ????????? \r\n");
      out.write("			alert(\"???????????? ??????????????? \"); // ????????? 0 ?????? ????????? ???????????? ??????????????? ???????????? ????????????.\r\n");
      out.write("			$(\"#userId\").focus();// userId ??? ???????????? ??????.\r\n");
      out.write("			return false;//return ??? ????????????????????? false??? ??????.\r\n");
      out.write("		}\r\n");
      out.write("		if($(\"#userPwd\").val().trim().length === 0 ){// userPwd ??? val ?????? ???????????? trim??? ?????? length ????????? === 0 ?????? ????????? \r\n");
      out.write("			alert(\"??????????????? ??????????????? \");// ????????? 0 ?????? ????????? ???????????? ??????????????? ???????????? ????????????.\r\n");
      out.write("			$(\"#userPwd\").focus();// userPwd ??? ???????????? ??????.\r\n");
      out.write("			return false;//return ??? ????????????????????? false??? ??????.\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		return true; // ?????? ?????? ???????????? return true..\r\n");
      out.write("	}\r\n");
      out.write("</script>																					\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1 align=\"center\" style=\"color:black;\">welcome JSP World!</h1>\r\n");
      out.write("	<div class=\"loginArea\">\r\n");
      out.write("	\r\n");
      out.write("	");
 if ( loginUser == null ) {
      out.write(" <!-- ????????? ????????? null ?????? -->\r\n");
      out.write("		<form id = \"loginForm\" action=\"");
      out.print(request.getContextPath());
      out.write("/loginMember.do\" method=\"post\" onsubmit=\"return loginValidate();\"> \r\n");
      out.write("		<!-- loginMenber.do ??? ???????????? ??????. --> \r\n");
      out.write("		<!-- ????????? project ?????? ???????????????. requset.getContextPath() ?????? -->\r\n");
      out.write("			<table>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th><label for = \"userId\" style=\"color:white;\">?????????</label></th> <!-- ????????? ????????????????????? ????????? ???????????????  get ????????? ?????? post ???????????? ????????????. -->\r\n");
      out.write("						<td><input id=\"userId\" type=\"text\" name=\"userId\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th><label for = \"userPwd\" style=\"color:white;\">????????????</label></th>\r\n");
      out.write("						<td><input id=\"userPwd\" type=\"text\" name=\"userPwd\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("				<div class =\"btns\" align=\"center\">\r\n");
      out.write("					\r\n");
      out.write("					<button id = \"loginBtn\" type=\"submit\">?????????</button>\r\n");
      out.write("				    <button id = \"enrollBtn\" type=\"button\" onclick=\"enrollPage();\">????????????</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			\r\n");
      out.write("			</form>\r\n");
      out.write("	");
 } else{ 
      out.write(" <!-- ????????? ????????? Null ??? ???????????? -->\r\n");
      out.write("			<div id = \"userInfo\">\r\n");
      out.write("				<b style = \"color:white;\">");
      out.print(loginUser.getUserName() );
      out.write(" ??? </b> ??? ????????? ???????????????.\r\n");
      out.write("				<br><br>\r\n");
      out.write("				<div class =\"btns\" align=\"center\">\r\n");
      out.write("					<a href = \"");
      out.print(request.getContextPath() );
      out.write("/mypageMember.do\">???????????????</a>\r\n");
      out.write("					<a href = \"");
      out.print(request.getContextPath() );
      out.write("/logoutMember.do\">????????????</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			</div>\r\n");
      out.write("	");
} 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		function enrollPage(){//????????? ??????????????? ContextPath()??? enrollFormMember.do ??? ???????????????. \r\n");
      out.write("			location.href=\"");
      out.print( request.getContextPath());
      out.write("/enrollFormMember.do\";\r\n");
      out.write("		}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("	<br clear=\"both\">\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"navWrap\">\r\n");
      out.write("			<div class=\"nav\">\r\n");
      out.write("				<div class=\"menu\" onclick=\"goMain();\">HOME</div>\r\n");
      out.write("				<div class=\"menu\" onclick=\"goNotice();\">????????????</div>\r\n");
      out.write("				<div class=\"menu\" onclick=\"goBoard();\">?????????</div>\r\n");
      out.write("				<div class=\"menu\" onclick=\"goThumbnail();\">???????????????</div>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<script>\r\n");
      out.write("		function goMain(){//home\r\n");
      out.write("			location.href=\"");
      out.print( request.getContextPath());
      out.write("\";\r\n");
      out.write("		}\r\n");
      out.write("		function goNotice(){//????????????\r\n");
      out.write("			location.href=\"");
      out.print( request.getContextPath());
      out.write("/listNotice.do\";\r\n");
      out.write("		}\r\n");
      out.write("		function goBoard(){//\r\n");
      out.write("			location.href=\"");
      out.print( request.getContextPath());
      out.write("/listBoard.do\";\r\n");
      out.write("		}\r\n");
      out.write("		function goThumbnail(){\r\n");
      out.write("			location.href=\"");
      out.print( request.getContextPath());
      out.write("/listThumb.do\";\r\n");
      out.write("		}\r\n");
      out.write("		</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<h2 align=\"center\">????????? ????????????</h2>\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<table align=\"center\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"100\">??????</th>\r\n");
      out.write("				<td>");
      out.print( b.getCategory() );
      out.write("</td>\r\n");
      out.write("				<th>??????</th>\r\n");
      out.write("				<td colspan=\"2\">");
      out.print( b.getBoardTitle() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>?????????</th>\r\n");
      out.write("				<td>");
      out.print( b.getBoardWriter() );
      out.write("</td>\r\n");
      out.write("				<th>?????????</th>\r\n");
      out.write("				<td>");
      out.print( b.getCreateDate() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>??????</th>\r\n");
      out.write("				<td colspan=\"3\">\r\n");
      out.write("					<p>");
      out.print( b.getBoardContent() );
      out.write("</p>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>????????????</th>\r\n");
      out.write("				<td colspan=\"3\">\r\n");
      out.write("					");
 if(at != null){ 
      out.write("\r\n");
      out.write("					<a download=\"");
      out.print( at.getOriginName() );
      out.write("\" href=\"");
      out.print(contextPath);
      out.write("/resources/board_upfiles/");
      out.print(at.getChangeName());
      out.write('"');
      out.write('>');
      out.print( at.getOriginName() );
      out.write("</a>\r\n");
      out.write("					");
 }else{ 
      out.write("\r\n");
      out.write("					??????????????? ????????????.\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("				</td> \r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"btns\" align=\"center\">\r\n");
      out.write("			<button type=\"button\" onclick=\"location.href='");
      out.print(contextPath);
      out.write("/listBoard.do?currentPage=1';\">????????????</button>\r\n");
      out.write("			\r\n");
      out.write("			");
 if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())){ 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				<button type=\"button\" onclick=\"updateForm();\">????????????</button>\r\n");
      out.write("				<button type=\"button\" onclick=\"deleteBoard();\">????????????</button>\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<form action=\"\" id=\"postForm\" method=\"post\">\r\n");
      out.write("			<input type=\"hidden\" name=\"bno\" value=\"");
      out.print( b.getBoardNo() );
      out.write("\">\r\n");
      out.write("		</form>\r\n");
      out.write("		<script>\r\n");
      out.write("			function updateForm(){\r\n");
      out.write("				$(\"#postForm\").attr(\"action\", \"");
      out.print(contextPath);
      out.write("/updateFormBoard.do\");\r\n");
      out.write("				$(\"#postForm\").submit();\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			function deleteBoard(){\r\n");
      out.write("				$(\"#postForm\").attr(\"action\", \"");
      out.print(contextPath);
      out.write("/deleteBoard.do\");\r\n");
      out.write("				$(\"#postForm\").submit();\r\n");
      out.write("			}\r\n");
      out.write("		</script>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"replyArea\">\r\n");
      out.write("		<!-- ?????? ???????????? div -->\r\n");
      out.write("		<table border=\"1\" align=\"center\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>????????????</th>\r\n");
      out.write("				");
 if(loginUser != null){ 
      out.write("\r\n");
      out.write("				<td><textarea rows=\"3\" cols=\"60\" id=\"replyContent\" style=\"resize:none;\"></textarea></td>\r\n");
      out.write("				<td><button id=\"addReply\">????????????</button></td>\r\n");
      out.write("				");
 }else{ 
      out.write("\r\n");
      out.write("				<td><textarea readonly rows=\"3\" cols=\"60\" id=\"replyContent\" style=\"resize:none;\">???????????? ???????????? ????????? ??????????????????. ????????? ??? ??????????????????</textarea></td>\r\n");
      out.write("				<td><button disabled>????????????</button></td>\r\n");
      out.write("				");
 } 
      out.write("\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<!-- ?????? ???????????? ???????????? div -->\r\n");
      out.write("		<div id=\"replyListArea\">\r\n");
      out.write("			<table id=\"replyList\" border=\"1\" align=\"center\">\r\n");
      out.write("				<!-- <tr>\r\n");
      out.write("					<td width=\"100px\">admin</td>\r\n");
      out.write("					<td width=\"330px\">??????????????????</td>\r\n");
      out.write("					<td width=\"150px\">2020??? 1??? 23???</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td width=\"100px\">user01</td>\r\n");
      out.write("					<td width=\"330px\">??????????????????</td>\r\n");
      out.write("					<td width=\"150px\">2020??? 1??? 22???</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td width=\"100px\">test01</td>\r\n");
      out.write("					<td width=\"330px\">??????????????????</td>\r\n");
      out.write("					<td width=\"150px\">2020??? 1??? 20???</td>\r\n");
      out.write("				</tr> -->\r\n");
      out.write("			</table>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div> \r\n");
      out.write("	<script>\r\n");
      out.write("	$(function(){\r\n");
      out.write("		selectReplyList();\r\n");
      out.write("		$(\"#addReply\").click(function(){\r\n");
      out.write("			var content = $(\"#replyContent\").val();\r\n");
      out.write("			var bId = ");
      out.print(b.getBoardNo());
      out.write(";\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url:\"rinsert.do\",\r\n");
      out.write("				type:\"post\",\r\n");
      out.write("				data:{\r\n");
      out.write("						content:content,\r\n");
      out.write("					    bId:bId\r\n");
      out.write("				},\r\n");
      out.write("				success:function(status){\r\n");
      out.write("					if(status ==\"success\"){\r\n");
      out.write("						selectReplyList();\r\n");
      out.write("						$(\"#replyContent\").val(\"\");\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error:function(){\r\n");
      out.write("					console.log(\"ajax ???????????? -????????????\")\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("			})\r\n");
      out.write("			\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("	})\r\n");
      out.write("	function selectReplyList(){\r\n");
      out.write("			$(\"#replyList\").empty();\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url:\"rlist.do\",\r\n");
      out.write("				data:{bId:");
      out.print(b.getBoardNo());
      out.write("},\r\n");
      out.write("				type:\"get\",\r\n");
      out.write("				success:function(list){\r\n");
      out.write("					console.log(list)\r\n");
      out.write("				/*	var value=\"\";\r\n");
      out.write("					for(var i in list){\r\n");
      out.write("						value += '<tr>'+\r\n");
      out.write("									'<td width=\"100px\">'+ list[i].replyWriter+'</td>'+ \r\n");
      out.write("									'<td width=\"330px\">'+ list[i].replyContent+'</td>'+ \r\n");
      out.write("									'<td width=\"150px\">'+ list[i].createDate+'</td>'+ \r\n");
      out.write("								'</tr>';\r\n");
      out.write("					}\r\n");
      out.write("					$(\"#replyList\").html(value);\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					//2????????? \r\n");
      out.write("					var value=\"\";\r\n");
      out.write("					$.each(list,function(index,obj){\r\n");
      out.write("						value += '<tr>'+\r\n");
      out.write("								'<td width=\"100px\">'+ obj.replyWriter+'</td>'+ \r\n");
      out.write("								'<td width=\"330px\">'+ obj.replyContent+'</td>'+ \r\n");
      out.write("								'<td width=\"150px\">'+ obj.createDate+'</td>'+ \r\n");
      out.write("						'</tr>';\r\n");
      out.write("					})\r\n");
      out.write("					$(\"#replyList\").html(value);*/\r\n");
      out.write("					\r\n");
      out.write("					// 3??? ??????\r\n");
      out.write("					$.each(list, function(index, obj){\r\n");
      out.write("						\r\n");
      out.write("						var writerTd = $(\"<td>\").text(obj.replyWriter).attr(\"width\", \"100px\");\r\n");
      out.write("						var contentTd = $(\"<td>\").text(obj.replyContent).attr(\"width\", \"330px\");\r\n");
      out.write("						var dateTd = $(\"<td>\").text(obj.createDate).attr(\"width\", \"150px\");\r\n");
      out.write("						\r\n");
      out.write("						var tr = $(\"<tr>\").append(writerTd, contentTd, dateTd);\r\n");
      out.write("						\r\n");
      out.write("						$(\"#replyList\").append(tr);\r\n");
      out.write("						\r\n");
      out.write("					});\r\n");
      out.write("				},\r\n");
      out.write("				error:function(){\r\n");
      out.write("					console.log(\"ajax ???????????? -????????????\")\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("			})\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
