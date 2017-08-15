<%--
  Created by IntelliJ IDEA.
  User: niu
  Date: 2017/8/9
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传下载</title>
    <link rel="stylesheet" type="text/css" href="./resources/css/common.css"/>
    <script type="text/javascript" src="resources/js/lib/jquery-2.1.0.js"></script>

    <script type="text/javascript">

        /**
         * 利用jQuery
         */
        $(function () {
            $(".thumbs a").click(function () {
               var largePath = $(this).attr("href");
               var largeAlt = $(this).attr("title");
               $("#largeImg").attr({
                   src: largePath,
                   alt: largeAlt
               });
               return false;//阻止点击链接后跳转的默认事件
            });

            //更新新路径下的预览的图片（路径的格式存在问题）
            $("#myfile").change(function(){
                $("#previewImg").attr("src",$("#myfile").val());
            });

            var large = $("#large");
            large.hide();

            $("#previewImg").mousemove(function (e) {
                large.css({
                    top: e.pageY,
                    left: e.pageX
                }).html('<img src = "' + this.src + '" />').show();
            }).mouseout(function(){
                large.hide();
            });

        });
    </script>
</head>
<body>
    <%--<form action="">--%>
        <%--选则图片-<input type="file" id="myfile" name="myfile" onchange="showPreview(this)"/>--%>
        <%--<p id="previewImg">所选图片</p>--%>
    <%--</form>--%>

    <img id="previewImg" src="./resources/images/preview.jpg" width="80px" height="80px">
    <form action="">
        <input type="file" id="myfile" name="myfile" />
    </form>
    <div id="large"></div>
    <hr>
    <h2>图片预览</h2>
    <p><img id="largeImg" src="./resources/images/img6-lg.jpg" alt="LargeImg"></p>
    <p class="thumbs" >
        <a href="./resources/images/img6-lg.jpg" title="11"><img src="./resources/images/img6-thumb.jpg" alt="11"></a>
        <a href="./resources/images/img2-lg.jpg" title="12"><img src="./resources/images/img2-thumb.jpg" alt="12"></a>
        <a href="./resources/images/img3-lg.jpg" title="13"><img src="./resources/images/img3-thumb.jpg" alt="13"></a>
    </p>
</body>
</html>
