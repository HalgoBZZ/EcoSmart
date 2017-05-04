package com.example.halgo.ecosmart.Activities.managementmodel.adapters;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.halgo.ecosmart.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Halgo on 01/05/2017.
 */
public class ApplicationListAdapter extends BaseAdapter {

    Context context;
    List<ApplicationInfo> mData;

    public ApplicationListAdapter(Context context, List<ApplicationInfo> data) {
        this.context= context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_list_row_item, viewGroup, false);
            mHolder = new ViewHolder();
            mHolder.mCheckBox = (CheckBox) view.findViewById(R.id.checkBox);
            mHolder.mAppIcon = (ImageView) view.findViewById(R.id.appIcon);
            mHolder.mAppName = (TextView) view.findViewById(R.id.appName);
            view.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) view.getTag();
        }
        try {
            mHolder.mAppIcon.setImageDrawable(context.getPackageManager().getApplicationIcon(mData.get(i).packageName));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mHolder.mAppName.setText(context.getPackageManager().getApplicationLabel(mData.get(i)));
        mHolder.mAppName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                am.killBackgroundProcesses(context.getPackageName());
            }
        });
        return view;
    }

    public static class ViewHolder{
        CheckBox mCheckBox;
        ImageView mAppIcon;
        TextView mAppName;
    }
}
