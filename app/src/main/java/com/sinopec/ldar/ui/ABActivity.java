package com.sinopec.ldar.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.app.App;

public abstract class ABActivity extends AppCompatActivity implements View.OnClickListener{

    // 当前类名
    protected final String TAG = this.getClass().getSimpleName();
    // 是否沉浸状态栏
    private boolean mAllowStatusBar;
    // 是否允许全屏
    private boolean mAllowFullScreen;
    // 是否旋转屏幕
    private boolean mAllowScreenRotate;
    // 当前Activity渲染的视图View
    private View mContentView;
    // 是否输出日志
    private boolean isDebug;
    // 标题栏
    private RelativeLayout mRlTop;
    // 返回键
    private LinearLayout mLLBack;
    // 标题
    private TextView mTvTitle;
    // 右键
    private TextView mTvRight;
    private LinearLayout mLLRight;
    private ImageView mIvSearch;
    private ImageView mIvFilter;
    // 内容根布局
    private LinearLayout mLlContent;
    // progressBar指示器
//    private CustomProgressBar mPb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isDebug = App.isDebug;
        Bundle bundle = getIntent().getExtras();
        // 参数
        initParams(bundle);
        // 全屏
        setFullScreen(true);
        if (mAllowFullScreen) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
                    .LayoutParams.FLAG_FULLSCREEN);
        }
        // 继承AppCompatActivity需要使用supportReqeustWindowFeature();
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 沉浸
        // TODO 暂时不使用沉浸-软键盘顶View
        setSteepStatusBar(false);
        if (mAllowStatusBar) {
            steepStatusBar();
        }
        // 横竖屏
        setScreenRotate(false);
        if (mAllowScreenRotate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        // 设置视图
        setContentView();
        // 隐藏返回键
        if (isIvBackGone()) {
            setIvBackGone();
        }
        // 隐藏右侧功能键
        if (isTvRightGone()) {
            setTvRightGone();
        }
        // 隐藏标题栏
        if (isTitlePanelGone()) {
            setTitlePanelGone();
        }
        if (isLLRightGone()){
            setLLRightGone();
        }
        // 返回视图
        initView(mContentView);
        // 监听
        initListener();
        // 业务
        doBusiness(this);
        // afterCreate
        afterOnCreate();
    }

    /**
     * 隐藏标题栏
     */
    protected void setTitlePanelGone() {
        mRlTop.setVisibility(View.GONE);
    }

    /**
     * 子类入口
     */
    protected abstract void afterOnCreate();

    /**
     * 设置视图
     */
    private void setContentView() {
        // 设置视图
        setContentView(R.layout.activity_base);
        // 初始化控件
        initBaseView();
        // 初始化监听
        initBaseListener();
        // 设置标题栏名称
        setTitleName(getTitleBarName());
        setRightFunName(getRightFunName());
        // 加载视图
        mContentView = LayoutInflater.from(this).inflate(bindLayout(), null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mLlContent.addView(mContentView, lp);

    }

    /**
     * 设置标题栏名称
     */
    protected void setTitleName(String title) {
        mTvTitle.setText(title);
    }

    protected void setRightFunName(String msg) {
        mTvRight.setText(msg);
    }

    private void initBaseListener() {
        mLLBack.setOnClickListener(this);
        //        mTvTitle.setOnClickListener(this);
        mTvRight.setOnClickListener(this);
        mIvFilter.setOnClickListener(this);
        mIvSearch.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initBaseView() {
        mRlTop = (RelativeLayout) findViewById(R.id.rl_base_top);
        mLLBack = (LinearLayout) findViewById(R.id.ll_base_back);
        mTvTitle = (TextView) findViewById(R.id.tv_base_title);
        mTvRight = (TextView) findViewById(R.id.tv_base_right);
        mIvFilter=findViewById(R.id.iv_base_filter);
        mIvSearch=findViewById(R.id.iv_base_search);
        mLLRight=findViewById(R.id.ll_base_right);
        mLlContent = (LinearLayout) findViewById(R.id.ll_base_content);
    }

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 初始化参数
     *
     * @param bundle
     */
    protected void initParams(Bundle bundle) {

    }

    protected abstract String getTitleBarName();

    protected abstract String getRightFunName();

    /**
     * 绑定布局
     *
     * @return 绑定布局
     */
    protected abstract int bindLayout();

    /**
     * 初始化控件
     *
     * @param view 视图
     */
    protected abstract void initView(View view);

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 点击控件
     *
     * @param view 点击的控件
     */
    protected abstract void widgetClick(View view);

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_base_back:
                finish();
                break;
            case R.id.tv_base_right:
                widgetClick(view);
                break;
            case R.id.iv_base_filter:
                widgetClick(view);
                break;
            case R.id.iv_base_search:
                widgetClick(view);
                break;
            default:
                widgetClick(view);
                break;
        }
    }

    // 最后点击时间
    long lastClick = 0;

    /**
     * 是否快速点击
     *
     * @return 是否快速点击
     */
    private boolean fastClick() {

        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;

    }

    /**
     * 处理业务
     *
     * @param context 当前上下文
     */
    protected abstract void doBusiness(Context context);

    /**
     * 仅跳转页面
     *
     * @param clz 跳转的类
     */
    protected void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * 跳转页面，传递数据。
     *
     * @param clz    跳转的类
     * @param bundle 传递的Bundle
     */
    protected void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转返回
     *
     * @param cls         跳转的类
     * @param bundle      传递的Bundle
     * @param requestCode 请求码
     */
    protected void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 是否允许全屏
     *
     * @param allowFullScreen 是否允许全屏
     */
    protected void setFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * 是否沉浸状态栏
     *
     * @param setStatusBar 是否沉浸状态栏
     */
    protected void setSteepStatusBar(boolean setStatusBar) {
        this.mAllowStatusBar = setStatusBar;
    }

    /**
     * 是否允许屏幕旋转
     *
     * @param allowScreenRotate 是否允许屏幕旋转
     */
    protected void setScreenRotate(boolean allowScreenRotate) {
        this.mAllowScreenRotate = allowScreenRotate;
    }

    protected abstract boolean isIvBackGone();


    /**
     * 隐藏返回按钮
     */
    protected void setIvBackGone() {
        mLLBack.setVisibility(View.GONE);
    }

    protected abstract boolean isLLRightGone();

    /**
     * 隐藏右侧功能按钮
     */
    protected void setLLRightGone() {
        mLLRight.setVisibility(View.GONE);
    }

    protected abstract boolean isTvRightGone();

    /**
     * 隐藏右侧功能按钮
     */
    protected void setTvRightGone() {
        mTvRight.setVisibility(View.GONE);
    }

    /**
     * 是否显示指示器
     *
     * @param isShow
     */
    protected void showIndicator(boolean isShow) {
        if (isShow) {
        } else {

        }
    }

    protected void setIndicatorMessage(String message) {
//        if (mPb != null) {
//            mPb.setMessage(message);
//        }
    }

    /**
     * 是否显示标题栏
     *
     * @return
     */
    protected abstract boolean isTitlePanelGone();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     *
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
