package app.com.jemmyender.generalframework_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import app.com.jemmyender.generalframework_1.Fragment.ContentFragment;

public class ContentActivity extends AppCompatActivity {

    private ViewPager myViewPager;
    private int position;
    private ArrayList<String> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        datalist = intent.getStringArrayListExtra("DATA_LIST");
        position = intent.getIntExtra("PAGE_NUMBER",0);
        initView();
    }

    private void initView(){
        Toolbar mToolbar = (Toolbar)findViewById(R.id.Content_toolbar);
        //没有下面这句的话，mToolBar也没法被使用
        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        myViewPager = (ViewPager)findViewById(R.id.Content_ViewPager);
        MyContentPagerAdapter myPagerAdapter = new MyContentPagerAdapter(getSupportFragmentManager());

        myViewPager.setAdapter(myPagerAdapter);
        myViewPager.setCurrentItem(position);
    }

    private class MyContentPagerAdapter extends FragmentStatePagerAdapter {
        @Override
        public Fragment getItem(int position){

            return ContentFragment.create(datalist.get(position),position);
        }

        public MyContentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount(){
            return datalist.size();
        }
    }

}
