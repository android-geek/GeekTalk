package cn.androidgeek.geektalk.api;

import cn.androidgeek.geektalk.UserTable;
import cn.androidgeek.geektalk.entity.Notice;
import cn.androidgeek.geektalk.entity.NoticeQueue;
import cn.androidgeek.geektalk.utils.GControl;
import me.xuxiaoxiao.xtools.server.control.XParam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet(name = "发送消息接口", description = "用户发送消息接口", urlPatterns = "/api/push_notice")
public class PushNotice extends GControl<String> {

    @XParam(name = "用户昵称", intro = "用户的昵称，用昵称来区分不同的用户")
    public String nick;

    @XParam(name = "会话id", intro = "首次pullNotice时由服务器返回，用于保证是在线的小伙伴发送的")
    public String session;

    @XParam(name = "消息", intro = "客户端发送到服务器的消息，无格式字符串，将会直接发送给其他人")
    public String notice;

    @Override
    protected XControlResult<String> process(Connection connection) throws Exception {
        synchronized (UserTable.class) {
            System.out.println(Thread.currentThread().getName());
            NoticeQueue noticeQueue = UserTable.users.get(nick);
            if (noticeQueue == null || !noticeQueue.session.equals(session)) {
                return XControlResult.failure(HttpServletResponse.SC_BAD_REQUEST, "Session校验出错");
            } else {
                for (String nick : UserTable.users.keySet()) {
                    if (!this.nick.equals(nick)) {
                        try {
                            UserTable.users.get(nick).add(new Notice(nick, notice));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return XControlResult.success("success");
            }
        }
    }
}
