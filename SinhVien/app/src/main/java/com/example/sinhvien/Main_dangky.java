package com.example.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sinhvien.database.databaseuser;
import com.example.sinhvien.model.Taikhoan;

public class Main_dangky extends AppCompatActivity {
    EditText edtDKTaiKhoan,edtDKMatKhau,edtDKEmail;
    Button btnDKDangKy,btnDKDangNhap;
    databaseuser databaseuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangky);
        databaseuser= new databaseuser(this);
        AnhXa();
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan= edtDKTaiKhoan.getText().toString();
                String matkhau= edtDKMatKhau.getText().toString();
                String email= edtDKEmail.getText().toString();
                Taikhoan taikhoan1= CreateTaiKhoan();
                if(taikhoan.equals("")||matkhau.equals("")||email.equals("")){
                    Log.e("Thông báo","Bạn chưa nhập đầy đủ thông tin");
                }

                else {
                    databaseuser.AddTaiKhoan(taikhoan1);
                    Toast.makeText(Main_dangky.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDKDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent= new Intent(Main_dangky.this,Main_dangnhap.class);
                startActivity(intent);
            }
        });
    }
//phương thức tạo tài khoản
    private Taikhoan CreateTaiKhoan(){
        String taikhoan= edtDKTaiKhoan.getText().toString();
        String matkhau= edtDKMatKhau.getText().toString();
        String email= edtDKEmail.getText().toString();
        int pq= 1;
        Taikhoan tk= new Taikhoan(taikhoan,matkhau,email,pq);
        return tk;

    }
    private void AnhXa() {
        edtDKEmail= findViewById(R.id.dkemail);
        edtDKMatKhau= findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan= findViewById(R.id.dktaikhoan);
        btnDKDangKy= findViewById(R.id.dkdangky);
        btnDKDangNhap=findViewById(R.id.dktrove);
    }
}