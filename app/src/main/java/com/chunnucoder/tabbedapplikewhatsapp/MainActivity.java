package com.chunnucoder.tabbedapplikewhatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout our_tab_bar_layout;
    ViewPager our_fragment_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        our_tab_bar_layout = findViewById(R.id.our_tab_bar_layout);
        our_fragment_layout = findViewById(R.id.our_fragment_layout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFregment(new FirstFragment(), "WhatsApp");
        adapter.AddFregment(new SecondFragment(), "FaceBook");
        adapter.AddFregment(new ThirdFragment(), "Twitter");

        our_fragment_layout.setAdapter(adapter);
        our_tab_bar_layout.setupWithViewPager(our_fragment_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        our_tab_bar_layout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
    //An adapter for ViewPager :
    class ViewPagerAdapter<Int> extends FragmentPagerAdapter {
        List<Fragment> TabFregment = new ArrayList<>();
        List<String> TabTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return TabFregment.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return TabTitle.get(position);
        }

        public void AddFregment(Fragment fragment, String title) {
            TabFregment.add(fragment);
            TabTitle.add(title);
        }

        @Override
        public int getCount() {
            return TabTitle.size();
        }
    }
}