package com.fuxiazhilu.adapter;

import android.content.Context;


import com.fuxiazhilu.R;
import com.fuxiazhilu.adapter.base.ViewHolder;
import com.fuxiazhilu.adapter.base.recyclerview.LoadMoreCommonAdapter;
import com.fuxiazhilu.entity.Scene;

import java.util.ArrayList;

/**
 * Created by quan on 2016/6/20.
 */
public class SceneListPageAdapter extends LoadMoreCommonAdapter<Scene> {

    public SceneListPageAdapter(Context context) {
        super(context, R.layout.item_scene, new ArrayList<Scene>());
    }

    @Override
    public void convert(ViewHolder holder, Scene item) {
        holder.setImageByUrl(R.id.item_img, item.getListRightPic());
        holder.setText(R.id.item_name, item.getName());
        holder.setText(R.id.item_right, item.getCityName());

    }
}
