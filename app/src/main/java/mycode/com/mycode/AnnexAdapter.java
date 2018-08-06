package mycode.com.mycode;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
public class AnnexAdapter extends BaseQuickAdapter<HashMap<String,Object>,BaseViewHolder>{
    public AnnexAdapter(int layoutResId, @Nullable List<HashMap<String, Object>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, Object> item) {

        // 添加注释
        
    }
}
