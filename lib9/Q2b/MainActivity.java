// Also note that you will need to add the following permission to your AndroidManifest.xml file:

// <uses-permission android:name="android.permission.SEND_SMS" />
// put above line of code before application tag
// This permission is required to send SMS messages from your application.


package com.example.slips;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int SMS_SENT = 1;
    private static final int SMS_DELIVERED = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String phoneNumber = "1234567890"; // replace with your friend's phone number
        String message = "Hello, this is a test message!";

        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent piSent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_SENT"), 0);
        PendingIntent piDelivered = PendingIntent.getBroadcast(this, 0, new Intent("SMS_DELIVERED"), 0);

        smsManager.sendTextMessage(phoneNumber, null, message, piSent, piDelivered);
    }

    private class SentReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS sent", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private class DeliveredReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (getResultCode()) {
                case Activity.RESULT_OK:
                    Toast.makeText(getBaseContext(), "SMS delivered", Toast.LENGTH_SHORT).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter sentFilter = new IntentFilter("SMS_SENT");
        IntentFilter deliveredFilter = new IntentFilter("SMS_DELIVERED");
        registerReceiver(new SentReceiver(), sentFilter);
        registerReceiver(new DeliveredReceiver(), deliveredFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(new SentReceiver());
        unregisterReceiver(new DeliveredReceiver());
    }
}