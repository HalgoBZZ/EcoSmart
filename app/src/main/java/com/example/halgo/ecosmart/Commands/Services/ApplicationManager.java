package com.example.halgo.ecosmart.Commands.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Halgo on 01/05/2017.
 */
public class ApplicationManager extends Service{

    public static ApplicationManager mApplicationManager;

    public ApplicationManager getApplicationManager() {
        if (mApplicationManager != null)
            return mApplicationManager;
        else
        return mApplicationManager = new ApplicationManager();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
