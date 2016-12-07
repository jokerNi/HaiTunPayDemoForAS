package com.longyou.haitunpay;

import android.app.Application;

import com.longyou.haitunsdk.HaiTunPay;

/**
 * 初始化SDK的三种方式：
 * 1、在AndroidManifest.xml的application节点配置android:name="com.longyou.haitunsdk.HaiTunApp"
 * 2、如果已经自定义了Application，可让自定义的Application继承HaiTunApp
 * 3、如果已经自定义了Application且已经继承了其他第三方Application，则务必在Application的onCreate中调用HaiTunPay.getInstance().init(this)进行初始化SDK
 * 以上三种方法，选择其中一种即可
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 如果在AndroidManifest文件中配置了HAITUN_WECHAT_KEY及HAITUN_WECHAT_MERID，
        // 则直接调用无参init函数初始化即可，如果未在xm中配置，则调用上面的initWithWechat函数进行初始化
        //HaiTunPay.getInstance().init(this);
        // 配置是否显示控制台日志，开启后便于开发者查看问题
        HaiTunPay.setDebug(true);
    }
}
