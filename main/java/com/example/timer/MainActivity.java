package com.example.timer;

import static android.telephony.AvailableNetworkInfo.PRIORITY_HIGH;
import static android.telephony.AvailableNetworkInfo.PRIORITY_LOW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static boolean change_hours = false;
    static boolean change_minuts = false;
    static boolean change_seconds = false;

    boolean but_switch = false;
    static int duration_time = 300;
    int rotation1 = 90;
    int rotation2 = 0;
    int rotation_stop = 0;

    boolean timer_run = false;

    static long absolut_time_for_timer = 0;
    static int time = 0;
    static int hours;
    static int minuts;
    static int seconds;

    static float one_hundred_procent;
    static float left_procent;
    static float progress_circle;

    TimerView mTimerView;
    static int TIMER_LENGTH;

    static TextView Hours_textView;
    static TextView Minuts_textView;
    static TextView Seconds_textView;
    static ImageView Up_button;
    static ImageView Down_button;
    static ImageView Start_button;
    static ImageView Pasue_button;
    static ImageView Clear_timer;
    Toast toast_paused;
    Toast toast_cleared;
    Toast time_is_over;
    NotificationCompat.Builder builder;
    Notification notification;

    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    private NotificationManager nm;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        definition();
        mTimerView.start(0);
        Up_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Up_button.animate().scaleY(1.1F).scaleX(1.1F).setDuration(2);
                    _Up_button();

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Up_button.animate().scaleY(1F).scaleX(1F).setDuration(2);
                }
                return true;
            }
        });
        Down_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    Down_button.animate().scaleY(1.1F).scaleX(1.1F).setDuration(2);
                    _Down_button();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Down_button.animate().scaleY(1F).scaleX(1F).setDuration(2);
                }
                return true;
            }
        });
    }


    private void definition() {
        Hours_textView = findViewById(R.id.hours);
        Minuts_textView = findViewById(R.id.minuts);
        Seconds_textView = findViewById(R.id.seconds);
        Up_button = findViewById(R.id.up_but);
        Down_button = findViewById(R.id.down_but);
        Start_button = findViewById(R.id.start_but);
        Pasue_button = findViewById(R.id.pause_but);
        Clear_timer = findViewById(R.id.clear_timer);
        toast_paused = Toast.makeText(getApplicationContext(), language.paused, Toast.LENGTH_SHORT);
        toast_cleared = Toast.makeText(getApplicationContext(), language.cleared, Toast.LENGTH_SHORT);
        time_is_over = Toast.makeText(getApplicationContext(), language.time_is_over, Toast.LENGTH_SHORT);
        mTimerView = (TimerView) findViewById(R.id.timer);
    }

    public void Hours_button(View view) {
        boolean_change.boolean_Hours_change();
        colors_change.hours_color();
    }

    public void Minuts_button(View view) {
        boolean_change.boolean_Minuts_change();
        colors_change.minuts_color();
    }

    public void Seconds_button(View view) {
        boolean_change.boolean_Seconds_change();
        colors_change.seconds_color();
    }

    public void _Up_button() {
        if (time == 0) {
            if (change_hours == true) {
                if ((hours >= 0) && (hours < 60)) {
                    Hours_textView.setText(Units.Units_increment_without_dot(hours));
                    hours++;
                }
            } else if (change_minuts == true) {
                if ((minuts >= 0) && (minuts < 60)) {
                    Minuts_textView.setText(Units.Units_increment(minuts));
                    minuts++;
                }
            } else if (change_seconds == true) {
                if ((seconds >= 0) && (seconds < 60)) {
                    Seconds_textView.setText(Units.Units_increment(seconds));
                    seconds++;
                }
            }
        } else {
            toast_paused.show();
        }
    }

    public void _Down_button() {
        if (time == 0) {
            if (change_hours == true) {
                if ((hours > 0) && (hours <= 60)) {
                    Hours_textView.setText(Units.Units_decrement_without_dot(hours));
                    hours--;
                }
            } else if (change_minuts == true) {
                if ((minuts > 0) && (minuts <= 60)) {
                    Minuts_textView.setText(Units.Units_decrement(minuts));
                    minuts--;
                }
            } else if (change_seconds == true) {
                if ((seconds > 0) && (seconds <= 60)) {
                    Seconds_textView.setText(Units.Units_decrement(seconds));
                    seconds--;
                }
            }
        } else {
            toast_paused.show();
        }
    }

    public void Start_button(View view) {

        if (but_switch == false) {
            time = (Timer_Calculation.time_calculation());
            StarToPasue();
            TIMER_LENGTH();
            countDownTimer = new CountDownTimer(time, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    absolut_time_for_timer = millisUntilFinished;
                    Timer_Calculation.tik_calculation();
                }

                @Override
                public void onFinish() {
                    if (time != 0) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell_sound);
                        mediaPlayer.start();
                        time_is_over.show();
                        try {
                            Thread.sleep(2000);  // пауза на 2 секунды
                        } catch (InterruptedException e) {
                        }
                        PauseToStart();
                    }
                    Units.clear_all();
                    mTimerView.start(0);
                    timer_run = false;
                }
            }.start();
        } else {
            PauseToStart();
        }
    }

    public void Clear_timer(View view) {
        if (time != 0) {
            mTimerView.stop();
            PauseToStart();
            countDownTimer.cancel();
        }
        rotation_stop = rotation_stop - 360;
        toast_cleared.show();
        Clear_timer.animate().rotation(rotation_stop).setDuration(duration_time);
        Units.clear_all();
        mTimerView.start(0);
        timer_run = false;
    }

    public void StarToPasue() {
        if (time != 0) {
            boolean_change.boolean_false_change();
            colors_change.wipe_color();
            rotation1 = 90;
            rotation2 = 0;
            Start_button.animate().alpha(0).scaleY(0.5F).scaleX(0.5F).rotation(rotation1).setDuration(duration_time);
            Pasue_button.animate().alpha(1).scaleY(1F).scaleX(1F).rotation(rotation2).setDuration(duration_time);
        }
        but_switch = true;
    }

    public void PauseToStart() {
        if (time != 0) {
            countDownTimer.cancel();
            colors_change.orange_color();
            rotation1 = 0;
            rotation2 = -90;
            Pasue_button.animate().alpha(0).scaleY(0.5F).scaleX(0.5F).rotation(rotation2).setDuration(duration_time);
            Start_button.animate().alpha(1).scaleY(1F).scaleX(1F).rotation(rotation1).setDuration(duration_time);
        }
        mTimerView.pause();
        but_switch = false;
    }

    public void TIMER_LENGTH() {
        TIMER_LENGTH = time / 1000;
        if (one_hundred_procent == 0) {
            one_hundred_procent = time;
        } else {
            left_procent = time;
        }
        progress_circle = (left_procent / one_hundred_procent);
        if (!timer_run) {
            mTimerView.start(TIMER_LENGTH);
            timer_run = true;
        } else {
            mTimerView.resume(progress_circle, TIMER_LENGTH);
        }
    }

    public void wipe_zone(View view) {
        colors_change.wipe_color();
        boolean_change.boolean_false_change();
    }
}

