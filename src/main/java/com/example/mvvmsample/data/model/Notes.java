/*
 * *
 *  * Created by Abhisek on 11/25/19 5:56 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/25/19 5:56 PM
 *
 */

package com.example.mvvmsample.data.model;

public class Notes {
    private String title, text, date;

    public Notes() {
    }

    public Notes(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
