package cn.com.wankr.appstatemanager.statemanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import cn.com.wankr.appstatemanager.R;


/**
 * 竞猜状态布局的实现
 * Created by lei on 2016/12/8.
 */

public class GuessStateLayout extends BaseStateLayout {

    private View mContentView;
    private View mNoDataView;
    private View mNoNetworkView;
    private NoNetworkClickListener mNoNetworkClickListener;
    private LayoutInflater mInflater;

    public GuessStateLayout(Context context) {
        this(context, null);
    }

    public GuessStateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public GuessStateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void setContent(View view) {
        mContentView = view;
        addView(mContentView);
    }

    @Override
    public void init() {
        initNoDataView();
        initNoNetworkView();
    }

    private void initNoDataView() {
        mNoDataView = mInflater.inflate(R.layout.guess_state_nodata, this, false);
        addView(mNoDataView);
    }

    private void initNoNetworkView() {
        mNoNetworkView = mInflater.inflate(R.layout.guess_state_nonetwork, this, false);
        mNoNetworkView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNoNetworkClickListener != null)
                    mNoNetworkClickListener.onNoNetworkClickListener(v);
            }
        });
        addView(mNoNetworkView);
    }

    @Override
    public void showContent() {
        showView(mContentView);
    }

    @Override
    public void showNoData() {
        showView(mNoDataView);
    }

    @Override
    public void showNoNetwork() {
        showView(mNoNetworkView);
    }

    @Override
    public void setOnNoNetworkClickListener(NoNetworkClickListener listener) {
        mNoNetworkClickListener = listener;
    }

    private void showView(View view) {
        setAllGone();
        if (view == mContentView) {
            mContentView.setVisibility(View.VISIBLE);
        } else if (view == mNoDataView) {
            mNoDataView.setVisibility(View.VISIBLE);
        } else if (view == mNoNetworkView) {
            mNoNetworkView.setVisibility(View.VISIBLE);
        }
    }

    private void setAllGone() {
        mContentView.setVisibility(View.GONE);
        mNoDataView.setVisibility(View.GONE);
        mNoNetworkView.setVisibility(View.GONE);
    }

}
