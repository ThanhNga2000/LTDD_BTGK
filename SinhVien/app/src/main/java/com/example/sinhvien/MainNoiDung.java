package com.example.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainNoiDung extends AppCompatActivity {
    TextView textviewtenchitietsanpham,textviewgiachitietsanpham,txtmota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_noi_dung);
        textviewgiachitietsanpham= findViewById(R.id.textviewgiachitietsanpham);
        textviewtenchitietsanpham= findViewById(R.id.textviewtenchitietsanpham);
        txtmota=findViewById(R.id.textviewmotachitietsanpham);
        Intent intent= getIntent();
        String tentruyen= intent.getStringExtra("tensp");
        String noidung= intent.getStringExtra("gia");

        textviewtenchitietsanpham.setText(tentruyen);
        textviewgiachitietsanpham.setText(noidung);
        txtmota.setText(getResources().getString(R.string.message));
        //cuộn nội dung cấu hình
        txtmota.setMovementMethod(new ScrollingMovementMethod());


    }
}