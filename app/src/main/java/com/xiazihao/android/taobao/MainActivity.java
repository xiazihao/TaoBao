package com.xiazihao.android.taobao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xiazihao.android.taobao.view.CombineButton;

public class MainActivity extends AppCompatActivity {

    private CombineButton mHomeCombineButton;
    private CombineButton mAccountCombineButton;
    private CombineButton mTfAccountCombineButton;
    private CombineButton mCartCombineButton;
    private CombineButton mDiscoverCombineButton;

    private Fragment mHomePageFragment;
    private Fragment mAccountPageFragment;
    private Fragment mTfAccountPageFragment;
    private Fragment mDiscovePageFragment;
    private Fragment mCartPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomePageFragment = HomePageFragment.newInstance();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, mHomePageFragment).commit();
        mHomeCombineButton = (CombineButton) findViewById(R.id.navigate_home);
        mHomeCombineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mHomePageFragment == null) {
                    mHomePageFragment = HomePageFragment.newInstance();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container, mHomePageFragment).commit();
                clearSelected();
                mHomeCombineButton.setSelected(true);
            }
        });
        mAccountCombineButton = (CombineButton) findViewById(R.id.navigate_account);
        mAccountCombineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAccountPageFragment == null) {
                    mAccountPageFragment = AccountPageFragment.newInstance();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container, mAccountPageFragment).commit();
                clearSelected();
                mAccountCombineButton.setSelected(true);
            }
        });
        mTfAccountCombineButton = (CombineButton) findViewById(R.id.navigate_tfaccount);
        mTfAccountCombineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTfAccountPageFragment == null){
                    mTfAccountPageFragment = new Fragment();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container,mTfAccountPageFragment).commit();
                clearSelected();
                mTfAccountCombineButton.setSelected(true);
            }
        });
        mCartCombineButton = (CombineButton) findViewById(R.id.navigate_cart);
        mCartCombineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCartPageFragment == null){
                    mCartPageFragment = new Fragment();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container,mCartPageFragment).commit();
                clearSelected();
                mCartCombineButton.setSelected(true);
            }
        });
        mDiscoverCombineButton = (CombineButton) findViewById(R.id.navigate_discover);
        mDiscoverCombineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDiscovePageFragment == null){
                    mDiscovePageFragment = new Fragment();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container,mDiscovePageFragment).commit();
                clearSelected();
                mDiscoverCombineButton.setSelected(true);
            }
        });
    }

    private void clearSelected() {
        mHomeCombineButton.setSelected(false);
        mAccountCombineButton.setSelected(false);
        mTfAccountCombineButton.setSelected(false);
        mCartCombineButton.setSelected(false);
        mDiscoverCombineButton.setSelected(false);
    }
}
