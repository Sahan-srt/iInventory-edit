package ithub.iinventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class Update extends AppCompatActivity {

    private TextView name,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toolbar nToolBar = (Toolbar) findViewById(R.id.reg_toolbar);
        setSupportActionBar(nToolBar);

        getSupportActionBar().setTitle("Update Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name=(TextView)findViewById(R.id.name);
        price=(TextView)findViewById(R.id.price);
        
        
        name.setText("Name    :  "+getIntent().getStringExtra("Name"));

        price.setText("Price    :  "+getIntent().getStringExtra("Price"));




    }



}
