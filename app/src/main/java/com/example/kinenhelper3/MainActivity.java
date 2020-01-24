package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        setTitle(R.string.title_progress_fragment);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setTitle(R.string.title_progress_fragment);
                        break;
                    case 1:
                        setTitle(R.string.title_graph_fragment);
                        break;
                    case 2:
                        setTitle(R.string.title_counter_fragment);
                        break;
                }
            }
        });

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<InitialData> realmQuery = realm.where(InitialData.class);
        RealmResults<InitialData> realmResults = realmQuery.findAll();

//        int bbb = realmResults.get(0).getSmokingNum();
//        TextView textView = findViewById(R.id.aaa);
//        textView.setText(bbb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                return true;
            case R.id.item2:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    private int getInitialDate() {
//        InitialData initialData = new InitialData();
//
//        initialData.getSmokingNum();
//    }
}
