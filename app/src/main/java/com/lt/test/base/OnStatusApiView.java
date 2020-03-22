package com.lt.test.base;

public abstract class OnStatusApiView<T> implements ImpStatusApiView<T> {

    @Override
    public void inProgress() {
        // ignore
    }

    @Override
    public void finishProgress() {
        // ignore
    }

    @Override
    public void onFailure(String onFailure) {
        // ignore
    }
}
