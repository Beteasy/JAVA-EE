<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.entity.JiaTiao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.daoImpl.CounselorDaoImpl"%>
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
    <title>假条详情</title>
    <!-- Bootstrap Core CSS -->
    <link href="/AttendenceSystem/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- This page CSS -->
    <!-- chartist CSS -->
    <link href="/AttendenceSystem/assets/plugins/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="/AttendenceSystem/assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <!--c3 CSS -->
    <link href="/AttendenceSystem/assets/plugins/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/AttendenceSystem/css/style.css" rel="stylesheet">
    <!-- Dashboard 1 Page CSS -->
    <link href="/AttendenceSystem/css/pages/dashboard.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="/AttendenceSystem/css/colors/default-dark.css" id="theme" rel="stylesheet">
    
    
    <!-- flatty css-->
     <script src='/AttendenceSystem/assets/javascripts/html5shiv.js' type='text/javascript'></script>
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
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header fix-sidebar card-no-border">
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
                        <li> <a class="waves-effect waves-dark" href="/AttendenceSystem/counselorInput/searchAttenByGrade.jsp" aria-expanded="false"><i class="mdi mdi-account-check"></i><span class="hide-menu">查询年级学生出勤记录</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="/AttendenceSystem/counselorInput/searchAttenByStu.jsp" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">查询学生出勤记录</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="/AttendenceSystem/counselorInput/piJia.jsp" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu">请假审批</span></a>
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
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
           	<div class='row-fluid'>
                    <div class='span12 box'>
                        <div class='box-header blue-background'>
                            <div class='title'>假条详情</div>
                            <div class='actions'>
                                <a href="#" class="btn box-remove btn-mini btn-link"><i class='icon-remove'></i>
                                </a>
                                <a href="#" class="btn box-collapse btn-mini btn-link"><i></i>
                                </a>
                            </div>
                        </div>
                        <div class='box-content'>
                        <%
						String idString = request.getParameter("id");
						PrintWriter writer = response.getWriter();
						Integer id = Integer.parseInt(idString);
						CounselorDaoImpl counselorDaoImpl = new CounselorDaoImpl();
						JiaTiao jiaTiao = null;
						System.out.print("idString:"+idString);
						System.out.print("id:"+id);
						jiaTiao = counselorDaoImpl.getJiaTiaoById(id);
						
						//做界面显示的转换
						String type = null;
						String status = null;
						
						switch(jiaTiao.getType()){
						case 1:
							type = "病假";
							break;
						case 2:
							type = "事假";
							break;
						default:
							break;
						}
						
						switch(jiaTiao.getStatus()){
						case 0:
							status = "待审批";
							break;
						case 1:
							status = "批准请假";
							break;
						case 2:
							status = "审核不通过";
							break;
						default:
							break;
						}
						
					%>
                            <form class='form form-horizontal validate-form' style='margin-bottom: 0;' />
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>编号</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name="id" name='validation_name'  type='text' value="<%=jiaTiao.getId() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>学号</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="stuNo" value="<%=jiaTiao.getStuNo() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>姓名</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="stuName" value="<%=jiaTiao.getStuName() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>年级</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="grade" value="<%=jiaTiao.getGrade() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>班级</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="classId" value="<%=jiaTiao.getClassId() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>课程</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="courNo" value="<%=jiaTiao.getCourNo() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>类型</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="title" value="<%=type %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_email'>内容</label>	
                                    <div class='controls'>
                                        <textarea  id='validation_email' name='validation_email' name="content" readonly="readonly"   ><%=jiaTiao.getContent() %></textarea>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_password'>开始日期</label>
                                    <div class='controls'>
                                        <input id='validation_password' name='validation_password' type='text' name="startdate" value="<%=jiaTiao.getStartdate() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_password'>截止日期</label>
                                    <div class='controls'>
                                        <input id='validation_password' name='validation_password' type='text' name="enddate" value="<%=jiaTiao.getEnddate() %>" readonly="readonly"/>
                                    </div>
                                </div>
                                <div class='control-group'>
                                    <label class='control-label' for='validation_name'>状态</label>
                                    <div class='controls'>
                                        <input  id='validation_name' name='validation_name'  type='text' name="status" value="<%=status %>" readonly="readonly"/>
                                    </div>
                                </div>

                                <div class='form-actions' style='margin-bottom:0'>
                                    <a class="btn btn-success" name="button" style="margin-bottom:5px"  href="/AttendenceSystem/PiJiaController?action=deal&result=agree&id=<%=jiaTiao.getId() %>&StuNo=<%=jiaTiao.getStuNo() %>">同意</a>
                                    <a class="btn btn-danger" name="button" style="margin-bottom:5px" href='/AttendenceSystem/PiJiaController?action=deal&result=disagree&id=<%=jiaTiao.getId() %>&StuNo=<%=jiaTiao.getStuNo() %>'>拒绝</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
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
    <!-- Bootstrap popper Core JavaScript -->
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
    <!-- ============================================================== -->
    <!-- This page plugins -->
    <!-- ============================================================== -->
    <script src="/AttendenceSystem/assets/plugins/chartist-js/dist/chartist.min.js"></script>
    <script src="/AttendenceSystem/assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
    <!--c3 JavaScript -->
    <script src="/AttendenceSystem/assets/plugins/d3/d3.min.js"></script>
    <script src="/AttendenceSystem/assets/plugins/c3-master/c3.min.js"></script>
    <!-- Chart JS -->
    <script src="/AttendenceSystem/js/dashboard.js"></script>
    
    <!-- flatty scripts -->
</body>

</html>