package com.abhilashmishra.emojiexplained.model;

import java.util.ArrayList;

/**
 * Created by mishrabhilash on 5/10/16.
 */
public class Emoji {
    String emojiChar;
    String emojiExplanation;
    ArrayList<String> emojiTags;

    public Emoji() {
    }

    public Emoji(String emojiChar, String emojiExplanation, ArrayList<String> emojiTags) {
        this.emojiChar = emojiChar;
        this.emojiExplanation = emojiExplanation;
        this.emojiTags = emojiTags;
    }

    public String getEmojiChar() {
        return emojiChar;
    }

    public void setEmojiChar(String emojiChar) {
        this.emojiChar = emojiChar;
    }

    public String getEmojiExplanation() {
        return emojiExplanation;
    }

    public void setEmojiExplanation(String emojiExplanation) {
        this.emojiExplanation = emojiExplanation;
    }

    public ArrayList<String> getEmojiTags() {
        return emojiTags;
    }

    public void setEmojiTags(ArrayList<String> emojiTags) {
        this.emojiTags = emojiTags;
    }
}
