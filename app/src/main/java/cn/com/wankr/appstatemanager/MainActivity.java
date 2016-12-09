package cn.com.wankr.appstatemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.com.wankr.appstatemanager.statemanager.AppStateManager;
import cn.com.wankr.appstatemanager.statemanager.BaseStateLayout;


public class MainActivity extends AppCompatActivity {

    private AppStateManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = new AppStateManager(MainActivity.this);
        mManager.init(MainActivity.this);

        mManager.setOnNoNetworkClickListener(new BaseStateLayout.NoNetworkClickListener() {
            @Override
            public void onNoNetworkClickListener(View view) {
                Toast.makeText(MainActivity.this, "刷新数据，显示之前view", Toast.LENGTH_SHORT).show();
                mManager.showContent();
            }
        });

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //因为没有自定义，所以调用会抛出你还为重写该方法异常
//                mManager.showLoading();
                mManager.showNoNetwork();
            }
        });
    }
}
