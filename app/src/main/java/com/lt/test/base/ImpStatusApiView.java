package com.lt.test.base;

public interface ImpStatusApiView<T> {

    void resultSuccess(T result);

    void onFailure(String onFailure);

    void inProgress();

    void finishProgress();
}
