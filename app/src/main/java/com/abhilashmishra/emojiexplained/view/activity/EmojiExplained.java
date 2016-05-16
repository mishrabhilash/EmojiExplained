package com.abhilashmishra.emojiexplained.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.abhilashmishra.emojiexplained.R;
import com.abhilashmishra.emojiexplained.view.adapter.EmojiRowAdapter;
import com.abhilashmishra.emojiexplained.view.fragment.AskFragment;
import com.abhilashmishra.emojiexplained.view.fragment.FeedFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.ButterKnife;

public class EmojiExplained extends AppCompatActivity {

    private EmojiRowAdapter emojiRowAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //*********Views from XML************

//    @Bind(R.id.nested_scroll_view)
//    NestedScrollView nestedScrollView;

    //*********Variables that need saving on Activity Crash*********

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji_explained);
        ButterKnife.bind(this);
        loadBottomBar(savedInstanceState);
        initVars(savedInstanceState);
        initUi();
    }

    private void initVars(Bundle savedInstanceState) {
        if (savedInstanceState != null) {

        } else {
            loadFragment(new FeedFragment());
        }
    }

    private void initUi() {
        //nestedScrollView.setOnScrollChangeListener(scrollListener);
        //nestedScrollView.setNestedScrollingEnabled(false);
    }

    private void loadBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.parent_home_screen),
                findViewById(R.id.placeholder), savedInstanceState);
        mBottomBar.useFixedMode();
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottomBarItemAsk:
                        loadFragment(new AskFragment());
                        break;
                    case R.id.bottomBarItemFeed:
                        loadFragment(new FeedFragment());
                        break;
                    case R.id.bottomBarItemSettings:
                        break;
                    case R.id.bottomBarItemNotification:
                        break;

                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

                // The user reselected item, scroll your content to top.
                switch (menuItemId) {
                    case R.id.bottomBarItemAsk:
                        break;
                    case R.id.bottomBarItemFeed:
                        FeedFragment feedFragment = (FeedFragment) getSupportFragmentManager().findFragmentById(R.id.placeholder);
                        feedFragment.scrollTo(0);
                        break;
                    case R.id.bottomBarItemSettings:
                        break;
                    case R.id.bottomBarItemNotification:
                        break;

                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    public void loadFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.placeholder, fragment);
        ft.commit();
    }

    NestedScrollView.OnScrollChangeListener scrollListener = new NestedScrollView.OnScrollChangeListener() {
        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//            v.dispatchNestedPreScroll(scrollX-oldScrollX,scrollY-oldScrollY,null,null);
//            v.dispatchNestedScroll(0,0,scrollX-oldScrollX,scrollY-oldScrollY,null);
            v.computeScroll();
        }
    };
}
