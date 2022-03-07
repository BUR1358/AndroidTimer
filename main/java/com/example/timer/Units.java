package com.example.timer;


public class Units {

    static String strintTimeUnits;

    public static String Units_increment_without_dot(int timeUnits) {
        strintTimeUnits = "";
        if ((timeUnits >= 0) && (timeUnits < 9)) {
            timeUnits = timeUnits + 1;
            strintTimeUnits = "0" + timeUnits;
        } else {
            timeUnits = timeUnits + 1;
            strintTimeUnits = "" + timeUnits;
        }
        return strintTimeUnits;
    }

    public static String Units_increment(int timeUnits) {
        strintTimeUnits = "";
        if ((timeUnits >= 0) && (timeUnits < 9)) {
            timeUnits = timeUnits + 1;
            strintTimeUnits = ":0" + timeUnits;
        } else {
            timeUnits = timeUnits + 1;
            strintTimeUnits = ":" + timeUnits;
        }
        return strintTimeUnits;
    }

    public static String Units_decrement_without_dot(int timeUnits) {
        strintTimeUnits = "";
        if ((timeUnits >= 0) && (timeUnits <= 10)) {
            timeUnits = timeUnits - 1;
            strintTimeUnits = "0" + timeUnits;
        } else {
            timeUnits = timeUnits - 1;
            strintTimeUnits = "" + timeUnits;
        }
        return strintTimeUnits;
    }

    public static String Units_decrement(int timeUnits) {
        strintTimeUnits = "";
        if ((timeUnits >= 0) && (timeUnits <= 10)) {
            timeUnits = timeUnits - 1;
            strintTimeUnits = ":0" + timeUnits;
        } else {
            timeUnits = timeUnits - 1;
            strintTimeUnits = ":" + timeUnits;
        }
        return strintTimeUnits;
    }

    public static void clear_all() {
        MainActivity.Hours_textView.setText("00");
        MainActivity.Minuts_textView.setText(":00");
        MainActivity.Seconds_textView.setText(":00");
        MainActivity.absolut_time_for_timer = 0;
        MainActivity.time = 0;
        MainActivity.hours = 0;
        MainActivity.minuts = 0;
        MainActivity.seconds = 0;
        MainActivity.left_procent = 0;
        MainActivity.one_hundred_procent =0;
        colors_change.wipe_color();
        MainActivity.Start_button.animate().rotation(0).setDuration(MainActivity.duration_time);
    }

}