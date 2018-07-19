<%@ page import="cn.androidgeek.geektalk.controller.page.user.PEmailSend" %>
<%@ page import="me.xuxiaoxiao.xtools.server.XServerTools" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/common.jsp"/>
    <title>极聊-用户登录</title>
</head>
<body>
<div class="user">
    <div class="login">
        <div class="row">
            <div class="col-12">
                <div class="slogan">极聊</div>
            </div>
            <div class="col-sm-10 offset-sm-1 col-8 offset-2 col-lg-6 offset-lg-3">
                <form class="form" onsubmit="return false;">
                    <div class="row">
                        <div class="col-2">
                            <div class="form-txt-tip">账号：</div>
                        </div>
                        <div class="col-10">
                            <input class="form-txt full-width" id="user_email" type="email" placeholder="请输入邮箱"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-2">
                            <div class="form-txt-tip">密码：</div>
                        </div>
                        <div class="col-10">
                            <input class="form-txt full-width" id="user_passwd" type="password" placeholder="请输入密码"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button class="form-btn full-width">登录</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <a href="<%=XServerTools.ctrlPath(request,PEmailSend.class)%>">没有账号？立刻注册！</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
</script>
</body>
</html>
