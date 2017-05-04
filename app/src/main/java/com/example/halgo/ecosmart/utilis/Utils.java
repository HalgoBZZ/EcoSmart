package com.example.halgo.ecosmart.utilis;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Halgo on 01/05/2017.
 */
public class Utils {

    public static List<String> printForegroundTask(Context context) {
        String currentApp = "NULL";
        List<String> mRunningAppList = new ArrayList<>();
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            //noinspection ResourceType
            UsageStatsManager usm = (UsageStatsManager)context.getSystemService("usagestats");
            long time = System.currentTimeMillis();
            List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,  time - 1000*1000, time);
            if (appList != null && appList.size() > 0) {
                SortedMap<Long, UsageStats> mySortedMap = new TreeMap<Long, UsageStats>();
                for (UsageStats usageStats : appList) {
                    mRunningAppList.add(usageStats.getPackageName());
                    Log.e("adapter", "App : " + usageStats.getPackageName());
                    // mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
                }
                /*if (mySortedMap != null && !mySortedMap.isEmpty()) {
                    currentApp = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
                }*/
            }
        } else {
            ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo process :
                    tasks) {
                mRunningAppList.add(process.processName);
            }
            // currentApp = tasks.get(0).processName;
        }

        //Log.e("adapter", "Current App in foreground is: " + currentApp);
        return mRunningAppList;
    }
}
