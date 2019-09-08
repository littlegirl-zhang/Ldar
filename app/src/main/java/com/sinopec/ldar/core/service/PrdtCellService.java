package com.sinopec.ldar.core.service;

import com.sinopec.ldar.core.entity.PrdtCell;
import com.sinopec.ldar.core.entity.UserResult;
import com.sinopec.ldar.core.utils.DbUtil;
import com.sinopec.ldar.core.utils.HttpUtil;
import com.sinopec.ldar.core.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class PrdtCellService {
    /**
     * 获取单位下拉列表
     * @param isNetWell 是否联网
     */
    public List<PrdtCell> GetUserList(boolean isNetWell){
        List<PrdtCell> apiResult = new ArrayList<>();
        if(isNetWell){
            //TODO 这儿填上获取组织机构列表的URL
            String result = HttpUtil.get("这儿填上获取用户列表的URL", null);
            if(result!=null){
                JsonUtil.isSuccess(result);
                JsonUtil.getMsg(result);
                return JsonUtil.parseArray(JsonUtil.getData(result),PrdtCell.class);
            }
        }else{
            return DbUtil.getInstance().getmDaoSession().getPrdtCellDao().loadAll();
        }
        return apiResult;
    }
}
