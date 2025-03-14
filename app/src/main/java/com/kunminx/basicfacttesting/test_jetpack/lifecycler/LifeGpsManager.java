package com.kunminx.basicfacttesting.test_jetpack.lifecycler;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import io.reactivex.Observable;

/**
 * Create by KunMinX at 19/7/7
 */

public class LifeGpsManager implements DefaultLifecycleObserver {

    private static LifeGpsManager sLifeGpsManager = new LifeGpsManager();

    public static LifeGpsManager getInstance() {
        return sLifeGpsManager;
    }

    private LifeGpsManager() {
    }

    private boolean mIsActive;

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        setActive(owner.getLifecycle());
        calculate();
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        setActive(owner.getLifecycle());
        // ...
    }

    private void setActive(Lifecycle lifecycle) {
        mIsActive = lifecycle.getCurrentState()
                .isAtLeast(Lifecycle.State.STARTED);
    }

    public void calculate() {
        Observable.create(emitter -> {
            /*for (; ; ) {
                if (!mIsActive) {
                    return;
                }
            }*/
        }).subscribe();
    }
}
