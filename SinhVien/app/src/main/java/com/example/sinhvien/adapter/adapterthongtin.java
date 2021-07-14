package com.example.sinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sinhvien.R;
import com.example.sinhvien.model.Taikhoan;

import java.util.List;

public class adapterthongtin extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Taikhoan> taikhoanList;

    public adapterthongtin(Context context, int layout, List<Taikhoan> taikhoanList) {
        this.context = context;
        this.layout = layout;
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int getCount() {
        return taikhoanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(layout,null);
        TextView txtTenTaiKhoan=(TextView) convertView.findViewById(R.id.textName);
        TextView txtGmail=(TextView) convertView.findViewById(R.id.textgmail);
        Taikhoan taikhoan= taikhoanList.get(position);
        txtTenTaiKhoan.setText(taikhoan.getTentk());
        txtGmail.setText(taikhoan.getEmail());
        return convertView;
    }
}
