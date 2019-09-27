package com.grizzltweblab.intentexample;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class IntentInternalExample extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_internal_example);

        Button button=findViewById(R.id.btn4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.shuats.edu.in"));
                startActivity(intent);

            }
        });
    }

    public void setAlarm(View view) {
        // ADD THIS IN MANIFEST FILE
        // <uses-permission android:name="com.android.alarm.permission.SET_ALARM" />

        /*
            <intent-filter>
                        <action android:name="android.intent.action.SET_ALARM" />
                        <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
       */

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "My Own ALARM");
        intent.putExtra(AlarmClock.EXTRA_HOUR, 2);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 50);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    public void openCamera(View view) {

//        static final int REQUEST_IMAGE_CAPTURE = 1;
//        static final Uri locationForPhotos;

//
//         <uses-feature android:name="android.hardware.camera"
//        android:required="true" />


//<intent-filter>
//        <action android:name="android.media.action.IMAGE_CAPTURE" />
//        <category android:name="android.intent.category.DEFAULT" />
//    </intent-filter>
//

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                Uri.withAppendedPath(locationForPhotos, targetFilename));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView=findViewById(R.id.img1);
            imageView.setImageBitmap(imageBitmap);
        }

        if (requestCode == 2 && resultCode == RESULT_OK) {

            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};

            ///Cursor cursor = getContentResolver().query(contactUri, projection,null, null, null);

            // If the cursor returned is valid, get the phone number
            //if (cursor != null && cursor.moveToFirst()) {
           //     int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
          //      String number = cursor.getString(numberIndex);
                Toast.makeText(this, "Number\n"+  projection +"\n", Toast.LENGTH_SHORT).show();
                // Do something with the phone number
                //...
           // }
        }


        if (requestCode == 1234 && resultCode == RESULT_OK) {

           // Bitmap thumbnail = data.getParcelable("data");
            Uri fullPhotoUri = data.getData();
            Toast.makeText(this, ""+fullPhotoUri.toString(), Toast.LENGTH_SHORT).show();
            // Do work with photo saved at fullPhotoUri
        }

    }

    public void openContact(View view) {

        //  <uses-permission android:name="android.permission.READ_CONTACTS" />
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 2);
        }
    }

    public void setTimer(View view) {

        //<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
        /*
         <intent-filter>
        <action android:name="android.intent.action.SET_TIMER" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
                */
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "set my timer")
                .putExtra(AlarmClock.EXTRA_LENGTH, 5)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void addCalenderEvent(View view) {
/*
        <intent-filter>
        <action android:name="android.intent.action.INSERT" />
        <data android:mimeType="vnd.android.cursor.dir/event" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>

                */
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "My title")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "my location")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 100)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 105);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendMail(View view) {

//        ACTION_SENDTO (for no attachment) or
//        ACTION_SEND (for one attachment) or
//        ACTION_SEND_MULTIPLE (for multiple attachments)

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"s.m.mohsin.husain@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Mu Subject");
      if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

//
//        <intent-filter>
//        <action android:name="android.intent.action.SEND" />
//        <data android:type="*/*" />
//        <category android:name="android.intent.category.DEFAULT" />
//    </intent-filter>
//    <intent-filter>
//        <action android:name="android.intent.action.SENDTO" />
//        <data android:scheme="mailto" />
//        <category android:name="android.intent.category.DEFAULT" />
//    </intent-filter>

//
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"s.m.mohsin.husain@gmail.com"});
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Mu Subject");
//        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    public void selectImage(View view) {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("music/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1234);
        }
    }






    public void openMap(View view) {
/*
        <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <data android:scheme="geo" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>

                */
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //Uri.parse("google.streetview:cbll=46.414382,10.013988");
        //Uri.parse("geo:37.7749,-122.4194");
        // Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants");
        //Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle"));
        //Uri.parse("geo:0,0?q=-33.8666,151.1957(Google+Sydney)")
        //Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia");

        intent.setData(Uri.parse("google.navigation:q=FoodSquare Allahabadf"));
        //intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void playMedia(View view) {
/*

        <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <data android:type="audio/*" />
        <data android:type="application/ogg" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>



    <intent-filter>
        <action android:name="android.media.action.MEDIA_PLAY_FROM_SEARCH" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>


                */
//
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Settings.System.DEFAULT_ALARM_ALERT_URI);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, "hit");
        intent.putExtra(SearchManager.QUERY, "hit");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }
}
