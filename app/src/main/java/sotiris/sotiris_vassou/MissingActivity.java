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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MissingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing);
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
        getMenuInflater().inflate(R.menu.menu_missing, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_found2) {
            Intent intent = new Intent(this,FoundActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void showData(View view) {

        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        String pet1="";
        String pet2="";
        String pet3="";

        if (c1.isChecked() && c2.isChecked())
            pet1="Cat\nDog";
        else if (c1.isChecked())
            pet1="Cat";
        else pet1="Dog";


        EditText lefta = (EditText) findViewById(R.id.moneyText);
        String money = lefta.getText().toString();

        SeekBar s = (SeekBar) findViewById(R.id.seekBar);
        int love = s.getProgress();

        String message = "We are sorry to hear that you lost a\n" + pet1 + "\n" + "that you love "
                + love + " % of your total love power\n" + "we will put an announcement with an award of " + money +
                "\nEuros";
        TextView t = (TextView) findViewById(R.id.showInfo);
        t.setText(message);



    }

}
