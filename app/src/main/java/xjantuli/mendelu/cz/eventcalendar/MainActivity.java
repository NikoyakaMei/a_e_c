package xjantuli.mendelu.cz.eventcalendar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.AlarmClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAlarm(View view){
        Log.i(TAG, "nastavenie alarmu");
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SET_ALARM)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.SET_ALARM},
                    0);
        } else {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, 10);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, 20);
            startActivity(intent);
        }

    }

    public void openCalendar(View view){
        Log.i(TAG, "zobrazenie kalendaru");
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);

    }

    public void createEvent(View view){
        Log.i(TAG, "vytvorit Event");
        Intent intent = new Intent(this, NewEvent.class);
        startActivity(intent);
    }


}
