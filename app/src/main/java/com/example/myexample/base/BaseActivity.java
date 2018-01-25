/*
 * author：姚政诤
 * description：基类
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myexample.R;
import com.example.myexample.event.Event;
import com.example.myexample.event.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    //导航栏
    public Toolbar toolbar;
    //放置activity的布局
    private FrameLayout viewContent;
    //标题
    private TextView toolBarTitle;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewContent = (FrameLayout) findViewById(R.id.viewContent);
        toolBarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        //隐藏toolbar自身的title
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //需要加上这句话，否则会显示label
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置framelayout中的布局
        LayoutInflater.from(this).inflate(getContentView(), viewContent);
        init(savedInstanceState);
        loadData();
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
        //ButterKnife绑定需在setContentView之后
        unbinder = ButterKnife.bind(this);
    }


    /**
     * 加载网络数据，初始化布局
     */
    protected abstract void loadData();

    protected abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);


    /**
     * 设置title
     *
     * @param title
     */
    protected void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            toolBarTitle.setText(title);
        }
    }

    /**
     * 是否显示返回按键
     *
     * @param a
     */
    protected void hideBack(Boolean a) {

        if (a) {
            toolbar.setNavigationIcon(R.mipmap.navigation_back_white);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(BaseActivity.this, "返回", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    /**
     * 是否显示menu
     *
     * @param b
     */
    protected void hideMenu(Boolean b) {
        if (b) {
//            toolbar.inflateMenu(R.menu.toolbar_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.publish) {

                    }
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }
}
