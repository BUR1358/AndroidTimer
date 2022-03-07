package com.example.timer;

public class boolean_change {
    public static void boolean_false_change() {
        MainActivity.change_hours = false;
        MainActivity.change_minuts = false;
        MainActivity.change_seconds = false;
    }

    public static void boolean_Hours_change() {
        MainActivity.change_hours = true;
        MainActivity.change_minuts = false;
        MainActivity.change_seconds = false;
    }

    public static void boolean_Minuts_change() {
        MainActivity.change_hours = false;
        MainActivity.change_minuts = true;
        MainActivity.change_seconds = false;
    }

    public static void boolean_Seconds_change() {
        MainActivity.change_hours = false;
        MainActivity.change_minuts = false;
        MainActivity.change_seconds = true;
    }

}
