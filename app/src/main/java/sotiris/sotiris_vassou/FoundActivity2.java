package sotiris.sotiris_vassou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FoundActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String info = intent.getStringExtra(FoundActivity.KEY);

        TextView t = (TextView) findViewById(R.id.messageInfo);
        t.setText(info);
    }

    public void goBack(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
