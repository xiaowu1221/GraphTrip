package com.gp.wu.graphtrip.bmob;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.gp.wu.graphtrip.bmob.bean.Person;

import org.json.JSONArray;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by wu on 2017/3/26.
 */

public class BmobListActivity extends BaseActivity{

    @BindView(R.id.tv_show)
    TextView tv_show;

    @Override
    public int setLayout() {
        return R.layout.try_activity_bmob_list;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void getExtraData() {

    }

    public void startCreate(View view){
        Person p = new Person();
        p.setName("lucky");
        p.setAddress("北京海淀");
        p.setAge(25);
        p.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e == null){
                    tv_show.setText("添加数据成功，返回objectid为" + s);
                }else{
                    tv_show.setText("创建数据失败，" + e.getMessage());
                }
            }
        });
    }
    public void startUpdate(View view){
        final Person p = new Person();
        p.setAddress("北京朝阳");
        p.update("4691a53d17", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e == null){
                    tv_show.setText("更新成功" + p.getUpdatedAt());
                }else{
                    tv_show.setText("查询失败，" + e.getMessage());
                }
            }
        });
    }
    public void startDelete(View view){
        final Person p = new Person();
        p.setObjectId("4691a53d17");
        p.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e == null){
                    tv_show.setText("删除成功" + p.getUpdatedAt());
                }else{
                    tv_show.setText("查询失败，" + e.getMessage());
                }
            }
        });
    }
    public void startFind(View view){
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject("4691a53d17", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if(e == null){
                    tv_show.setText("查询成功" + person.getName() + ":" + person.getAddress());
                }else{
                    tv_show.setText("查询失败，" + e.getMessage());
                }
            }
        });
    }

    public void startFindByTerm(View view){
        BmobQuery query = new BmobQuery("Person");
        query.addWhereEqualTo("age", 25);
        query.setLimit(2);
        query.order("createdAt");
        //findObjectsByTable方法查询自定义表名的数据
        query.findObjectsByTable(new QueryListener<JSONArray>() {
            @Override
            public void done(JSONArray jsonArray, BmobException e) {
                if(e == null){
                    tv_show.setText("查询成功" + jsonArray.toString());
                }else{
                    tv_show.setText("失败" + e.getMessage());
                }
            }
        });
    }

}
