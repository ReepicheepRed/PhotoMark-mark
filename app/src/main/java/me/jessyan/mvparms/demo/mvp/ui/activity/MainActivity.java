package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.yancy.gallerypick.activity.GalleryPickActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.GlideImageLoader;
import me.jessyan.mvparms.demo.di.component.DaggerMainComponent;
import me.jessyan.mvparms.demo.di.module.MainModule;
import me.jessyan.mvparms.demo.mvp.contract.MainContract;
import me.jessyan.mvparms.demo.mvp.presenter.MainPresenter;
import me.jessyan.mvparms.demo.mvp.presenter.helper.MainHelper;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    static {
        /*
        加载动态库，动态库加载的时候 JNI_OnLoad函数会被调用

        在JNI——OnLoad函数中，Java虚拟机通过函数表的形式将JNI函数和java类中native函数对应起来
         */
        System.loadLibrary("native-lib");
    }

    /*
    Jni 函数的声明
    当调用到此函数时，java虚拟机会通过JNI_OnLoad里注册的函数表找到对应的函数去执行
     */
    private native String GetStrFromJNI();

    @BindView(R.id.banner)
    Banner banner;

    List<String> images = new ArrayList<>();

    @OnClick({R.id.main_setting_iv,R.id.main_batch_ll})
    void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.main_setting_iv:
                break;
            case R.id.main_camera_ll:
                break;
            case R.id.main_batch_ll:
                MainHelper.getInstance().init(findViewById(R.id.main_batch_ll),this);
                intent.setClass(this, GalleryPickActivity.class);
                break;
            case R.id.main_poster_ll:
                break;
        }
        launchActivity(intent);
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) UiUtils.makeText(this, GetStrFromJNI());
    }
}
