package cn.androidgeek.geektalk.listener;

import cn.androidgeek.geektalk.UserTable;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class UserTableListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserTable.CLEAN_THREAD.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        UserTable.CLEAN_THREAD.interrupt();

    }
}
