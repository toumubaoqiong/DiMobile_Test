package com.domobile.dimobile_test.net_work_request;

/**
 * 网络接口回调
 * @param <T>
 */
public interface NetRequestListener<T> {
    void onSuccess(T response);
	void onFailed(String message);
}