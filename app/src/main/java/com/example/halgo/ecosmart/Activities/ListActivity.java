package com.example.halgo.ecosmart.Activities;

/**
 * Created by Halgo on 01/05/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.halgo.ecosmart.Activities.managementmodel.AjoutActivity;
import com.example.halgo.ecosmart.R;

public class ListActivity extends AppCompatActivity {
    public Button bouton;
    public void init1(){
        bouton=(Button)findViewById(R.id.create_model);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vers=new Intent(ListActivity.this,AjoutActivity.class);
                startActivity(vers);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init1();
    }
}

