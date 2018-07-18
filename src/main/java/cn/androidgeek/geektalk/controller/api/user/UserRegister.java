package cn.androidgeek.geektalk.controller.api.user;

import cn.androidgeek.geektalk.model.MUser;
import me.xuxiaoxiao.xtools.server.xcontroller.XController;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.PostAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xaction.XAction;
import me.xuxiaoxiao.xtools.server.xcontroller.xanswer.XAnswer;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/user/register.api", name = "用户注册接口", description = "用户使用邮箱注册账号")
public class UserRegister extends XController {

    @PostAction
    public static class UserRegisterAction extends XAction<MUser.EUser> {
        @Override
        public XAnswer<MUser.EUser> process() throws Exception {
            return null;
        }
    }
}
