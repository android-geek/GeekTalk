package cn.androidgeek.geektalk.model;

import me.xuxiaoxiao.xtools.server.xmodel.XModel;

import java.sql.Connection;

public class MUser extends XModel<MUser.EUser> {

    public MUser(Connection conn) {
        super(EUser.class, conn);
    }

    public static class EUser extends XModel.XEntity {
        public String email;
        public String passwd;
        public String nick;
        public String avatar;
        public String birthday;

        public EUser(Long id) {
            super(id);
        }
    }
}
