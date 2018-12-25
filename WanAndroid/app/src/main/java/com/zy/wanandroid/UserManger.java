package com.zy.wanandroid;

import android.content.Context;

public class UserManger {


    public static Context context;

    public UserManger(Context context) {
        UserManger.context = context;
    }

    public static UserManger getInstance() {
        return UserHolder.USERMANAGER;
    }

    public static class UserHolder {
        static final UserManger USERMANAGER = new UserManger(UserManger.context);
    }


}
