package com.hqs.savaeye.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqs.savaeye.R;
import com.hqs.savaeye.dialog.SelectLevelDialog;
import com.hqs.savaeye.view.RandomPoint;

/**
 * Created by Administrator on 2017/3/10.
 */
public class ModeOneFragment extends Fragment implements View.OnClickListener{

    private View view;
    private RandomPoint randomPoint;
    private TextView tvTitle;
    private TextView tvSetting;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mode_one,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        randomPoint = (RandomPoint) view.findViewById(R.id.random_point);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvSetting = (TextView) view.findViewById(R.id.tv_setting);
        tvSetting.setOnClickListener(this);
        tvTitle.setText("随机模式");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tv_setting:
                randomPoint.stop();
                createSelectLevelDialog();
                break;
        }
    }

    /**
     * 弹出对话框，选择相应的等级
     */
    private void createSelectLevelDialog() {
        final SelectLevelDialog dialog = new SelectLevelDialog(getActivity(),R.style.selectLevelDialogStyle);

        dialog.setOnLevelSelect(new SelectLevelDialog.OnLevelSelect() {
            @Override
            public void onSelectLevelOne() {
                randomPoint.setLevel(RandomPoint.levelOne);
                dialog.dismiss();
            }

            @Override
            public void onSelectLevelTwo() {
                randomPoint.setLevel(RandomPoint.levelTwo);
                dialog.dismiss();
            }

            @Override
            public void onSelectLevelThree() {
                randomPoint.setLevel(RandomPoint.levelThree);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
