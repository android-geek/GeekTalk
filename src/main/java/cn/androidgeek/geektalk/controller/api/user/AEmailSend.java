package cn.androidgeek.geektalk.controller.api.user;

import cn.androidgeek.geektalk.model.MEmailVerify;
import me.xuxiaoxiao.xtools.common.ioc.factory.Manage;
import me.xuxiaoxiao.xtools.server.xcontroller.XController;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.PostAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xanswer.XAnswer;
import me.xuxiaoxiao.xtools.server.xcontroller.xparam.XParam;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/user/email-send.api")
public class AEmailSend extends XController {

    @PostAction
    public static class EmailSendApi extends XAction<Boolean> {

        @XParam(display = "邮箱地址", fromContent = "email")
        public String email;

        @XParam(display = "邮件目的", fromContent = "purpose")
        public String purpose;

        @Manage
        public MEmailVerify mEmailVerify;

        @Override
        public XAnswer<Boolean> process() throws Exception {

            return null;
        }
    }
}
