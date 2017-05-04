package com.example.halgo.ecosmart.Activities.managementmodel;

/**
 * Created by Halgo on 01/05/2017.
 */
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.halgo.ecosmart.Activities.managementmodel.adapters.ApplicationListAdapter;
import com.example.halgo.ecosmart.Commands.Services.ApplicationRepository;
import com.example.halgo.ecosmart.R;

import java.util.List;

public class AjoutActivity extends AppCompatActivity {

    public ListView appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        appList = (ListView) findViewById(R.id.appList);
        loadApps2List(this, ApplicationRepository.getInstalledApps(this));
    }

    private void loadApps2List(Context context, List<ApplicationInfo> runningApps) {
        if (runningApps != null && runningApps.size() > 0) {
            appList.setAdapter(new ApplicationListAdapter(context, runningApps));
        }
    }


}

