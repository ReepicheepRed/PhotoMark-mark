package me.jessyan.mvparms.demo.app;

import android.app.Application;
import android.util.DisplayMetrics;

/**
 * Created by sky on 2015/7/6.
 */
public class App extends Application {

    protected static App       mInstance;
    private DisplayMetrics     displayMetrics = null;

    public App(){
        mInstance = this;
    }

    public static App getApp() {
        if (mInstance != null && mInstance instanceof App) {
            return (App) mInstance;
        } else {
            mInstance = new App();
            mInstance.onCreate();
            return (App) mInstance;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        initImageLoader();
        mInstance = this;
////         xUtils
//        x.Ext.init(this);
//        x.Ext.setDebug(BuildConfig.DEBUG);
////        ShareSDk
//        ShareSDK.initSDK(this);
////Talking data analytics
//        TCAgent.LOG_ON=true;
//        TCAgent.init(this, "FC5FC8C117FC47B9A127249D45507438", "play.google.com");
//        TCAgent.setReportUncaughtExceptions(true);
//
//// HostnameVerifier安全问题处理方式
//        HttpsURLConnection.setDefaultHostnameVerifier((hostName, session) -> {
//// 只要这里不是直接 return true; google play就能校验通过
//            return Constant.getBaseUrl().equals(hostName);
//        });
    }


//    private void initImageLoader() {
//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheInMemory(false)
//                .imageScaleType(ImageScaleType.EXACTLY)
//                .cacheOnDisk(true)
//                .build();
//
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .defaultDisplayImageOptions(defaultOptions)
//                .denyCacheImageMultipleSizesInMemory()
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
//                .diskCache(new UnlimitedDiskCache(StorageUtils.getOwnCacheDirectory(this, AppConstants.APP_IMAGE)))
//                .diskCacheSize(100 * 1024 * 1024).tasksProcessingOrder(QueueProcessingType.LIFO)
//                .memoryCache(new LruMemoryCache(2 * 1024 * 1024)).memoryCacheSize(2 * 1024 * 1024)
//                .threadPoolSize(3)
//                .build();
//        ImageLoader.getInstance().init(config);
//    }


    public float getScreenDensity() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.density;
    }

    public int getScreenHeight() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.heightPixels;
    }

    public int getScreenWidth() {
        if (this.displayMetrics == null) {
            setDisplayMetrics(getResources().getDisplayMetrics());
        }
        return this.displayMetrics.widthPixels;
    }

    public void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        this.displayMetrics = DisplayMetrics;
    }

    public int dp2px(float f)
    {
        return (int)(0.5F + f * getScreenDensity());
    }

    public int px2dp(float pxValue) {
        return (int) (pxValue / getScreenDensity() + 0.5f);
    }

    //获取应用的data/data/....File目录
    public String getFilesDirPath() {
        return getFilesDir().getAbsolutePath();
    }

    //获取应用的data/data/....Cache目录
    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }



}
