package com.example.qqtext2;
import android.text.Spanned;

public class Message {
    public static final int TYPE_YOU=1;
    public static final int TYPE_MY=0;
    private CharSequence words;
    private int type;

    public Message(CharSequence words, int type) {
        super();
        this.words = words;
        this.type = type;
    }
    public CharSequence getWords() {
        return words;
    }
    public void setWords(CharSequence words) {
        this.words = words;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

}