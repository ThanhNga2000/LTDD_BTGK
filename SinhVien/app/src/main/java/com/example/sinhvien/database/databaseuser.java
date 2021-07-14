package com.example.sinhvien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sinhvien.Main_dangky;
import com.example.sinhvien.model.Taikhoan;

public class databaseuser extends SQLiteOpenHelper {

    private static String DATABASE_NAME= "APP.sqlite";
    //bảng tài khoản
    private static String TABLE_TAIKHOAN= "taikhoan";
    private static String ID_TAIKHOAN= "idtaikhoan";
    private static String TEN_TAIKHOAN= "tentaikhoan";
    private static String MAT_KHAU= "matkhau";
    private static String PHAN_QUYEN= "phanquyen";
    private static String EMAIL= "email";
    private static int VERSION =1;

    databaseuser data;

    //bảng sản phẩm :
    private static String TABLE_SANPHAM= "sanpham";
    private static String ID_SANPHAM= "idsanpham";
    private static String TEN_SANPHAM= "tieude";
    private static String GIA_SANPHAM= "gia";
    private static String ANH_SANPHAM= "anh";


    //context :
    private Context context;
    //tạo bảng tài khoản:
    private String SQLQuery= "CREATE TABLE "+TABLE_TAIKHOAN+"("+ID_TAIKHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TEN_TAIKHOAN+" TEXT UNIQUE,"
            +MAT_KHAU+" TEXT,"
            +EMAIL+" TEXT,"
            +PHAN_QUYEN+" INTEGER)";

    //tạo bảng sản phẩm:
    private String SQLQuery3= "CREATE TABLE "+TABLE_SANPHAM+"("+ID_SANPHAM+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TEN_SANPHAM+ " TEXT UNIQUE,"
            +GIA_SANPHAM+ " TEXT,"
            +ANH_SANPHAM+ " TEXT,"
            +ID_TAIKHOAN+ " INTEGER, FOREIGN KEY ("+ID_TAIKHOAN+") REFERENCES "+ TABLE_TAIKHOAN+"("+ID_TAIKHOAN+"))";


    //INSERT dữ liệu :
    private String SQLQuery1="INSERT INTO taikhoan values (null,'admin','admin','admin@gmail.com',2)";
    private String SQLQuery2="INSERT INTO taikhoan values (null,'Thanh Nga','ThanhNga','ThanhNga@gmail.com',1)";

    private String SQLQuery4="INSERT INTO sanpham values (null,'Galaxy A52','25.000.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/236085/TimerThumb/samsung-galaxy-a52-8gb-256gb.jpg',2)";
    private String SQLQuery5="INSERT INTO sanpham values (null,'iPhone 12','30.900.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/213033/TimerThumb/iphone-12-pro-max-(4).jpg',2)";
    private String SQLQuery6="INSERT INTO sanpham values (null,'Samsung Galaxy','6.200.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/234315/TimerThumb/samsung-galaxy-a32-4g-(1).jpg',2)";
    private String SQLQuery7="INSERT INTO sanpham values (null,'iPhone 12 64GB','22.990.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/213031/TimerThumb/iphone-12-(8).jpg',2)";
    private String SQLQuery8="INSERT INTO sanpham values (null,'Realme C25s','4.640.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/238483/realme-c25s-grey-7-600x600.jpg',2)";
    private String SQLQuery9="INSERT INTO sanpham values (null,'Samsung Galaxy','13.990.000 VNĐ','https://cdn.tgdd.vn/Products/Images/42/224859/TimerThumb/samsung-galaxy-s20-fan-edition-(2).jpg',2)";


    public databaseuser(@Nullable Context context) {
        super(context, DATABASE_NAME, null , VERSION);
    }
    //thực hiện các câu truy vấn không trả về kết quả
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        //sanpham

        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //phương thức lấy tất cả tài khoản
    public Cursor getDataTaiKhoan(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res= db.rawQuery("Select * from "+TABLE_TAIKHOAN,null);
        return res;
    }
    //phương thức add tài khoản vào dl
    public void AddTaiKhoan(Taikhoan taikhoan){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(TEN_TAIKHOAN,taikhoan.getTentk());
        values.put(MAT_KHAU,taikhoan.getMk());
        values.put(EMAIL,taikhoan.getEmail());
        values.put(PHAN_QUYEN,taikhoan.getPhanquyen());
        db.insert(TABLE_TAIKHOAN,null,values);

        //đóng lại
        db.close();
        Log.e("ADD TK","TC");
    }
    //lấy 5 sản phẩm mới nhất
    public Cursor getDataSanPham(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res= db.rawQuery(" SELECT  *  FROM " + TABLE_SANPHAM + " ORDER BY " + ID_SANPHAM + " DESC LIMIT  5",null);
        //Cursor res= db.rawQuery("Select * from "+TABLE_SANPHAM,null);
        return res;
    }
}
