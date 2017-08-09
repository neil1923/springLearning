<%--
  Created by IntelliJ IDEA.
  User: niu
  Date: 2017/8/9
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <div align="center">
        <h3>上传附件</h3>
        <form method="post" action="/springLearning2/uploadFile/doUpload" enctype="multipart/form-data">
            文件1: <input type="file" name="myfiles"/><br/>
            文件2: <input type="file" name="myfiles"/><br/>
            文件3: <input type="file" name="myfiles"/><br/>
            <input type="submit" value="上传">
        </form>
    </div>
</body>
</html>
