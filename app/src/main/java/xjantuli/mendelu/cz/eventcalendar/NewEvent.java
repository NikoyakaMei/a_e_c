package xjantuli.mendelu.cz.eventcalendar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import xjantuli.mendelu.cz.eventcalendar.Database.DatabaseQuery;

public class NewEvent extends AppCompatActivity {

    private EditText mDate;
    private EditText mMessage;
    public String message;
    public Date date;
    private Context context;
    private DatabaseQuery mQuery;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        mDate = (EditText) findViewById(R.id.mDate);
        mMessage = (EditText) findViewById(R.id.mMessage);
    }

    public void saveEvent(View view){
        Log.v("Zober datum", mDate.getText().toString());
        String dt = mDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("d-MM-yyyy", Locale.ENGLISH);
        try {
          date = format.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.v("Zober spravu", mDate.getText().toString());
        message = mMessage.getText().toString();
        EventObjects newEvent = new EventObjects(message, date);
        mQuery = new DatabaseQuery(context);
        mQuery.addEvent(newEvent);
    }

}
