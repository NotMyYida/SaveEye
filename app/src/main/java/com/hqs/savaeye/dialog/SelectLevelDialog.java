package com.hqs.savaeye.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hqs.savaeye.R;

/**
 * Created by Administrator on 2017/3/10.
 * 选择等级的Dialog
 */
public class SelectLevelDialog extends Dialog {

    private Button btnLevelOne;
    private Button btnLevelTwo;
    private Button btnLevelThree;
    public OnLevelSelect mOnLevelSelect;

    public interface OnLevelSelect{
        void onSelectLevelOne();
        void onSelectLevelTwo();
        void onSelectLevelThree();
    }

    public SelectLevelDialog(Context context) {
        super(context);
        init();
    }


    public SelectLevelDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }



    private void init() {
        setContentView(R.layout.dialog_select_level);
        btnLevelOne = (Button) findViewById(R.id.level_one);
        btnLevelTwo = (Button) findViewById(R.id.level_two);
        btnLevelThree = (Button) findViewById(R.id.level_three);

        setCanceledOnTouchOutside(true);

        btnLevelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnLevelSelect.onSelectLevelOne();
            }
        });

        btnLevelTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnLevelSelect.onSelectLevelTwo();
            }
        });

        btnLevelThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnLevelSelect.onSelectLevelThree();
            }
        });

    }


    public void setOnLevelSelect(OnLevelSelect onLevelSelect){
        this.mOnLevelSelect = onLevelSelect;
    }


}
