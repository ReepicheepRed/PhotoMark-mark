package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import me.jessyan.mvparms.demo.mvp.contract.MarkContract;
import me.jessyan.mvparms.demo.mvp.model.MarkModel;


@Module
public class MarkModule {
    private MarkContract.View view;

    /**
     * 构建MarkModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MarkModule(MarkContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MarkContract.View provideMarkView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MarkContract.Model provideMarkModel(MarkModel model) {
        return model;
    }
}