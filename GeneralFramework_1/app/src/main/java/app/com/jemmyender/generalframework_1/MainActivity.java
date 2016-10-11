package app.com.jemmyender.generalframework_1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.com.jemmyender.generalframework_1.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mToolbar;
    private ViewPager viewPager;
    NavigationView navigationView = null;

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.tab1) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.tab2) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.tab3){
            viewPager.setCurrentItem(2);
        } else if (id == R.id.tab4) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.tab5){
            viewPager.setCurrentItem(4);
        } else if (id == R.id.tab6){
            viewPager.setCurrentItem(5);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPagerAndTabs();
        initDrawer();
    }

    private void initDrawer(){
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programmatically
        View headerView = navigationView.getChildAt(0);
        TextView emailText = (TextView) headerView.findViewById(R.id.email);
        emailText.setText("taojuejue@gmail.com");

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initViewPagerAndTabs(){

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        //没有下面这句的话，mToolBar也没法被使用
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        myPagerAdapter.addFragment(MainFragment.createInstance(20),"Tab 1");
        myPagerAdapter.addFragment(MainFragment.createInstance(5), "Tab 2");
        myPagerAdapter.addFragment(MainFragment.createInstance(6), "Tab 3");
        myPagerAdapter.addFragment(MainFragment.createInstance(8), "Tab 4");
        myPagerAdapter.addFragment(MainFragment.createInstance(9), "Tab 5");
        myPagerAdapter.addFragment(MainFragment.createInstance(21), "Tab 6");

        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    static class MyPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        public void addFragment(Fragment frag, String title){
            fragmentList.add(frag);
            fragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position){
            return fragmentList.get(position);
        }

        @Override
        public int getCount(){
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return fragmentTitleList.get(position);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
