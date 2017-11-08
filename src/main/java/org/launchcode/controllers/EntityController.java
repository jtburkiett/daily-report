package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.data.ReportDao;
import org.launchcode.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by JosephT on 7/28/2017.
 */
public abstract class EntityController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected ReportDao reportDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session){

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }
}
