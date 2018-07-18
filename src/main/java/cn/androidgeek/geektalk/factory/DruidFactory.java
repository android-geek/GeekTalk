package cn.androidgeek.geektalk.factory;


import cn.androidgeek.geektalk.Environment;
import com.alibaba.druid.pool.DruidDataSource;
import me.xuxiaoxiao.xtools.server.xmodel.XModelFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class DruidFactory extends XModelFactory {
    public static final String DB_URL_DEV = "jdbc:mariadb://xuxiaoxiao.me:3306/geektalk_test";
    public static final String DB_USR_DEV = "root";
    public static final String DB_PWD_DEV = "920910";

    public static final String DB_URL_PROD = "jdbc:mariadb://xuxiaoxiao.me:3306/geektalk_prod";
    public static final String DB_USR_PROD = "root";
    public static final String DB_PWD_PROD = "920910";

    private static final DruidDataSource DATA_SOURCE = new DruidDataSource();

    static {
        if (Objects.equals(Environment.ENV, Environment.ENV_PROD)) {
            DATA_SOURCE.setUrl(DB_URL_PROD);
            DATA_SOURCE.setUsername(DB_USR_PROD);
            DATA_SOURCE.setPassword(DB_PWD_PROD);
        } else {
            DATA_SOURCE.setUrl(DB_URL_DEV);
            DATA_SOURCE.setUsername(DB_USR_DEV);
            DATA_SOURCE.setPassword(DB_PWD_DEV);
        }
    }

    @Override
    public Connection connect() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
}