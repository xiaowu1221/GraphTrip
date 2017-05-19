package com.gp.wu.graphtrip.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.Rbmob.bean.User;
import com.gp.wu.graphtrip.base.BaseActivity;

import butterknife.BindView;
import cn.bmob.v3.BmobUser;

/**
 * Created by wu on 2017/3/28.
 */

public class SettingActivity extends BaseActivity{
    @BindView(R.id.tv_user_nickname)
    TextView tv_user_nickname;
    @BindView(R.id.iv_user_avatar)
    ImageView iv_user_avatar;
    @BindView(R.id.tv_user_phone)
    TextView tv_user_phone;
    @Override
    public int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        User user = BmobUser.getCurrentUser(User.class);
        tv_user_nickname.setText(user.getNickname());
        tv_user_phone.setText(user.getMobilePhoneNumber());
    }

    @Override
    public void getExtraData() {

    }
}
