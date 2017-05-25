package com.gp.wu.graphtrip.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.Rbmob.bean.User;
import com.gp.wu.graphtrip.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by wu on 2017/3/26.
 * 登录注册页面
 */

public class LoginActivity extends BaseActivity{
    /**
     * login页面控件
     */
    @BindView(R.id.ll_login)
    LinearLayout ll_login;
    @BindView(R.id.iv_login_avatar)
    ImageView iv_login_avatar;
    @BindView(R.id.et_login_phone)
    EditText et_login_phone;
    @BindView(R.id.et_login_psw)
    EditText et_login_psw;
    @BindView(R.id.btn_login_login)
    Button btn_login_login;
    @BindView(R.id.tv_login_to_register)
    TextView tv_login_to_register;

    /**
     * register页面控件
     */
    @BindView(R.id.ll_register)
    LinearLayout ll_register;
    @BindView(R.id.iv_register_avatar)
    ImageView iv_register_avatar;
    @BindView(R.id.et_register_nickname)
    EditText et_register_nickname;
    @BindView(R.id.et_register_phone)
    EditText et_register_phone;
    @BindView(R.id.et_register_psw)
    EditText et_register_psw;
    @BindView(R.id.et_register_confirm_psw)
    EditText et_register_confirm_psw;
    @BindView(R.id.btn_register_register)
    Button btn_register_register;
    @BindView(R.id.tv_register_to_login)
    TextView tv_register_to_login;


    String username;
    String psw;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initWidget() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public void getExtraData() {

    }

    @OnClick(R.id.btn_login_login)
    public void login(){
        username = et_login_phone.getText().toString();
        psw = et_login_psw.getText().toString();
        final ProgressDialog dialog = ProgressDialog.show(this, "", "登陆中");

        BmobUser.loginByAccount(username, psw, new LogInListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if(user != null){
                            dialog.dismiss();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Log.i("login_register", e.getMessage());
                            dialog.dismiss();
                        }
                    }
                }
        );
    }
    @OnClick(R.id.btn_register_register)

    public void register(){
        final ProgressDialog dialog = ProgressDialog.show(this, "", "请稍后...");
        User user = new User();
        username = et_register_phone.getText().toString();
        psw = et_register_psw.getText().toString();
        user.setUsername(et_register_phone.getText().toString());
        user.setPassword(et_register_psw.getText().toString());
        user.setNickname(et_register_nickname.getText().toString());
        user.setMobilePhoneNumber(et_register_phone.getText().toString());
        user.signUp(new SaveListener<User>() {

            @Override
            public void done(User user, BmobException e) {
                dialog.dismiss();
                if(e == null){
                    Log.i("login_register", user.toString());
                }else{
                    Log.i("login_register", e.getMessage());
                }
            }
        });
    }
    @OnClick(R.id.tv_login_to_register)
    public void login2Register(){
        ll_login.setVisibility(View.GONE);
        ll_register.startLayoutAnimation();
        ll_register.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.tv_register_to_login)
    public void register2Login(){
        ll_login.startLayoutAnimation();
        ll_login.setVisibility(View.VISIBLE);
        ll_register.setVisibility(View.GONE);
    }
}
