/**
 * DemoAndroidApplication.java
 * Application class
 * <p/>
 * (c) 2013-2014 by Mega Limited, Auckland, New Zealand
 * <p/>
 * This file is part of the MEGA SDK - Client Access Engine.
 * <p/>
 * Applications using the MEGA API must present a valid application key
 * and comply with the the rules set forth in the Terms of Service.
 * <p/>
 * The MEGA SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * @copyright Simplified (2-clause) BSD License.
 * <p/>
 * You should have received a copy of the license along with this
 * program.
 */
package nz.mega.android.bindingsample;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import nz.mega.sdk.MegaApiAndroid;

public class DemoAndroidApplication extends Application {

    MegaApiAndroid megaApi;
    static final String APP_KEY = "l4cmkI7B";
    static final String USER_AGENT = "MEGA Androd Simple Demo SDK";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        MegaApiAndroid.setLoggerObject(new AndroidLogger());
        MegaApiAndroid.setLogLevel(MegaApiAndroid.LOG_LEVEL_MAX);
    }

    public MegaApiAndroid getMegaApi() {
        if (megaApi == null) {
            PackageManager m = getPackageManager();
            String s = getPackageName();
            PackageInfo p;
            String path = null;
            try {
                p = m.getPackageInfo(s, 0);
                path = p.applicationInfo.dataDir + "/";
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }

            megaApi = new MegaApiAndroid(DemoAndroidApplication.APP_KEY, DemoAndroidApplication.USER_AGENT, path);
        }

        return megaApi;
    }

    public static Context getContext() {
        return context;
    }
}
