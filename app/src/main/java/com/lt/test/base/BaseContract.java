package com.lt.test.base;

import androidx.annotation.StringRes;

public interface BaseContract {

    interface View {

        void afterInject();

        void afterView();

        void showLoadingDialog();

        void showLoadingDialog(@StringRes int message);

        void dismissLoadingDialog();

        void toast(int id);

        void toast(String msg);
    }

    interface Presenter {
    }

    interface Interactor {
    }
}
