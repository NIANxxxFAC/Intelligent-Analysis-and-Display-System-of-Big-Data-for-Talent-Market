package com.ll.tjpu.live.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ll.tjpu.live.Activity.ViewPagerItemBean;
import com.ll.tjpu.live.R;

import java.util.List;



public class MyPagerAdapter extends PagerAdapter {

    private List<ViewPagerItemBean> mData;
    private Context mContext;

    public MyPagerAdapter(List<ViewPagerItemBean> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.cardviewpager_item, container, false);
        ImageView imageView1 =  inflate.findViewById(R.id.img_card_item);
        TextView textView = inflate.findViewById(R.id.title_card_item);

        Glide.with(mContext).load(mData.get(position).getImg_url()).into(imageView1);
        textView.setText(mData.get(position).getTilte_text()+"");
        container.addView(inflate);
        return inflate;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
