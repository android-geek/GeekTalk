package cn.androidgeek.geektalk.utils;

import me.xuxiaoxiao.xtools.server.control.XControl;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GControl<T> extends XControl<T> {

    @Override
    protected boolean debug() {
        return true;
    }

    @Override
    protected Connection connect() throws SQLException {
        return null;
    }
}
