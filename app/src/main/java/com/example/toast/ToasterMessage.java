package com.example.toast;

import android.content.Context;
import android.widget.Toast;

public class ToasterMessage {
        public static void toast(Context c, String message){

            Toast.makeText(c,message,Toast.LENGTH_LONG).show();

        }
}
