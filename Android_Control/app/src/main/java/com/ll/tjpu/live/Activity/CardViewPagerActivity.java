package com.ll.tjpu.live.Activity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ll.tjpu.live.adapter.MyPagerAdapter;
import  com.ll.tjpu.mylibrary.AlphaAndScalePageTransformer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.ll.tjpu.live.R;

import butterknife.OnTouch;

public class CardViewPagerActivity extends AppCompatActivity implements View.OnTouchListener {

    private final int[] mData = {R.drawable.new1,R.drawable.new2, R.drawable.new3, R.drawable.new4, R.drawable.new5,R.drawable.new6,R.drawable.new7};
    private ViewPager mViewPager;
    private GestureDetector mDetector;
    private int mCurrentPos = 0;
    private URL url;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_pager);

        Toolbar myToolbar =findViewById(R.id.toolbar);
        myToolbar.setTitle("项目展示");
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mViewPager = ((ViewPager) findViewById(R.id.cardViewPager));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MyPagerAdapter(getViewPagerData(),this));
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            //只实现自己想要的回调
            @Override
            public void onPageSelected(int position) {
                String path="http://192.168.43.89:8080/FuChuang/turnPage";
                Log.e("SimplePageChange-Select", "position:" + position);
                mCurrentPos = position;
                new getTask().execute(position,path);
            }
        });

    }



    private List<ViewPagerItemBean> getViewPagerData() {
        List<ViewPagerItemBean> pagerItemBeanList = new ArrayList<>(mData.length);
        for (int i = 0; i < mData.length; i++) {
            if(i==0){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "\n实时动态展示全国各大主要城市的人力资源招聘的总体情况。\n\n" +
                        "行业招聘热度地图 \n" +
                        "全国城市招聘需求图 \n" +
                        "全行业工资状况图\n\n"));
            }
            if(i==1){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "热门行业情况页面实时动态展示热门行业的总体情况。\n\n" +
                        "行业招聘热度地图 \n" +
                        "行业招聘需求比例图 \n" +
                        "热门行业工资状况图\n\n"));
            }
            if(i==2){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "热门城市情况页面实时动态展示人力资源招聘的总体情况 \n\n" +
                        "北京市实时热门行业需求\n" +
                        "北京实时招聘资讯\n" +
                        "北京实时热门行业工资状况图\n" +
                        "北京实时人员学历招聘需求\n\n"));
            }
            if(i==3){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "实时动态展示体现重要字段之间相关性图表 \n\n" +
                        "国企、民企工资区间人数状况图\n" +
                        "工资与学历状况图\n" +
                        "工作经验需求状况图\n" +
                        "工作经验与工资状况图\n\n"));
            }
            if(i==4){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "从需求、待遇、学历和工资四个维度对相关信息进行分析 \n\n" +
                        "热门行业招聘需求\n" +
                        "热门行业待遇等级\n" +
                        "各学历人数占比\n" +
                        "学历与工资关系图\n\n"));
            }
            if(i==5){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "热门城市情况分析页面通过分析热门城市的相关数据 \n\n" +
                        "热门行业招聘需求\n" +
                        "热门城市工资情况图\n" +
                        "热门城市招聘数据\n" +
                        "部分城市工作满意度\n\n"));
            }
            if(i==6){
                pagerItemBeanList.add(new ViewPagerItemBean(mData[i], "将系统数据库中的历史数据进行算法计算并通过不同的图表展示预测结果。\n\n" +
                        "热门城市就业推荐指数\n" +
                        "行业信息预测表\n" +
                        "企业各渠道招聘比例预测\n" +
                        "各学历层次工资预测\n\n"));
            }
        }
        mViewPager.setPageMargin(40);
        mViewPager.setPageTransformer(true,new AlphaAndScalePageTransformer());
        return pagerItemBeanList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cardviewpagermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mDetector.onTouchEvent(event);
        return true;

    }


    class getTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            //依次获取用户名，密码与路径
            int number = (int)params[0];
            String path = params[1].toString();

            try {
                //获取网络上get方式提交的整个路径
                URL url = new URL(path + "?number=" + number);
                //打开网络连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //设置提交方式
                conn.setRequestMethod("GET");
                //设置网络超时时间
                conn.setConnectTimeout(5000);
                //获取结果码
                int code = conn.getResponseCode();
                if (code == 200) {
                    //用io流与web后台进行数据交互
                    InputStream is = conn.getInputStream();
                    //字节流转字符流
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    //读出每一行的数据
                    String s = br.readLine();
                    //返回读出的每一行的数据
                    return s;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }
}
