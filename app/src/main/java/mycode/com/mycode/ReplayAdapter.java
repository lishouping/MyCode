package mycode.com.mycode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ReplayAdapter
 * (c)2018 AIR Times Inc. All rights reserved.
 *
 * @author Lishp
 * @version 1.0
 * @date 2018/8/3 8:50
 * @see
 */
public class ReplayAdapter extends BaseQuickAdapter<HashMap<String,Object>,BaseViewHolder>{
    public ReplayAdapter(int layoutResId, @Nullable List<HashMap<String, Object>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, Object> item) {
        RecyclerView rv_image = helper.getView(R.id.rv_image);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_image.setLayoutManager(linearLayoutManager);
        List<HashMap<String,Object>> mList = new ArrayList<>();
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        PicAdapter picAdapter = new PicAdapter(R.layout.item_pic,mList);
        rv_image.setAdapter(picAdapter);




        RecyclerView rv_voice = helper.getView(R.id.rv_voice);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mContext);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_voice.setLayoutManager(linearLayoutManager1);


        RecyclerView rv_annex = helper.getView(R.id.rv_annex);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mContext);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_annex.setLayoutManager(linearLayoutManager2);




    }
}
