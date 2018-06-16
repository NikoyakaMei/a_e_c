package xjantuli.mendelu.cz.eventcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalendarActivity extends AppCompatActivity {
    private static final String TAG = CalendarActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        CalendarCustomView mView = (CalendarCustomView)findViewById(R.id.custom_calendar);
    }
}