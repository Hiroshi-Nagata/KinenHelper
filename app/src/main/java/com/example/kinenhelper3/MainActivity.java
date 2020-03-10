package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements CustomDialogInterface {

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private Toolbar toolbar;
    private String mTAGDialogTag = "dialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(getSupportFragmentManager(), mTAGDialogTag);
                customDialogFragment.setCustomDialogListener(this);
                break;
            case R.id.item2:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess(String value) {
        TextView textView = findViewById(R.id.text_target_days);
        textView.setText(value);
        //ここで、ProgressFragmentのインスタンス取得し、値を代入する
        //ProgressFragment内でCustomDialogFragmentのリスナーをセットする必要ないかも
    }
}
