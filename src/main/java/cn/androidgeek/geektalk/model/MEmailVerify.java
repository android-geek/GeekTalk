package cn.androidgeek.geektalk.model;

import me.xuxiaoxiao.xtools.server.xcontroller.xresult.XResult;
import me.xuxiaoxiao.xtools.server.xmodel.XModel;

import java.sql.Connection;

public class MEmailVerify extends XModel<MEmailVerify.EEmailVerify> {

    public MEmailVerify(Connection conn) {
        super(EEmailVerify.class, conn);
    }

    public static class EEmailVerify extends XModel.XEntity {
        @XResult(display = "验证码", detail = "这个验证码比较长，而且需要保证数据库中唯一")
        public String verify;
        @XResult(display = "邮箱地址")
        public String email;
        @XResult(display = "邮件目的")
        public String purpose;
        @XResult(display = "验证成功重定向地址")
        public String redirect;

        public EEmailVerify(Long id) {
            super(id);
        }
    }
}
