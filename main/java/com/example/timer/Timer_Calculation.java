package com.example.timer;

public class Timer_Calculation {
    public static int time_calculation() {
        int calculated_time;
        if (MainActivity.absolut_time_for_timer == 0) {
            calculated_time = ((MainActivity.hours * 60 * 60) + (MainActivity.minuts * 60) + (MainActivity.seconds)) * 1000;
        } else {
            calculated_time = (int) MainActivity.absolut_time_for_timer;
        }
        return calculated_time;
    }

    public static void tik_calculation() {
        int hours_tik = (int) MainActivity.absolut_time_for_timer / 1000 / 60 / 60;
        int minuts_tik = (int) MainActivity.absolut_time_for_timer / 1000 / 60;
        int seconds_tik = (int) MainActivity.absolut_time_for_timer / 1000 - (minuts_tik * 60);

        if (seconds_tik <= 5 && minuts_tik == 0 && hours_tik == 0) {
            colors_change.red_color();
        } //красный цифры при окончании

        if ((hours_tik >= 0) && (hours_tik < 10)) {
            MainActivity.Hours_textView.setText("0" + hours_tik);
        } else {
            MainActivity.Hours_textView.setText("" + hours_tik);
        }

        if ((minuts_tik >= 0) && (minuts_tik < 10)) {
            MainActivity.Minuts_textView.setText(":0" + minuts_tik);
        } else {
            MainActivity.Minuts_textView.setText(":" + minuts_tik);
        }

        if ((seconds_tik >= 0) && (seconds_tik < 10)) {
            MainActivity.Seconds_textView.setText(":0" + seconds_tik);
        } else {
            MainActivity.Seconds_textView.setText(":" + seconds_tik);
        }
    }
}
