package com.github.liyibo1110.advanced.generics.genericclass;

/**
 * @author liyibo
 * @date 2025-10-17 10:50
 */
public class UserDao extends BaseDao<User> {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        // BaseDao should be abstract
        BaseDao<String> strDao = new BaseDao<>();
    }
}
