package com.example.toast;

import android.content.Context;
import android.widget.Toast;

public class ToasterMessage {

    public static void toastShort(Context c, String message){
        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(Context c, String message){
        Toast.makeText(c,message,Toast.LENGTH_LONG).show();
    }

}
