package com.soft2176.bookonline.service;

import com.soft2176.bookonline.entity.User;
import com.soft2176.bookonline.utils.Md5Util;

import java.util.List;

/**
 * @program: java-web-dev
 * @description:
 * @author: ycshang
 * @create: 2022-02-24 17:34
 **/
public class UserService {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;
            }
        }
        return null;
    }
}