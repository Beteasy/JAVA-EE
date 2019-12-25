<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.entity.KaoQin"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16" href="/AttendenceSystem/assets/images/favicon.png">
<title>Home</title>
<!-- Bootstrap Core CSS -->
<link href="/AttendenceSystem/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/AttendenceSystem/css/style.css" rel="stylesheet">
<!-- You can change the theme colors from here -->
<link href="/AttendenceSystem/css/colors/default-dark.css" id="theme" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


<!-- flatty css -->
<!--[if lt IE 9]>
    <script src='assets/javascripts/html5shiv.js' type='text/javascript'></script>
    <![endif]-->
    <link href='/AttendenceSystem/assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
    <link href='/AttendenceSystem/assets/stylesheets/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery ui -->
    <link href='/AttendenceSystem/assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
    <link href='/AttendenceSystem/assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / switch buttons -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/bootstrap_switch/bootstrap-switch.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / xeditable -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/xeditable/bootstrap-editable.css' media='all' rel='stylesheet' type='text/css' />
    <link href='/AttendenceSystem/assets/stylesheets/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / wysihtml5 (wysywig) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery file upload -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/jquery_fileupload/jquery.fileupload-ui.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / full calendar -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/fullcalendar/fullcalendar.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / select2 -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/select2/select2.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / mention -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/mention/mention.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / tabdrop (responsive tabs) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/tabdrop/tabdrop.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jgrowl notifications -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/jgrowl/jquery.jgrowl.min.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / datatables -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/datatables/bootstrap-datatable.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / dynatrees (file trees) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/dynatree/ui.dynatree.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / color picker -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/bootstrap_colorpicker/bootstrap-colorpicker.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / datetime picker -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.min.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / daterange picker) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flags (country flags) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/flags/flags.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / slider nav (address book) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/slider_nav/slidernav.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / fuelux (wizard) -->
    <link href='/AttendenceSystem/assets/stylesheets/plugins/fuelux/wizard.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flatty theme -->
    <link href='/AttendenceSystem/assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
    <!-- / demo -->
    <link href='/AttendenceSystem/assets/stylesheets/demo.css' media='all' rel='stylesheet' type='text/css' />
</head>

<body class="fix-header card-no-border fix-sidebar">

