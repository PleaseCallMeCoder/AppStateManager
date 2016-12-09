package cn.com.wankr.appstatemanager.statemanager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

/**
 * 初始化App各种状态,比如无网络、无数据、加载中等
 * Created by lei on 2016/12/8.
 */
public class AppStateManager {

    BaseStateLayout mStateLayout;

    private Context mContext;

    public AppStateManager(Context context) {
        mStateLayout = new GuessStateLayout(context);
        mContext = context;
    }

    public void init(Object view) {
        mStateLayout.init();

        //获取根布局
        ViewGroup contentParent = null;
        if (view instanceof Activity) {
            Activity activity = (Activity) view;
            contentParent = (ViewGroup) activity.findViewById(android.R.id.content);
        } else if (view instanceof Fragment) {
            Fragment fragment = (Fragment) view;
            contentParent = (ViewGroup) (fragment.getView().getParent());
        }

        //获取跟布局下的view
        View oldContent = contentParent.getChildAt(0);
        contentParent.removeView(oldContent);

        //重新设置根布局的内容为StateLayoutInterface
        ViewGroup.LayoutParams lp = oldContent.getLayoutParams();
        contentParent.addView(mStateLayout, 0, lp);
        mStateLayout.setContent(oldContent);

        //设置显示原内容
        mStateLayout.showContent();
    }

    public void showContent() {
        mStateLayout.showContent();
    }

    public void showNoDate() {
        mStateLayout.showNoData();
    }

    public void showNoNetwork() {
        mStateLayout.showNoNetwork();
    }

    public void showLoading() {
        mStateLayout.showLoading();
    }

    public void showNoWatch() {
        mStateLayout.showNoWatch();
    }

    public void showNoSearchResult() {
        mStateLayout.showNoSearchResult();
    }

    public void setOnNoNetworkClickListener(BaseStateLayout.NoNetworkClickListener listener) {
        mStateLayout.setOnNoNetworkClickListener(listener);
    }
}
