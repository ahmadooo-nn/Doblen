package com.mydoblen1.doblen.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION_NUMBER=1;
    public static final String DATABASE_NAME="Database.db";
    public static final String TABLE_NAME="MASTER";
    public static final String COL_ID="ID";
    public static final String COL_NAME_MASTER="NAMEMASTER";
    public static final String COL_PIC_MASTER="PICMASTER";
    public static final String COL_STAR="STAR";
    public static final String COL_PHONE_MASTER="PHONEMASTER";
    public static final String COL_WORK_MASTER="WORKMASTER";
    public static final String COL_LOCATION_MASTER="LOCATIONMASTER";
    public static final String COL_NUMBER_MASTER="NUMBERMASETR";

    public static final String CREATE_TABLE="create table "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_NAME_MASTER+" TEXT,"
            +COL_PIC_MASTER+" INTEGER,"+COL_STAR+" INTEGER,"+COL_PHONE_MASTER+" TEXT,"+COL_WORK_MASTER+" TEXT,"+COL_LOCATION_MASTER+" TEXT,"
            +COL_NUMBER_MASTER+" INTEGER)"  ;



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public Boolean insertData(String name_master,int pic_master,int star,String phon_master,String work_master,String location_master,
                              int number_master){
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_NAME_MASTER,name_master);
        cv.put(COL_PIC_MASTER,pic_master);
        cv.put(COL_STAR,star);
        cv.put(COL_PHONE_MASTER,phon_master);
        cv.put(COL_WORK_MASTER,work_master);
        cv.put(COL_LOCATION_MASTER,location_master);
        cv.put(COL_NUMBER_MASTER,number_master);
        Long result= mydb.insert(TABLE_NAME,null,cv);

        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData(){

        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor= mydb.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public Boolean updateData(String id,String name_master,int pic_master,int star,String phon_master,String work_master,String location_master,
                              int number_master){

        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_ID,id);
        cv.put(COL_NAME_MASTER,name_master);
        cv.put(COL_PIC_MASTER,pic_master);
        cv.put(COL_STAR,star);
        cv.put(COL_PHONE_MASTER,phon_master);
        cv.put(COL_WORK_MASTER,work_master);
        cv.put(COL_LOCATION_MASTER,location_master);
        cv.put(COL_NUMBER_MASTER,number_master);

        mydb.update(TABLE_NAME,cv,"ID = ?",new String[] {id});

        return true;
    }


}
