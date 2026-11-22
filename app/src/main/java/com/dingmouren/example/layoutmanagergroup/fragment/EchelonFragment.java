package com.dingmouren.example.layoutmanagergroup.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dingmouren.example.layoutmanagergroup.MyApplication;
import com.dingmouren.example.layoutmanagergroup.R;
import com.dingmouren.layoutmanagergroup.echelon.EchelonLayoutManager;

import org.w3c.dom.Text;

/**
 * Created by 閽夋煇浜? * github: https://github.com/DingMouRen
 * email: naildingmouren@gmail.com
 * 姊舰甯冨眬
 */
public class EchelonFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private EchelonLayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_echelon,container,false);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        mLayoutManager = new EchelonLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter());

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private int[] icons = {R.mipmap.header_icon_1,R.mipmap.header_icon_2,R.mipmap.header_icon_3,R.mipmap.header_icon_4};
        private int[] bgs = {R.mipmap.bg_1,R.mipmap.bg_2,R.mipmap.bg_3,R.mipmap.bg_4};
        private String[] nickNames = {"宸﹁€宠繎蹇?,"鍑夐洦鍒濆","绋氫箙涔濇爛","鍗婄獥鐤忓奖"};
        private String[] descs = {
                "鍥炰笉鍘荤殑鍦版柟鍙晠涔?娌℃湁鏍圭殑杩佸緳鍙祦娴?..",
                "浜虹敓灏卞儚杩峰锛屾垜浠敤涓婂崐鐢熸壘瀵诲叆鍙ｏ紝鐢ㄤ笅鍗婄敓鎵惧鍑哄彛",
                "鍘熸潵鍦颁箙澶╅暱锛屽彧鏄浼氫竴鍦?,
                "涓嶆槸鏁呬簨鐨勭粨灞€涓嶅濂斤紝鑰屾槸鎴戜滑瀵规晠浜嬬殑瑕佹眰杩囧",
                "鍙兂浼橀泤杞韩锛屼笉鏂欏崕涓芥挒澧?
        };
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_echelon,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.icon.setImageResource(icons[position%4]);
            holder.nickName.setText(nickNames[position%4]);
            holder.desc.setText(descs[position%5]);
            holder.bg.setImageResource(bgs[position%4]);
        }

        @Override
        public int getItemCount() {
            return 60;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView icon;
            ImageView bg;
            TextView  nickName;
            TextView desc;
            public ViewHolder(View itemView) {
                super(itemView);
                icon = itemView.findViewById(R.id.img_icon);
                bg = itemView.findViewById(R.id.img_bg);
                nickName = itemView.findViewById(R.id.tv_nickname);
                desc = itemView.findViewById(R.id.tv_desc);

            }
        }
    }

}

