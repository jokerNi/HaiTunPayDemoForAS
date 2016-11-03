package com.longyou.haitunpay;

import android.app.Application;

import com.longyou.haitunsdk.HaiTunPay;

/**
 * Created by CharryLi on 16/7/26.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 如果在AndroidManifest文件中配置了HAITUN_WECHAT_KEY及HAITUN_WECHAT_MERID，
        // 则直接调用无参init函数初始化即可，如果未在xm中配置，则调用上面的initWithWechat函数进行初始化
        HaiTunPay.getInstance().init(this);
        // 配置是否显示控制台日志，开启后便于开发者查看问题
        HaiTunPay.setDebug(true);
    }
}
