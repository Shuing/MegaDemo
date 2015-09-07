package nz.mega.android.bindingsample;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private final static String SHAREDPREFERENCE_NAME = "user";

    public final static String KEY_SESSIONID = "key_sessionId";
    public final static String KEY_EMAIL = "key_email";

    private static SharedPreferences mSharedPreferences = null;

    /**
     * 获取SharedPreferences实例
     */
    public static SharedPreferences getSharedPreferences() {
        if (null == mSharedPreferences) {
            mSharedPreferences = DemoAndroidApplication.getContext()
                    .getSharedPreferences(SHAREDPREFERENCE_NAME,
                            Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }


    public static void clear() {
        SharedPreferencesHelper.putString(
                SharedPreferencesHelper.KEY_SESSIONID, "");
        SharedPreferencesHelper.putString(
                SharedPreferencesHelper.KEY_EMAIL, "");
    }

    /**
     * 设置Boolean值
     *
     * @param key
     * @param value
     */
    public static void putBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    /**
     * 设置String值
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    /**
     * 设置Int值
     *
     * @param key
     * @param value
     */
    public static void putInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    /**
     * 设置Float值
     *
     * @param key
     * @param value
     */
    public static void putFloat(String key, float value) {
        getSharedPreferences().edit().putFloat(key, value).apply();
    }

    /**
     * 设置Long值
     *
     * @param key
     * @param value
     */
    public static void putLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

}
