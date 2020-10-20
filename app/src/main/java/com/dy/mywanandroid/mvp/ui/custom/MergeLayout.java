package com.dy.mywanandroid.mvp.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dy.mywanandroid.R;

/**
 * @author Administrator
 */
public class MergeLayout extends RelativeLayout {

    private TextView tvTitle;
    private ImageView ivSrc;
    private View vMerge;
    private TextView tvContentRight;
    public MergeLayout(Context context) {
        super(context);
    }

    public MergeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public MergeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_merge_item, this);
        tvTitle = view.findViewById(R.id.tv_title_merge);
        ivSrc = view.findViewById(R.id.iv_src);
        vMerge = view.findViewById(R.id.v_merge_bottom);
        tvContentRight = view.findViewById(R.id.tv_content_merge);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MergeLayout);
        tvTitle.setText(typedArray.getString(R.styleable.MergeLayout_tvTitle));
        tvContentRight.setText(typedArray.getString(R.styleable.MergeLayout_tvContentRight));
        tvContentRight.setTextColor(typedArray.getColor(R.styleable.MergeLayout_tvContentRightColor, Color.GRAY));
        ivSrc.setImageResource(typedArray.getResourceId(R.styleable.MergeLayout_ivSrc,R.mipmap.ic_launcher));
        if (typedArray.getBoolean(R.styleable.MergeLayout_v_visibility_bottom,false)){
            vMerge.setVisibility(GONE);
        }else {
            vMerge.setVisibility(VISIBLE);
        }
        if (typedArray.getBoolean(R.styleable.MergeLayout_iv_src_visibility,false)){
            ivSrc.setVisibility(GONE);
        }else {
            ivSrc.setVisibility(VISIBLE);
        }
        // TODO: 2020/9/1 0001 设置下划线左右边距
        LayoutParams linearParams =(LayoutParams) vMerge.getLayoutParams();
        linearParams.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,typedArray.getDimension(R.styleable.MergeLayout_v_bottom_left,0),getResources().getDisplayMetrics());
        linearParams.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,typedArray.getDimension(R.styleable.MergeLayout_v_bottom_right,0),getResources().getDisplayMetrics());
        vMerge.setLayoutParams(linearParams);
    }
}
