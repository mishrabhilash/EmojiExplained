package com.abhilashmishra.emojiexplained.presenter;

import android.content.Context;

import com.abhilashmishra.emojiexplained.model.Emoji;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by mishrabhilash on 5/11/16.
 */
public class EmojiExplainedPresenter {
    private ArrayList<Emoji> emojis;
    private EmojiDB db;
    WeakReference<Context> contextWeakReference;
    private static EmojiExplainedPresenter instance;

    public static EmojiExplainedPresenter getEmojiExplainedPresenter(Context context) {
        if (instance == null) {
            instance = new EmojiExplainedPresenter(context);
        }
        return instance;
    }

    private EmojiExplainedPresenter(Context context) {
        emojis = new ArrayList<>();
//        db = new EmojiDB(context);
    }

    public ArrayList<Emoji> getEmojis() {
        return db.getAllEmojis();
    }
}
