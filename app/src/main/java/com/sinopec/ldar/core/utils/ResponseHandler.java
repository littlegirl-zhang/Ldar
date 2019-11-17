package com.sinopec.ldar.core.utils;

import android.os.Handler;
import android.os.Message;

import com.orhanobut.logger.Logger;

public class ResponseHandler extends Handler {
    private String TAG = "ResponseHandler";

    private ResponseCallback mCallback;

    public void setResponseCallback(ResponseCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case MESSAGE_SUCCESS:
                if (mCallback != null) {
                    mCallback.onOperSuccess(msg.obj);
                }
                break;
            case MESSAGE_FAILURE:
                if (mCallback != null) {
                    mCallback.onOperFailure((String) msg.obj);
                }
                break;
            case MESSAGE_ERROR:
                if (mCallback != null) {
                    mCallback.onOperError((Exception) msg.obj);
                }
                break;
        }

    }

    public void sendFailureMessage(String response) {
        Message message = Message.obtain();
        message.what = ResponseHandler.MESSAGE_SUCCESS;
        message.obj = response;
        sendMessage(message);
    }

    public void sendSuccessMessage(Object response) {
        Message message = Message.obtain();
        message.what = ResponseHandler.MESSAGE_SUCCESS;
        message.obj = response;
        sendMessage(message);
    }

    public void sendErrorMessage(Exception e) {
        Message message = Message.obtain();
        message.what = ResponseHandler.MESSAGE_FAILURE;
        message.obj = e;
        sendMessage(message);
    }

    public interface ResponseCallback {
        public void onOperSuccess(Object response);

        public void onOperFailure(String error);

        public void onOperError(Exception e);
    }

    public static final int MESSAGE_SUCCESS = 0x00;
    public static final int MESSAGE_FAILURE = 0x01;
    public static final int MESSAGE_ERROR = 0x02;

}
