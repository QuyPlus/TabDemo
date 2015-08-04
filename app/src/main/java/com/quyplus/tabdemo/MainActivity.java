package com.quyplus.tabdemo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import com.quyplus.tabdemo.adapter.TabPagerAdapter;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
        private ViewPager mViewPager;
        private TabPagerAdapter mAdapter;
        private ActionBar mActionBar;

        // Tabs title
        private String[] tabs = {"Games", "Movies", "Apps"};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Initialization
                mViewPager = (ViewPager)findViewById(R.id.viewpager);
                mActionBar = getActionBar();
                mAdapter   = new TabPagerAdapter(getSupportFragmentManager());

                mViewPager.setAdapter(mAdapter);
                mActionBar.setHomeButtonEnabled(false);
                mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

                // Adding Tabs
                for (String tab: tabs){
                        mActionBar.addTab(mActionBar.newTab().setText(tab).setTabListener(this));
                }

                /**
                 * On Swiping the viewpager make respective tab selected
                 * */

                mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int i, float v, int i2) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                                // On Changing the Page make respected tab selected
                                mActionBar.setSelectedNavigationItem(position);
                        }

                        @Override
                        public void onPageScrollStateChanged(int i) {

                        }
                });
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
                if (id == R.id.action_settings) {
                        return true;
                }
                return super.onOptionsItemSelected(item);
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // On tab selected show respected fragment view
                mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
}
