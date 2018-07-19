<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/common.jsp"/>
    <title>验证邮箱</title>
</head>
<body>
<div class="user">
    <div class="verify">
        <div class="row">
            <div class="col-sm-10 offset-sm-1 col-8 offset-2 col-lg-6 offset-lg-3">
                <div class="row">
                    <div class="col-12">
                        <div class="notice">验证邮箱</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="detail">
                            我们会向你的邮箱发送一封验证邮件，请点击邮件中的链接完成注册流程
                        </div>
                    </div>
                </div>
                <form class="form">
                    <div class="row">
                        <div class="col-2">
                            <div class="form-txt-tip">邮箱：</div>
                        </div>
                        <div class="col-10">
                            <input class="form-txt full-width" type="email" name="email" placeholder="请输入有效的邮箱地址"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button class="form-btn full-width">发送验证邮件</button>
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
