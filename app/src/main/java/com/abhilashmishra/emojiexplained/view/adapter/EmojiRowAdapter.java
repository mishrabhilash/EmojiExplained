package com.abhilashmishra.emojiexplained.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhilashmishra.emojiexplained.R;
import com.abhilashmishra.emojiexplained.model.Emoji;
import com.abhilashmishra.emojiexplained.view.viewholder.EmojiRowViewHolder;

import java.util.ArrayList;

/**
 * Created by mishrabhilash on 5/10/16.
 */
public class EmojiRowAdapter extends RecyclerView.Adapter<EmojiRowViewHolder> {

    private static Context context;
    private static ArrayList<Emoji> emojis;

    public EmojiRowAdapter(Context ctx, ArrayList<Emoji> eList) {
        this.context = ctx;
        this.emojis = eList;
    }

    @Override
    public EmojiRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_emoji_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        EmojiRowViewHolder vh = new EmojiRowViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(EmojiRowViewHolder holder, int position) {
        Emoji emoji = emojis.get(position);
        holder.emojiView.setText(emoji.getEmojiChar());
        holder.emojiExplanation.setText(emoji.getEmojiExplanation().toLowerCase().replace("\"",""));
    }

    @Override
    public int getItemCount() {
        return emojis !=null? emojis.size():0;
    }
}
