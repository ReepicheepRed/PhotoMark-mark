package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import me.jessyan.mvparms.demo.di.component.DaggerMarkComponent;
import me.jessyan.mvparms.demo.di.module.MarkModule;
import me.jessyan.mvparms.demo.mvp.contract.MarkContract;
import me.jessyan.mvparms.demo.mvp.presenter.MarkPresenter;

import me.jessyan.mvparms.demo.R;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MarkActivity extends BaseActivity<MarkPresenter> implements MarkContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMarkComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .markModule(new MarkModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_mark; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

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


}
