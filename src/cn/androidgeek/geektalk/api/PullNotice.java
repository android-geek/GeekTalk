package cn.androidgeek.geektalk.api;

import cn.androidgeek.geektalk.UserTable;
import cn.androidgeek.geektalk.entity.Notice;
import cn.androidgeek.geektalk.entity.NoticeQueue;
import cn.androidgeek.geektalk.utils.GControl;
import me.xuxiaoxiao.xtools.common.XDigestTools;
import me.xuxiaoxiao.xtools.server.control.XParam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet(name = "获取消息接口", description = "用户获取自己的消息，如果没有消息，会将请求保持45秒后返回空的数据", urlPatterns = "/api/pull_notice")
public class PullNotice extends GControl<PullNotice.PullResult> {

    @XParam(name = "用户昵称", intro = "用户的昵称，用昵称来区分不同的用户")
    public String nick;

    @XParam(name = "会话id", intro = "首次pull_notice时由服务器返回，用于保证不被后来的相同昵称的人挤下去", optional = true)
    public String session;

    @Override
    protected XControlResult<PullNotice.PullResult> process(Connection connection) throws Exception {
        NoticeQueue noticeQueue;
        synchronized (UserTable.class) {
            System.out.println(Thread.currentThread().getName());
            noticeQueue = UserTable.users.get(nick);
            if (noticeQueue == null) {
                this.session = XDigestTools.digest(XDigestTools.Algo.MD5, String.format("session-%s-%s", nick, String.valueOf(System.currentTimeMillis())));
                noticeQueue = new NoticeQueue(session);
                UserTable.users.put(nick, noticeQueue);
            } else if (!noticeQueue.session.equals(session)) {
                return XControlResult.failure(HttpServletResponse.SC_BAD_REQUEST, "用户昵称冲突，请重新定义");
            }
        }
        return XControlResult.success(new PullResult(session, noticeQueue.pull()));
    }

    public static class PullResult {
        public String session;
        public Notice notice;

        public PullResult(String session, Notice notice) {
            this.session = session;
            this.notice = notice;
        }
    }
}
