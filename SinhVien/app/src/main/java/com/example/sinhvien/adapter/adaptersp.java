package com.example.sinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sinhvien.R;
import com.example.sinhvien.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adaptersp extends BaseAdapter {
    private Context context;
    private ArrayList<Sanpham> listSanpham;

    public adaptersp(Context context, ArrayList<Sanpham> listSanpham) {
        this.context = context;
        this.listSanpham = listSanpham;
    }

    @Override
    public int getCount() {
        return listSanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return listSanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txtTenSP;
        TextView txtGiaSP;
        ImageView imgSP;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder= null;
        viewHolder= new ViewHolder();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView= inflater.inflate(R.layout.newsp,null);
        viewHolder.txtTenSP= convertView.findViewById(R.id.textviewtenspnew);
        viewHolder.txtGiaSP= convertView.findViewById(R.id.textviewgiasp);
        viewHolder.imgSP= convertView.findViewById(R.id.imgNewSP);
        convertView.setTag(viewHolder);
        Sanpham sanpham= (Sanpham)getItem(position);
        viewHolder.txtTenSP.setText(sanpham.getTenSP());
        viewHolder.txtGiaSP.setText(sanpham.getGia());
        Picasso.get().load(sanpham.getAnh()).placeholder(R.drawable.ic_download).error(R.drawable.ic_image).into(viewHolder.imgSP);
        return convertView;
    }
}
