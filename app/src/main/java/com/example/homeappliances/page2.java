package com.example.homeappliances;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class page2 extends AppCompatActivity {

    ToggleButton swfan,swlig,swtv;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String num = "9428877954";
    String msgf="FAN ON";
    String msglig="LIGHT ON";
    String msgtv="TELEVISION ON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        swfan=(ToggleButton)findViewById(R.id.swfan);
        swlig=(ToggleButton)findViewById(R.id.swlig);
        swtv=(ToggleButton)findViewById(R.id.swtv);

        swfan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swfan.isChecked())
                {
                    sendSMS();
                }
            }
        });

        swlig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swlig.isChecked())
                {
                    sendSMS();
                }
            }
        });

        swtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swtv.isChecked())
                {
                    sendSMS();
                }
            }
        });
    }

    void sendSMS()
    {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_SEND_SMS:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    SmsManager smsManager=SmsManager.getDefault();

                    if(swfan.isChecked())
                    {
                        smsManager.sendTextMessage(num, null, msgf, null, null);
                    }

                    if(swlig.isChecked())
                    {
                        smsManager.sendTextMessage(num, null, msglig, null, null);
                    }
                    if(swtv.isChecked())
                    {
                        smsManager.sendTextMessage(num, null, msgtv, null, null);
                    }

                    Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Failed to send SMS", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    }

}
