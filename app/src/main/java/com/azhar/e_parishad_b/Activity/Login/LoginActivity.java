package com.azhar.e_parishad_b.Activity.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.azhar.e_parishad_b.Activity.MainActivity;
import com.azhar.e_parishad_b.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    SessionManager sessionManager;

    EditText etEmail, etPassword;
    Button btnLogin;

    String email, password;
    ProgressBar loading;

    final String URL_LOGIN = "http://103.147.182.110:5030/authentication";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        etEmail = findViewById(R.id.editText_login_username);
        etPassword = findViewById(R.id.editText_login_password);
        loading = findViewById(R.id.progress_circularId);
        btnLogin = findViewById(R.id.loginBtn);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = etEmail.getText().toString().trim();
                password = etPassword.getText().toString().trim();

//                if (!email.isEmpty() && !password.isEmpty()){
//                    Login(email, password);
//                }else {
//                    Toast.makeText(getApplicationContext(),"Please Insert the blank filed", Toast.LENGTH_SHORT).show();
//                }

                login();

            }
        });

    }


    public void login(){

        if (!email.isEmpty() && !password.isEmpty()){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response);

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String access_token = jsonObject.getString("access_token");
                        String name = jsonObject.getString("name");
                        String role = jsonObject.getString("role");
                        String user = jsonObject.getString("user");
                        String usercode = jsonObject.getString("usercode");

                        sessionManager.createSession(access_token, name, role, user, usercode);

                        System.out.println(access_token);
                        System.out.println(name);
                        System.out.println(role);
                        System.out.println(user);
                        System.out.println(usercode);

                        if (response != null) {
                            System.out.println("if S");
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else if (response.equals("failure")) {
                            Toast.makeText(getApplicationContext(), "Invalid Email or Password", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_LONG).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("username", email);
                    data.put("password",password);
                    return data;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else {
            Toast.makeText(getApplicationContext(),"Fields can not be empty!", Toast.LENGTH_LONG).show();
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}