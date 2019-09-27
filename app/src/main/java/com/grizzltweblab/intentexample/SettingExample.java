package com.grizzltweblab.intentexample;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_example);
    }

    public void openWifi(View view) {

        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWirelessSetting(View view) {
        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openAeroplaneSetting(View view) {


        Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openBluetoothSetting(View view) {
        Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openDateSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_DATE_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openLocationSetting(View view) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openDisplaySetting(View view) {

        Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void openSecuritySetting(View view) {


        Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openInternalStorageSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openExternalStorageSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_MEMORY_CARD_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openInputSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openBatterySetting(View view) {

        Intent intent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openSoundSetting(View view) {

        Intent intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

//
//    ACTION_SETTINGS
//            ACTION_WIRELESS_SETTINGS----------------
//    ACTION_AIRPLANE_MODE_SETTINGS-------------
//            ACTION_WIFI_SETTINGS-------------
//    ACTION_APN_SETTINGS
//            ACTION_BLUETOOTH_SETTINGS--------------
//    ACTION_DATE_SETTINGS---------------
//            ACTION_LOCALE_SETTINGS---------------
//    ACTION_INPUT_METHOD_SETTINGS---------------
//            ACTION_DISPLAY_SETTINGS---------------
//    ACTION_SECURITY_SETTINGS------------------
//            ACTION_LOCATION_SOURCE_SETTINGS-------------
//    ACTION_INTERNAL_STORAGE_SETTINGS---------------
//            ACTION_MEMORY_CARD_SETTINGS----------