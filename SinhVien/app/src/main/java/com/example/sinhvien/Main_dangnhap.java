package com.example.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sinhvien.database.databaseuser;

public class Main_dangnhap extends AppCompatActivity {
    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap,btnDangKy;
    public static databaseuser databaseuser;
    //tạo đối tượng


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangnhap);
        AnhXa();
        //đối tượng data:
        databaseuser= new databaseuser(this);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main_dangnhap.this,Main_dangky.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentaikhoan= edtTaiKhoan.getText().toString();
                String matkhau= edtMatKhau.getText().toString();
                Cursor cursor= databaseuser.getDataTaiKhoan();//con trỏ lấy dữ liệu
                while (cursor.moveToNext()){
                  String datatentaikhoan= cursor.getString(1);
                  String datamatkhau= cursor.getString(2);
                  if(datatentaikhoan.equals(tentaikhoan)&& datamatkhau.equals(matkhau)){
                   //lấy dữ liệu phân quyền và id
                    int phanquyen= cursor.getInt(4)  ;
                    int idd= cursor.getInt(0);
                    String email= cursor.getString(3);
                    String tentk= cursor.getString(1);

                    Intent intent= new Intent(Main_dangnhap.this,MainActivity.class);
                    intent.putExtra("phanquyen",phanquyen);
                    intent.putExtra("idd",idd);
                    intent.putExtra("email",email);
                    intent.putExtra("tentaikhoan",tentk);
                    startActivity(intent);
                  }
                }
                //thực hiện trả về đầu
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }

    private void AnhXa() {
        edtMatKhau= findViewById(R.id.matkhau);
        edtTaiKhoan=findViewById(R.id.taikhoan);
        btnDangNhap= findViewById(R.id.dangnhap);
        btnDangKy=findViewById(R.id.dangky);
    }
}