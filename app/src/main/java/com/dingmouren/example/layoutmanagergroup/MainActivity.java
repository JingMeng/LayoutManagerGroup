package com.dingmouren.example.layoutmanagergroup;

import android.app.FragmentTransaction;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.dingmouren.example.layoutmanagergroup.activity.SkidRightActivity_1;
import com.dingmouren.example.layoutmanagergroup.fragment.EchelonFragment;
import com.dingmouren.example.layoutmanagergroup.fragment.PickerFragment;
import com.dingmouren.example.layoutmanagergroup.fragment.SlideFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by 閽夋煇浜? * github: https://github.com/DingMouRen
 * email: naildingmouren@gmail.com
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mTvTitle;
    private Toolbar mToolbar;
    private FragmentManager mFragmentManager;
    private List<Fragment> mFragments = new ArrayList<>();//瀛樺偍鎵€鏈夌殑Fragment瀵硅薄
    private List<String> mManagerNames = new ArrayList<>();//瀛樺偍涓嶧ragment瀵瑰簲鐨凩ayoutManager鐨勫悕绉?
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        mTvTitle = findViewById(R.id.tv_title);
        mFragmentManager = getSupportFragmentManager();

        initFragments();

    }

    private void initFragments() {
        EchelonFragment echelonFragment = new EchelonFragment();//姊舰甯冨眬
        mFragments.add(echelonFragment);
        mManagerNames.add("EchelonLayoutManager");

        PickerFragment pickerFragment = new PickerFragment();//閫夋嫨鍣ㄥ竷灞€
        mFragments.add(pickerFragment);
        mManagerNames.add("PickerLayoutManager");

        SlideFragment slideFragment = new SlideFragment();//婊戝姩甯冨眬
        mFragments.add(slideFragment);
        mManagerNames.add("SlideLayoutManager");

        mFragmentManager.beginTransaction()
                .add(R.id.container_layout, mFragments.get(0))
                .add(R.id.container_layout,mFragments.get(1))
                .add(R.id.container_layout,mFragments.get(2))
                .hide(mFragments.get(2))
                .hide(mFragments.get(1))
                .show(mFragments.get(0))
                .commit();
        mCurrentFragment = mFragments.get(0);
        mTvTitle.setText(mManagerNames.get(0));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_0:
                switchFragment(0);
                break;
            case R.id.item_1:
                switchFragment(1);
                break;
            case R.id.item_2:
                switchFragment(2);
                break;
            case R.id.item_3:
                startActivity(new Intent(MainActivity.this, SkidRightActivity_1.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void switchFragment(int position) {
        mFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .hide(mCurrentFragment)
                .show(mFragments.get(position))
                .commit();
        mCurrentFragment = mFragments.get(position);
        mTvTitle.setText(mManagerNames.get(position));
    }
}

