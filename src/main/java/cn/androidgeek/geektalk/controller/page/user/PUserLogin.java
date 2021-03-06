package cn.androidgeek.geektalk.controller.page.user;

import me.xuxiaoxiao.xtools.server.xcontroller.XController;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.GetAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xanswer.XAnswer;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/user/login.page")
public class PUserLogin extends XController {

    @GetAction
    public static class UserLoginPage extends XAction<Boolean> {

        @Override
        public XAnswer<Boolean> process() throws Exception {
            return new XAnswer<>("/page/user/login.jsp", null);
        }
    }
}
