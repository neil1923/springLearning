<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*" errorPage="" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <title>'regist2.jsp'</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <%--<link rel="stylesheet" href="./css/bootstrap.css">--%>
    <%--<link href="css/signin.css" rel="stylesheet">--%>
    <%--<script type="text/javascript" src="./js/jquery-2.1.0.js"></script>--%>
    <%--<script type="text/javascript" src="./js/bootstrap.js"></script>--%>
    <style type="text/css">
        html,body {
            margin: 0; /* 最好将 body 元素的边距和填充设置为 0 以覆盖不同的浏览器默认值 */
            padding: 0;
            text-align: center; /* 在 IE 5* 浏览器中，这会将容器居中。文本随后将在 #container 选择器中设置为默认左对齐 */
        }
        input
        {
            background-color:black;
            color:white;
        }
    </style>
</head>

<body class="oneColElsCtrHdr" >
<script>
    function check(){
        var account = document.getElementsByName("account");
        if(account.value==""){
            document.getElementById("AccountSpan").innerHTML="Account should not be empty!";
            return;
        }

        var userName = document.getElementsByName("userName");
        if(userName.value==""){
            document.getElementById("userNameSpan").innerHTML="userName should not be empty!";
            return;
        }

        var password = document.getElementsByName("password");
        if(password.value==""){
            document.getElementById("passwordSpan").innerHTML="Password should not be empty!";
            return;
        }

        var rewritePassd = document.getElementsByName("rewritePassd");
        if(rewritePassd.value==""){
            document.getElementById("rewritePassdSpan").innerHTML="RewritePassd should not be empty!";
            return;
        }

        var email = document.getElementsByName("email");
        if(email.value==""){
            document.getElementById("emailSpan").innerHTML="Email should not be empty!";
            return;
        }

        registForm.submit();

    }
</script>

<div id="container">
    <div id="header">
        <h1 style=" margin:100px 50px; font-size:50px">欢迎注册</h1>
    </div>
    <!-- end #header -->

    <div id="mainContent" align="center">
        <form action="/springLearning2/domain/save" method="post" name="registForm" class="">
            <table width="351" height="300" border="0" cellpadding="5" cellspacing="3" style="padding-bottom:50px;">

                <tr>
                    <th scope="row" style="font-size: 20px">UserId</th>
                    <td><input name="user_id" type="text" required autofocus style="width: 200px; "/></td>
                </tr>
                <tr>
                    <th scope="row" style="font-size:20px">UserName</th>
                    <td><input name="user_name" type="text" requried autofocus style="width:200px" /></td>
                </tr>
                <tr>
                    <th width="129" scope="row" style="font-size:20px">Account</th>
                    <td width="193"><input name="account" type="text" onblur="checkAccount()" requried autofocus style="width:200px" /></td>
                </tr>
                <tr>
                    <th scope="row" style="font-size:20px">Password</th>
                    <td><input name="password" type="text" requried autofocus style="width:200px" /></td>
                </tr>
                <tr>
                    <th scope="row" style="font-size: 20px">Email</th>
                    <td><input name="email" type="text" required autofocus style="width: 200px;"/></td>
                </tr>
            </table>
            <br><br>
            <button style="background-color: #F90; size:10px; text-align:center;"
                    type="button" onclick="check()">注册
            </button>
        </form>
        <!-- end #mainContent --></div>
    <!-- end #container --></div>
</body>
</html>
