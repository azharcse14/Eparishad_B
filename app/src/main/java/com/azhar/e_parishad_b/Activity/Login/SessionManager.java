package com.azhar.e_parishad_b.Activity.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.azhar.e_parishad_b.Activity.MainActivity;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String AT = "access_token";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String USER = "user";
    public static final String USERCODE = "usercode";



    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession( String access_token, String name, String role, String user, String usercode){

        editor.putBoolean(LOGIN, true);
        editor.putString(AT, access_token);
        editor.putString(NAME, name);
        editor.putString(ROLE, role);
        editor.putString(USER, user);
        editor.putString(USERCODE, usercode);
        editor.apply();

    }

    public boolean isLoggin(){
        System.out.println("is login");
        Log.d("LOGIN", "LOGIN");
        System.out.println(LOGIN);
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){

        if (isLoggin()){
            System.out.println(isLoggin());
            Intent i = new Intent(context, MainActivity.class);
            context.startActivity(i);
//            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){

        HashMap<String, String> user = new HashMap<>();
        user.put(AT, sharedPreferences.getString(AT, null));
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(ROLE, sharedPreferences.getString(ROLE, null));
        user.put(USER, sharedPreferences.getString(USER, null));
        user.put(USERCODE, sharedPreferences.getString(USERCODE, null));
//        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
//        user.put(PASSWORD, sharedPreferences.getString(PASSWORD, null));
        return user;
    }



}
