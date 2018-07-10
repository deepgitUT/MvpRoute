package com.location.mvp.mvp_route_demo.view.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.location.mvp.mvp_route_demo.R;
import com.location.mvp.mvp_route_demo.adapter.PictureAdapter;
import com.location.mvp.mvp_route_demo.bean.PictureBean;
import com.location.mvp.mvp_route_demo.contract.PictureContract;
import com.location.mvp.mvp_route_demo.presenter.PicturePresenter;
import com.location.mvp.mvproutelibrary.Base.BaseActivity;
import com.location.mvp.mvproutelibrary.adapter.OnItemClickListener;
import com.location.mvp.mvproutelibrary.adapter.ViewHolder;
import com.location.mvp.mvproutelibrary.error.ExceptionHandle;
import com.location.mvp.mvproutelibrary.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: MvpRoute
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2018/7/2 0002 20:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class PictureActivity extends BaseActivity<PictureContract.Presenter> implements
        PictureContract.View, OnItemClickListener {
    private RecyclerView recyclerView;
    private List<PictureBean.ResultsBean> data;
    private PictureAdapter adapter;

    @Override
    public void onshowError(ExceptionHandle.ResponeThrowable baseThrowable) {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_picture;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.id_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        adapter = new PictureAdapter(data, R.layout.item_picture, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presenter.loadPicture();
    }

    @NonNull
    @Override
    protected PictureContract.Presenter createPresenter() {
        return new PicturePresenter();
    }

    @Override
    public void showData(List<PictureBean.ResultsBean> response) {
        data.addAll(response);
        adapter.refresh(data);


    }

    @Override
    public void onItemClick(ViewHolder viewHolder, View view, int position) {

    }
}
