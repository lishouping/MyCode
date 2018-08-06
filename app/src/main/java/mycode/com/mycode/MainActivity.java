package mycode.com.mycode;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import io.reactivex.functions.Consumer;
import mycode.com.mycode.greendao.gen.UserInfoDao;

public class MainActivity extends AppCompatActivity {
    private int mHeight;//伸展高度
    private LoginDailogFragment loginDailogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            Log.d("--------", "已同意");
                        }
                    }
                });

        final LinearLayout linearLa = findViewById(R.id.lin_top);
        LinearLayout linearLa1 = findViewById(R.id.lin_bottom);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(R.drawable.button_play_animation);
        final AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) image).getDrawable();


        final Button btn_show = findViewById(R.id.btn_show);
        final Button btn_end = findViewById(R.id.btn_end);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animationDrawable.start(); //开始的时候调用

                HiddenAnimUtils.newInstance(MainActivity.this, linearLa, btn_show, 200).toggle();
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                animationDrawable.stop();
                loginDailogFragment = new LoginDailogFragment();
                loginDailogFragment.show(getFragmentManager(), "login");
            }
        });

        Button btn_start_service = findViewById(R.id.btn_start_service);
        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoDao userInfoDao = MyApplication.getInstances().getDaoSession().getUserInfoDao();
                UserInfo userInfo = new UserInfo();
                userInfo.setName("aaaaaaaaa");
                userInfoDao.insert(userInfo);
            }
        });


        Button btn_stop_service = findViewById(R.id.btn_stop_service);
        btn_stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoDao userInfoDao = MyApplication.getInstances().getDaoSession().getUserInfoDao();
                List<UserInfo> list = userInfoDao.loadAll();

                for (int i = 0; i <list.size() ; i++) {
                    Log.d("-------",list.get(i).getId()+"");
                }
                UserInfo userInfo = list.get(0);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ReplayActivity.class);
                intent.putExtra("userInfo",userInfo);
                startActivity(intent);

                Snackbar.make(btn_end, list.get(0).getId() + "" + list.get(0).getName(), Snackbar.LENGTH_LONG)
                        .setAction("这是Action", new View
                        .OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("--------", "sssss");
                    }
                }).show();
            }
        });


    }

    private void openAnim(View v) {
        v.setVisibility(View.VISIBLE);
        ValueAnimator animator = createDropAnimator(v, 0, mHeight);
        animator.start();
    }

    private ValueAnimator createDropAnimator(final View v, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                int value = (int) arg0.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.height = value;
                v.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
}
