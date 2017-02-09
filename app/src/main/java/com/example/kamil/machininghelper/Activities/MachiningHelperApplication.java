package com.example.kamil.machininghelper.Activities;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import android.app.Application;

public class MachiningHelperApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        Fabric.with(this, new Crashlytics());
    }
}
