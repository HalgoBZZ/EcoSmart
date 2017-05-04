package com.example.halgo.ecosmart.Activities.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.halgo.ecosmart.Activities.managementmodel.AjoutActivity;
import com.example.halgo.ecosmart.R;

public class MainActivity extends AppCompatActivity {
    public Button mCreateModelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        mCreateModelBtn = (Button) findViewById(R.id.create_model);

        mCreateModelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vers=new Intent(MainActivity.this,AjoutActivity.class);
                startActivity(vers);
            }
        });
    }
}
