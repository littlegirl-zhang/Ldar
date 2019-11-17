package com.sinopec.ldar.core.service;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.core.utils.JsonUtil;
import com.sinopec.ldar.core.utils.ResponseHandler;
import com.sinopec.ldar.utils.AppConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class NetworkService {

    private static ResponseHandler mHandler;

    private static NetworkService INSTANCE = new NetworkService();

    private NetworkService() {
    }

    public static NetworkService getInstance() {
        mHandler = new ResponseHandler();
        return INSTANCE;
    }

    /**
     * 获取用户信息
     *
     * @param companyCode
     * @param ldarOrg
     */
    public void GetUserInfo(String companyCode, int ldarOrg, final ResponseHandler.ResponseCallback callback) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETUSERINFO)
                .addParams("companyCode", companyCode)
                .addParams("LDAROrgEnum", ldarOrg + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetUserInfo--onError:" + e);
                        sendErrorResult(e, callback);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetUserInfo--onResponse:" + response);
                        if (JsonUtil.isSuccess(response)) {
                            sendSuccessResult(response, callback);
                        } else {
                            sendFailureResult(response, callback);
                        }
                    }
                });
    }

    /**
     * 成功回调
     *
     * @param result
     * @param callback
     */
    private void sendSuccessResult(final String result, final ResponseHandler.ResponseCallback callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onOperSuccess(JsonUtil.getMsg(result));
            }
        });
    }

    /**
     * 失败回调
     *
     * @param result
     * @param callback
     */
    private void sendFailureResult(final String result, final ResponseHandler.ResponseCallback callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onOperFailure(JsonUtil.getError(result));
            }
        });
    }

    /**
     * 异常回调
     *
     * @param e
     * @param callback
     */
    private void sendErrorResult(final Exception e, final ResponseHandler.ResponseCallback callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onOperError(e);
            }
        });
    }

    /**
     * 获取生产单位
     *
     * @param companyCode
     * @param userId
     */
    public void GetPrdtCell(String companyCode, String userId) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETPRDTCELL)
                .addParams("conpanyCode", companyCode)
                .addParams("userId", userId)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetPrdtCell--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetPrdtCell--onResponse:" + response);
                    }
                });
    }

    /**
     * 获取检测中得任务集合
     *
     * @param userId
     * @param prdtCellId
     */
    public void GetDeteTask(String userId, double prdtCellId) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETDETETASK)
                .addParams("userId", userId)
                .addParams("prdtCellId", prdtCellId + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetDeteTask--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetDeteTask--onResponse:" + response);
                    }
                });
    }

    /**
     * 获取任务详细信息
     *
     * @param deteTaskId
     */
    public void GetDeteTaskDtl(double deteTaskId) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETDETETASKDTL)
                .addParams("deteTaskId", deteTaskId + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetDeteTaskDtl--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetDeteTaskDtl--onResponse:" + response);
                    }
                });
    }


    /**
     * 获取ldar检测仪器
     *
     * @param companyCode
     */
    public void GetLDARDeteInstrmt(String companyCode) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETLDARDETEINSTRMT)
                .addParams("companyCode", companyCode)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetLDARDeteInstrmt--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetLDARDeteInstrmt--onResponse:" + response);
                    }
                });
    }


    /**
     * 获取ldar标准气体
     *
     * @param companyCode
     */
    public void GetLDARStdGas(String companyCode) {
        OkHttpUtils.get()
                .url(AppConfig.URL_GETLDARSTDGAS)
                .addParams("companyCode", companyCode)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===GetLDARStdGas--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===GetLDARStdGas--onResponse:" + response);
                    }
                });
    }

    /**
     * 回传检测数据
     *
     * @param deteDataResultJson
     */
    public void UploadDeteData(String deteDataResultJson) {
        OkHttpUtils.get()
                .url(AppConfig.URL_UPLOADDETEDATA)
                .addParams("deteDataResultJson", deteDataResultJson)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===UploadDeteData--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===UploadDeteData--onResponse:" + response);
                    }
                });
    }


    /**
     * 回传检测仪器校准
     *
     * @param deteInstrmtCalibtJson
     */
    public void UpLoadDeteInstrmtCalibt(String deteInstrmtCalibtJson) {
        OkHttpUtils.get()
                .url(AppConfig.URL_UPLOADDETEINSTRMTCALIBT)
                .addParams("deteInstrmtCalibtJson", deteInstrmtCalibtJson)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===UpLoadDeteInstrmtCalibt--onError:" + e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===UpLoadDeteInstrmtCalibt--onResponse:" + response);
                    }
                });
    }
}
