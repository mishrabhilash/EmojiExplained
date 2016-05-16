package com.abhilashmishra.emojiexplained.presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.abhilashmishra.emojiexplained.model.Emoji;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by mishrabhilash on 5/11/16.
 */
public class EmojiDB extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "EmojiDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_EMOJI_MASTER = "emoji_master";
    private static final String TABLE_EMOJI_MASTER_COLUMN_ID = "id";
    private static final String TABLE_EMOJI_MASTER_COLUMN_UNICODE = "unicode";
    private static final String TABLE_EMOJI_MASTER_COLUMN_EMOJI = "emoji";
    private static final String TABLE_EMOJI_MASTER_COLUMN_EXPLANATION = "explanation";

    private static EmojiDB instnace;
    private EmojiDB(Context context) {
        super(new WeakReference<Context>(context).get(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static EmojiDB getInstance(Context context){
        if(instnace==null){
            instnace = new EmojiDB(context);
        }
        return instnace;
    }


    public ArrayList<Emoji> getAllEmojis(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Emoji> emojis = new ArrayList<>();
        Cursor cursor = db.query(TABLE_EMOJI_MASTER,new String[]{TABLE_EMOJI_MASTER_COLUMN_ID,TABLE_EMOJI_MASTER_COLUMN_UNICODE,TABLE_EMOJI_MASTER_COLUMN_EMOJI,
        TABLE_EMOJI_MASTER_COLUMN_EXPLANATION},null,null,null,null,null);
        int count =0;
        if(cursor.moveToFirst()) {
            do {if(count>=50)break;
                Emoji emoji = new Emoji();
                //String tempEmoji = cursor.getString(cursor.getColumnIndex(TABLE_EMOJI_MASTER_COLUMN_EMOJI));
                emoji.setEmojiChar(cursor.getString(cursor.getColumnIndex(TABLE_EMOJI_MASTER_COLUMN_EMOJI)));
                emoji.setEmojiExplanation(cursor.getString(cursor.getColumnIndex(TABLE_EMOJI_MASTER_COLUMN_EXPLANATION)));
                emojis.add(emoji);
                //Log.v(emoji.getEmojiExplanation(),emoji.getEmojiChar());
                count++;
            }while(cursor.moveToNext());
        }
        return emojis;
    }


}
