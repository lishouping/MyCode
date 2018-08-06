package mycode.com.mycode;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReplayActivity extends AppCompatActivity {
    private RecyclerView mRvReplay;
    private ReplayAdapter mReplayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);


        UserInfo userInfo = getIntent().getParcelableExtra("userInfo");

        Log.d("[--------",userInfo.getId()+"");

        initView();
    }
    private void initView(){
        mRvReplay = findViewById(R.id.rv_replay);
        mRvReplay.setLayoutManager(new LinearLayoutManager(this));
        List<HashMap<String,Object>> mList = new ArrayList<>();
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mList.add(new HashMap<String, Object>());
        mReplayAdapter = new ReplayAdapter(R.layout.item_replay,mList);
        mRvReplay.setAdapter(mReplayAdapter);




    }

}
