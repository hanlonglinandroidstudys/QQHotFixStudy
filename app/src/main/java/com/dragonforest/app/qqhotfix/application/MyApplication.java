package com.dragonforest.app.qqhotfix.application;

import android.app.Application;
import android.content.Context;

import com.dragonforest.app.qqhotfix.util.FixUtil;

import java.io.File;

/**
 * @author 韩龙林
 * @date 2019/9/26 12:52
 */
public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        FixUtil.installPatch(this,getFilesDir()+ File.separator+"patch.dex");
    }
}