<%
			PrintWriter writer = response.getWriter();
			List<KaoQin> studentList = (ArrayList<KaoQin>)request.getAttribute("kaoQinList");
			List<Course> courList = (ArrayList<Course>)session.getAttribute("courseList");
			//System.out.print(studentList.size());
			int studentsNumber = studentList.size();	//学生的总数
			int pageSize = 3;	//每页显示3个
			int pageCount = (studentsNumber-1)/pageSize+1;	//计算需要显示多少页
			int pageNum = 1;	//待显示的页面
			int currentPage;
			KaoQin student = null;
			
			if(request.getParameter("pageNum") == null){
				pageNum = 1;
			}
			else{
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			if(pageNum > pageCount){
				pageNum = pageCount;
			}
			else if(pageNum < 1){
				pageNum = 1;
			}
			
			int startIndex = (pageNum-1)*pageSize;	//计算每页开始显示的下标	
			String status = null;    //记录学生的考勤状态
			String courseName = null; 	 //记录课程名称
			String type = null;		//拿到按什么查询
			String date = null;		//拿到查询的日期
			Integer grade = null;	//存年级
			Integer stuNo = 0; 		//存学号
			Integer courseNo = 0;	//拿到课程号
			type = request.getParameter("type");
			date = request.getParameter("date");
			courseNo = Integer.parseInt(request.getParameter("course"));
			Iterator iterator = courList.iterator();
			Map<String,String> map = null;
			map = new HashMap<String,String>();
			while(iterator.hasNext()){
				Course course = (Course)iterator.next();
							
				map.put(String.valueOf(course.getCourNo()), String.valueOf(course.getCourName()));
			}
		%>
		
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">考勤管理系统</p>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">
                        <!-- Logo icon --><b>
                            <img src="/AttendenceSystem/assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
                        <span>
                            <img src="/AttendenceSystem/assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                        </span>
                    </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto">
                        <!-- This is  -->
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav my-lg-0">
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item hidden-xs-down search-box"> <a class="nav-link hidden-sm-down waves-effect waves-dark" href="javascript:void(0)"><i class="ti-search"></i></a>
                            <form class="app-search">
                                <input type="text" class="form-control" placeholder="Search & enter"> <a class="srh-btn"><i class="ti-close"></i></a>
                            </form>
                        </li>
                        <!-- ============================================================== -->
                        <!-- Profile -->
                        <!-- ============================================================== -->
                        <li class="nav-item">
                            <a class="nav-link waves-effect waves-dark" href="#"><img src="/AttendenceSystem/assets/images/users/1.jpg" alt="user" class="profile-pic" /></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li> <a class="waves-effect waves-dark" href="index.html" aria-expanded="false"><i class="mdi mdi-gauge"></i><span class="hide-menu">Dashboard</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="/AttendenceSystem/counselorInput/searchAttenByGrade.jsp" aria-expanded="false"><i class="mdi mdi-account-check"></i><span class="hide-menu">查询年级学生出勤记录</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="/AttendenceSystem/counselorInput/searchAttenByStu.jsp" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">查询学生出勤记录</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="#" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu">请假审批</span></a>
                        	<ul>
                        		<li><a href="/AttendenceSystem/PiJiaController?action=search&range=all">所有假条</a></li>
                        		<li><a href="/AttendenceSystem/PiJiaController?action=search&range=unsanctioned">待批准假条</a></li>
                        		<li><a href="/AttendenceSystem/PiJiaController?action=search&range=sanctioned">已批准假条</a></li>
                        		<li><a href="/AttendenceSystem/PiJiaController?action=search&range=failed">审批不通过假条</a></li>
                        	</ul>
                        </li>
                       
                    </ul>

                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        
        <!-- ä¸ä¸ä¸ºä¸­é´åå®¹ -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
			<div class='row-fluid'>
    <div class='span12 box bordered-box blue-border' style='margin-bottom:0;'>
        <div class='box-header blue-background'>
            <div class='title'>考勤记录</div>
            <div class='actions'>
                <a href="#" class="btn box-remove btn-mini btn-link"><i class='icon-remove'></i>
                </a>
                <a href="#" class="btn box-collapse btn-mini btn-link"><i></i>
                </a>
            </div>
        </div>
        <div class='box-content box-no-padding'>
            <div class='responsive-table'>
                <div class='scrollable-area'>
                    <table class='table' style='margin-bottom:0;'>
                        <thead>
                        <tr>
                            <th>
                                	学号
                            </th>
                            <th>
                                	姓名
                            </th>
                            <th>年级</th>
                            <th>
                                	班级
                            </th>
                            <th>课程</th>
                            <th>时间</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
							for(int i=startIndex; i<startIndex+pageSize && i<studentsNumber; i++){
							student = studentList.get(i);
							//courseNo = student.getCourNo();
							String CN = String.valueOf(student.getCourNo());
							courseName = (String)map.get(CN);
        						System.out.println("view coursename:"+courseName);
							
							switch(student.getStatus()){
						case 0:
						status = "到勤";
						break;
					case 1:
						status = "迟到";
						break;
					case 2:
						status = "旷课";
						break;
					case 3:
						status = "请假";
						break;
					default:
						break;
					}
						%>
							<tr>
                            <td><%=student.getStuNo()%></td>
                            <td><%=student.getStuName()%></td>
                            <td><%=student.getGrade()%></td>
                            <td><%=student.getClassId()%></td>
                            <td><%=courseName%></td>
                            <td><%=student.getDate()%></td>
                            <%
								if(student.getStatus()==0){
							%>
							<td>
                                <span class='label label-success'><%=status%></span>
                            </td>
							<%
							}
							%>
							<%
								if(student.getStatus()==1){
							%>
							 <td>
                                <span class='label label-warning'><%=status%></span>
                            </td>
							<%
							}
							%>
							<%
								if(student.getStatus()==2){
							%>
                            <td>
                                <span class='label label-important'><%=status%></span>
                            </td>
                            <%
							}
							%>
							<%
								if(student.getStatus()==3){
							%>
							 <td>
                                <span class='label label-warning'><%=status%></span>
                            </td>
							<%
							}
							%>
                        </tr>
                        <%
						}
						%>
                        </tbody>
                    </table>
                    共<%=studentsNumber%>个记录，分<%=pageCount%>页显示/当前第<%=pageNum%>页     <%
				if (type.equals("grade")) {
					grade = Integer.parseInt(request.getParameter("grade"));
					for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?pageNum=" + j + "&grade="+grade+"&course="+courseNo+"&date="+date+"'>"
										+ j + "</a>");
							}
				}
				if (type.equals("student")) {
				stuNo = Integer.parseInt(request.getParameter("stuNo"));
					for (int j = 1; j <= pageCount; j++) {
					out.print("&nbsp;&nbsp;<a href='?pageNum=" + j + "&stuNo="+stuNo+"&course="+courseNo+"&date="+date+"'>"
										+ j + "</a>");
							}
				}
				
		%>
                </div>
            </div>
        </div>
    </div>
