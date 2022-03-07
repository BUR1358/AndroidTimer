package com.example.timer;

import android.graphics.Color;

public class colors_change {
    static String WhiteColor = "#ffffff";
    static String OrangeColor = "#F9AA33";
    static String RedColor = "#f94e33";

    public static void wipe_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(WhiteColor));
    }

    public static void red_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(RedColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(RedColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(RedColor));
    }

    public static void orange_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(OrangeColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(OrangeColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(OrangeColor));
    }

    public static void hours_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(OrangeColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(WhiteColor));
    }

    public static void minuts_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(OrangeColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(WhiteColor));
    }

    public static void seconds_color() {
        MainActivity.Hours_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Minuts_textView.setTextColor(Color.parseColor(WhiteColor));
        MainActivity.Seconds_textView.setTextColor(Color.parseColor(OrangeColor));
    }

}
