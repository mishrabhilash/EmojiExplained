package com.abhilashmishra.emojiexplained.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abhilashmishra.emojiexplained.R;

import java.lang.ref.WeakReference;

/**
 * Created by mishrabhilash on 5/10/16.
 */
public class EmojiRowViewHolder extends RecyclerView.ViewHolder {
    public TextView emojiView,emojiExplanation;
    public Button useEmoji;
    WeakReference<Context> context;
    public EmojiRowViewHolder(View itemView,Context context) {
        super(itemView);
        this.context=new WeakReference<Context>(context);
        emojiView = (TextView)itemView.findViewById(R.id.emoji);
        emojiExplanation = (TextView)itemView.findViewById(R.id.emoji_explain);
    }
}
