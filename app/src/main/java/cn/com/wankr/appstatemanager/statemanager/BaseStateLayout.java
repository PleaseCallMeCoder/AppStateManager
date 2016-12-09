package cn.com.wankr.appstatemanager.statemanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 各种状态的基类,方便外部调用
 * Created by lei on 2016/12/8.
 */

public abstract class BaseStateLayout extends FrameLayout {

    public BaseStateLayout(Context context) {
        super(context);
    }

    public BaseStateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseStateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    abstract void setContent(View view);

    /**
     * 初始化需要的几个状态的view
     */
    abstract void init();

    /**
     * 显示原始内容
     */
    abstract void showContent();

    /**
     * 显示无数据状态
     */
    abstract void showNoData();

    /**
     * 显示无网络状态
     */
    abstract void showNoNetwork();

    /**
     * 显示loading,此loading为非浮层loading
     */
    public void showLoading() {
        throw new UnsupportedOperationException("you haven't override the showLoading() method");
    }

    /**
     * 显示没有关注状态
     */
    public void showNoWatch() {
        throw new UnsupportedOperationException("you haven't override the showNoWatch() method");
    }

    /**
     * 没有搜索结果状态
     */
    public void showNoSearchResult() {
        throw new UnsupportedOperationException("you haven't override the showNoSearchResult() method");
    }

    public interface NoNetworkClickListener {
        void onNoNetworkClickListener(View view);
    }

    abstract void setOnNoNetworkClickListener(NoNetworkClickListener listener);

}
