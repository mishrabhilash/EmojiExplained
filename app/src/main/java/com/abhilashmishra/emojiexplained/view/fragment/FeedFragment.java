package com.abhilashmishra.emojiexplained.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhilashmishra.emojiexplained.R;
import com.abhilashmishra.emojiexplained.model.Emoji;
import com.abhilashmishra.emojiexplained.presenter.EmojiDB;
import com.abhilashmishra.emojiexplained.view.adapter.EmojiRowAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import utils.LinearLayoutManagerWithSmoothScroller;

public class FeedFragment extends Fragment {
    RecyclerView emojiRecyclerView;

    Activity parentActivity;
    private ArrayList<Emoji> emojis;
    private EmojiRowAdapter emojiRowAdapter;
    private LinearLayoutManagerWithSmoothScroller layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        //ButterKnife.bind(this, view);
        initVars();
        initUi(view);
        return view;
    }

    private void initVars() {
        emojis = new ArrayList<>();
        emojis = EmojiDB.getInstance(parentActivity).getAllEmojis();
        emojiRowAdapter = new EmojiRowAdapter(parentActivity,emojis);
        layoutManager = new LinearLayoutManagerWithSmoothScroller(parentActivity);
    }

    private void initUi(View view) {
        emojiRecyclerView = (RecyclerView)view.findViewById(R.id.emoji_recycler_view);
        emojiRecyclerView.setAdapter(emojiRowAdapter);
        emojiRecyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parentActivity =(Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void scrollTo(int x){
       emojiRecyclerView.smoothScrollToPosition(x);
    }

}
