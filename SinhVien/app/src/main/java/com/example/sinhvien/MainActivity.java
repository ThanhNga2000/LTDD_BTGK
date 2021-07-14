package com.example.sinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.sinhvien.adapter.adapterchuyenmuc;
import com.example.sinhvien.adapter.adaptersp;
import com.example.sinhvien.adapter.adapterthongtin;
import com.example.sinhvien.database.databaseuser;
import com.example.sinhvien.model.Sanpham;
import com.example.sinhvien.model.Taikhoan;
import com.example.sinhvien.model.chuyenmuc;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView,listViewNew,listViewThongTin;
    DrawerLayout drawerLayout;
    String email;
    String tentaikhoan;
    ArrayList<Sanpham> SPArraylist;
    adaptersp adaptersp;
    databaseuser databaseuser;
    ArrayList<chuyenmuc> chuyenmucArrayList;
    ArrayList<Taikhoan> taikhoanArrayList;
    adapterthongtin adapterthongtin;
    adapterchuyenmuc  adapterchuyenmuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseuser = new databaseuser(this);
        //lấy dữ liệu ở màn đăng nhập
        Intent intentpq= getIntent();
        int i= intentpq.getIntExtra("phanquyen",0);
        int idd= intentpq.getIntExtra("idd",0);
        email= intentpq.getStringExtra("email");
        tentaikhoan= intentpq.getStringExtra("tentaikhoan");

        AnhXa();
        ActionViewFlipper();
        ActionBar();
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,MainNoiDung.class);
                String tens= SPArraylist.get(position).getTenSP();
                String gias= SPArraylist.get(position).getGia();
                String anhs= SPArraylist.get(position).getAnh();
                intent.putExtra("tensp",tens);
                intent.putExtra("gia",gias);
                //intent.putExtra("anh",anhs);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    if(i==2){

                    }
                    else {
                        Toast.makeText(MainActivity.this,"Bạn không có quyền đăng bài",Toast.LENGTH_SHORT).show();
                        Log.e("Đăng tin","Bạn không thể đăng bài");
                    }
                }
                else if(position==1){

                }
                //đăng xuất
                else if(position==2){
                    finish();
                }
            }
        });
    }
//thanh actionbar với toolbar
    private void ActionBar() {
        //hàm hỗ trợ toolbar
        setSupportActionBar(toolbar);
        //set nút cho actionbar:
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //tạo icon cho toobar
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    //phương thức cho chạy quảng cáo với Viewfilipper
    private void ActionViewFlipper() {
        //mảng chưa ảnh quảng cÓ
        ArrayList<String>mangquangcao= new ArrayList<>();
        mangquangcao.add("https://cdn.tgdd.vn/2021/07/campaign/1200-300-1200x300-9.png");
        mangquangcao.add("//cdn.tgdd.vn/2021/07/banner/sn-dh-830-300-830x300.png");
        mangquangcao.add("https://cdn.tgdd.vn/2021/07/banner/sn-dh-830-300-830x300.png");
        mangquangcao.add("https://cdn.tgdd.vn/2021/07/banner/830-300-830x300-5.png");
        //thực hiện vòng lặp
        for(int i=0;i<mangquangcao.size();i++){
            ImageView imageView= new ImageView(getApplicationContext());
            //sử dụng hàm thư viện PissCasso
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            //phương thức chỉnh tấm hình vừa khung quảng cáo
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //Thêm ảnh từ imageView vào viewFlipper
            viewFlipper.addView(imageView);
        }
        //thiết lập tự động chạy cho view quảng cáo
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        //gọi amination cho vào và ra
        Animation animation_slide_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slile_in_right);
        Animation animation_slide_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        //gọi animation vào view
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setInAnimation(animation_slide_out);
    }

    private void AnhXa() {
        toolbar= findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper= findViewById(R.id.viewflipper);
        listViewNew=findViewById(R.id.listviewnew);
        listView=findViewById(R.id.listviewmanhinhchinh);
        listViewThongTin=findViewById(R.id.listviewthongtin);
        navigationView=findViewById(R.id.navigationview);
        drawerLayout=findViewById(R.id.drawerlayout);

       SPArraylist= new ArrayList<>();
       Cursor cursor1 = databaseuser.getDataSanPham();
        while (cursor1.moveToNext()){
            int id= cursor1.getInt(0);
            String tensp= cursor1.getString(1);
            String gia= cursor1.getString(2);
            String anh= cursor1.getString(3);
            int id_tk= cursor1.getInt(4);
            SPArraylist.add(new Sanpham(id,tensp,gia,anh,id_tk));
            adaptersp= new adaptersp(getApplicationContext(),SPArraylist);
            listViewNew.setAdapter(adaptersp);
        }
        cursor1.moveToFirst();
        cursor1.close();

        //thông tin user
        taikhoanArrayList = new ArrayList<>();
        taikhoanArrayList.add(new Taikhoan(tentaikhoan,email));
        adapterthongtin= new adapterthongtin(this,R.layout.thongtinuser,taikhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);
    //chuyên mục :
        chuyenmucArrayList= new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng tin",R.drawable.ic_post_add));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin",R.drawable.ic_face));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất",R.drawable.ic_exit));
        adapterchuyenmuc= new adapterchuyenmuc(this,R.layout.chuyenmuc,chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }
//nạp menu tìm kiếm vào actionbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(MainActivity.this,Main_TimKiem.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}