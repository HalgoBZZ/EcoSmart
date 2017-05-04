package com.example.halgo.ecosmart.Commands.Services;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.halgo.ecosmart.utilis.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Halgo on 01/05/2017.
 */
public class ApplicationRepository {

    static ApplicationRepository mAppRepository;

    public ApplicationRepository getAppRepository() {
        if (mAppRepository != null) {
            return mAppRepository;
        }
        else {
            return mAppRepository = new ApplicationRepository();
        }
    }

    // Get Installed Apps (in background)
    public static List<ApplicationInfo> getInstalledApps(Context context) {
        final PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        List<ApplicationInfo> installedApps = new ArrayList<>();

        for (ApplicationInfo appInfo :
                packages) {
            if (!isSystemPackage(appInfo))
                installedApps.add(appInfo);
        }
        return installedApps;
    }

    private static boolean isSystemPackage(ApplicationInfo applicationInfo) {
        return ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }
}
