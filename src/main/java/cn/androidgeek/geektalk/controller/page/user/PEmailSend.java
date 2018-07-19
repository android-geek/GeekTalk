package cn.androidgeek.geektalk.controller.page.user;

import me.xuxiaoxiao.xtools.server.xcontroller.XController;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.GetAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xanswer.XAnswer;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/user/email-send.page")
public class PEmailSend extends XController {

    @GetAction
    public static class EmailSendPage extends XAction<Void> {

        @Override
        public XAnswer<Void> process() throws Exception {
            return new XAnswer<>("/page/user/email-send.jsp", null);
        }
    }
}
