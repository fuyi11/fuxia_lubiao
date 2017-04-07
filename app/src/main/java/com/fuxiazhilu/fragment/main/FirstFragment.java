package com.fuxiazhilu.fragment.main;

import android.view.View;
import android.view.ViewGroup;


import com.fuxiazhilu.adapter.SceneListAdapter;


import com.fuxiazhilu.adapter.base.recyclerview.CommonAdapter;
import com.fuxiazhilu.api.ScenicService;
import com.fuxiazhilu.api.base.BeanCallBack;
import com.fuxiazhilu.api.base.ClientJsonResp;
import com.fuxiazhilu.entity.Scene;
import com.fuxiazhilu.fragment.BaseListFragment;
import com.fuxiazhilu.utils.UIHelp;

import java.util.List;
import com.fuxiazhilu.R;
import okhttp3.Call;

/**
 * Created by linhonghong on 2015/8/11.
 */
public class FirstFragment extends BaseListFragment<Scene> {

    public static FirstFragment instance() {
        FirstFragment view = new FirstFragment();
		return view;
	}

    @Override
    protected CommonAdapter<Scene> getAdapter() {
        return new SceneListAdapter(this.getActivity());
    }

    @Override
    public void onItemClick(ViewGroup parent, View view, Object o, int position) {
        String ad_url = "http://www.zttmall.com/Wapshop/Topic.aspx?TopicId=18";
        String title = "百度一下你就知道";
        UIHelp.showWebViewActivity(getActivity(),title,ad_url);
    }

    @Override
    public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
        return false;
    }

    @Override
    public void loadData(){
        ScenicService.loadData("广州",null,null,mPageNo,mPageSize).execute(new BeanCallBack<ClientJsonResp<List<Scene>>>() {

            @Override
            public void onError(Call call, Exception e, int id) {
                UIHelp.toastMessage("加载数据出现错误,请重试!");
                refreshComplete();
            }

            @Override
            public void onResponse(ClientJsonResp<List<Scene>> response, int id) {
                mPageCount = response.getPageCount();
                adapter.updateData(response.getResponse());
                refreshComplete();
            }
        });
    }

    @Override
    protected void init() {
        firstloadData(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
