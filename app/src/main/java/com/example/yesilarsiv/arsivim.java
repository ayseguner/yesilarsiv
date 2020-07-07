package com.example.yesilarsiv;

import android.widget.TextView;

import java.io.Serializable;

public class arsivim implements Serializable {

    private int notId;
    private String textViewNot;

    public arsivim() {
    }

    public arsivim(int notId, String textViewNot) {
        this.notId = notId;
        this.textViewNot = textViewNot;
    }

    public int getNotId() {
        return notId;
    }

    public void setNotId(int notId) {
        this.notId = notId;
    }

    public String getTextViewNot() {
        return textViewNot;
    }

    public void setTextViewNot(String textViewNot) {
        this.textViewNot = textViewNot;
    }
}