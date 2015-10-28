package sotiris.sotiris_vassou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.zip.DataFormatException;

public class FoundActivity extends AppCompatActivity {
public static final String KEY="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "App created by Sotiris Vassou", Toast.LENGTH_LONG).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_found, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_missing2) {
            Intent intent = new Intent(this,MissingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendInfo(View view) {

        Intent intent = new Intent(this,FoundActivity2.class);

        RadioGroup r = (RadioGroup) findViewById(R.id.group);
        int id = r.getCheckedRadioButtonId();
        String pet="";

        if (id==R.id.radioButton1)
            pet="Cat";
        else if (id==R.id.radioButton2)
            pet="Dog";

        EditText onoma = (EditText) findViewById(R.id.nameText);
        String name=onoma.getText().toString();

        EditText imerominia= (EditText) findViewById(R.id.dateText);
        String date=imerominia.getText().toString();

        EditText tilefwno=(EditText) findViewById(R.id.phoneText);
        String phone=tilefwno.getText().toString();

        String message="Hello " + name + "\nWe are very happy to hear that you found a lost\n" + pet +
                "\nWe will see if anyone has missed a pet on\n" + date + " and we will call you at " + phone;

        intent.putExtra(KEY, message);
        if (name.equals("") || phone.equals("") || date.equals("") || name.equals("Name"))
            Toast.makeText(getApplicationContext(), "You need to fill in all the text fields", Toast.LENGTH_LONG).show();
        else
            startActivity(intent);


    }

}
