package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import me.jessyan.mvparms.demo.di.module.MarkModule;

import me.jessyan.mvparms.demo.mvp.ui.activity.MarkActivity;

@ActivityScope
@Component(modules = MarkModule.class, dependencies = AppComponent.class)
public interface MarkComponent {
    void inject(MarkActivity activity);
}