</div>
         </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer">Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="/AttendenceSystem/assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="/AttendenceSystem/assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="/AttendenceSystem/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="/AttendenceSystem/js/perfect-scrollbar.jquery.min.js"></script>
    <!--Wave Effects -->
    <script src="/AttendenceSystem/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="/AttendenceSystem/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="/AttendenceSystem/js/custom.min.js"></script>
    
    
    <!-- flatty script -->
    <div>
    	<!-- / jquery -->
<script src='/AttendenceSystem/assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
<!-- / jquery mobile events (for touch and slide) -->
<script src='/AttendenceSystem/assets/javascripts/plugins/mobile_events/jquery.mobile-events.min.js' type='text/javascript'></script>
<!-- / jquery migrate (for compatibility with new jquery) -->
<script src='/AttendenceSystem/assets/javascripts/jquery/jquery-migrate.min.js' type='text/javascript'></script>
<!-- / jquery ui -->
<script src='/AttendenceSystem/assets/javascripts/jquery_ui/jquery-ui.min.js' type='text/javascript'></script>
<!-- / bootstrap -->
<script src='/AttendenceSystem/assets/javascripts/bootstrap/bootstrap.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/flot/excanvas.js' type='text/javascript'></script>
<!-- / sparklines -->
<script src='/AttendenceSystem/assets/javascripts/plugins/sparklines/jquery.sparkline.min.js' type='text/javascript'></script>
<!-- / flot charts -->
<script src='/AttendenceSystem/assets/javascripts/plugins/flot/flot.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/flot/flot.resize.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/flot/flot.pie.js' type='text/javascript'></script>
<!-- / bootstrap switch -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_switch/bootstrapSwitch.min.js' type='text/javascript'></script>
<!-- / fullcalendar -->
<script src='/AttendenceSystem/assets/javascripts/plugins/fullcalendar/fullcalendar.min.js' type='text/javascript'></script>
<!-- / datatables -->
<script src='/AttendenceSystem/assets/javascripts/plugins/datatables/jquery.dataTables.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/datatables/jquery.dataTables.columnFilter.js' type='text/javascript'></script>
<!-- / wysihtml5 -->
<script src='/AttendenceSystem/assets/javascripts/plugins/common/wysihtml5.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/common/bootstrap-wysihtml5.js' type='text/javascript'></script>
<!-- / select2 -->
<script src='/AttendenceSystem/assets/javascripts/plugins/select2/select2.js' type='text/javascript'></script>
<!-- / color picker -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_colorpicker/bootstrap-colorpicker.min.js' type='text/javascript'></script>
<!-- / mention -->
<script src='/AttendenceSystem/assets/javascripts/plugins/mention/mention.min.js' type='text/javascript'></script>
<!-- / input mask -->
<script src='/AttendenceSystem/assets/javascripts/plugins/input_mask/bootstrap-inputmask.min.js' type='text/javascript'></script>
<!-- / fileinput -->
<script src='/AttendenceSystem/assets/javascripts/plugins/fileinput/bootstrap-fileinput.js' type='text/javascript'></script>
<!-- / modernizr -->
<script src='/AttendenceSystem/assets/javascripts/plugins/modernizr/modernizr.min.js' type='text/javascript'></script>
<!-- / retina -->
<script src='/AttendenceSystem/assets/javascripts/plugins/retina/retina.js' type='text/javascript'></script>
<!-- / fileupload -->
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/tmpl.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/load-image.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/canvas-to-blob.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/jquery.iframe-transport.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/jquery.fileupload.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/jquery.fileupload-fp.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/jquery.fileupload-ui.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/fileupload/jquery.fileupload-init.js' type='text/javascript'></script>
<!-- / timeago -->
<script src='/AttendenceSystem/assets/javascripts/plugins/timeago/jquery.timeago.js' type='text/javascript'></script>
<!-- / slimscroll -->
<script src='/AttendenceSystem/assets/javascripts/plugins/slimscroll/jquery.slimscroll.min.js' type='text/javascript'></script>
<!-- / autosize (for textareas) -->
<script src='/AttendenceSystem/assets/javascripts/plugins/autosize/jquery.autosize-min.js' type='text/javascript'></script>
<!-- / charCount -->
<script src='/AttendenceSystem/assets/javascripts/plugins/charCount/charCount.js' type='text/javascript'></script>
<!-- / validate -->
<script src='/AttendenceSystem/assets/javascripts/plugins/validate/jquery.validate.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/validate/additional-methods.js' type='text/javascript'></script>
<!-- / naked password -->
<script src='/AttendenceSystem/assets/javascripts/plugins/naked_password/naked_password-0.2.4.min.js' type='text/javascript'></script>
<!-- / nestable -->
<script src='/AttendenceSystem/assets/javascripts/plugins/nestable/jquery.nestable.js' type='text/javascript'></script>
<!-- / tabdrop -->
<script src='/AttendenceSystem/assets/javascripts/plugins/tabdrop/bootstrap-tabdrop.js' type='text/javascript'></script>
<!-- / jgrowl -->
<script src='/AttendenceSystem/assets/javascripts/plugins/jgrowl/jquery.jgrowl.min.js' type='text/javascript'></script>
<!-- / bootbox -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootbox/bootbox.min.js' type='text/javascript'></script>
<!-- / inplace editing -->
<script src='/AttendenceSystem/assets/javascripts/plugins/xeditable/bootstrap-editable.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/xeditable/wysihtml5.js' type='text/javascript'></script>
<!-- / ckeditor -->
<script src='/AttendenceSystem/assets/javascripts/plugins/ckeditor/ckeditor.js' type='text/javascript'></script>
<!-- / filetrees -->
<script src='/AttendenceSystem/assets/javascripts/plugins/dynatree/jquery.dynatree.min.js' type='text/javascript'></script>
<!-- / datetime picker -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_datetimepicker/bootstrap-datetimepicker.js' type='text/javascript'></script>
<!-- / daterange picker -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_daterangepicker/moment.min.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_daterangepicker/bootstrap-daterangepicker.js' type='text/javascript'></script>
<!-- / max length -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_maxlength/bootstrap-maxlength.min.js' type='text/javascript'></script>
<!-- / dropdown hover -->
<script src='/AttendenceSystem/assets/javascripts/plugins/bootstrap_hover_dropdown/twitter-bootstrap-hover-dropdown.min.js' type='text/javascript'></script>
<!-- / slider nav (address book) -->
<script src='/AttendenceSystem/assets/javascripts/plugins/slider_nav/slidernav-min.js' type='text/javascript'></script>
<!-- / fuelux -->
<script src='/AttendenceSystem/assets/javascripts/plugins/fuelux/wizard.js' type='text/javascript'></script>
<!-- / flatty theme -->
<script src='/AttendenceSystem/assets/javascripts/nav.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/tables.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/theme.js' type='text/javascript'></script>
<!-- / demo -->
<script src='/AttendenceSystem/assets/javascripts/demo/jquery.mockjax.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/demo/inplace_editing.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/demo/charts.js' type='text/javascript'></script>
<script src='/AttendenceSystem/assets/javascripts/demo/demo.js' type='text/javascript'></script>
    </div>
</body>

</html>