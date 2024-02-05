package com.example.sqlite_database_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static  String DATABASE_NAME="db_revison";
    private static  int DATABASE_VERSION=1;
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);

    }

    //==================CREATING TABLE IN ON CREATE() AS IN REVISION NOTES ONCREATE() METHOD PRESENT IN THE SQLITEDATABASE WHICH IS USED TO INSERT DATA=====================

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_QUERY="CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,password TEXT,gender TEXT)";
        sqLiteDatabase.execSQL(TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS register");
        // onCreate(sqLiteDatabase);
    }


    public void RegisterUSerHelper(String name1,String email1,String password1,String gender1){

        //===============FIRST WE HAVE TO DEFINE THE TYPE OF DATABASE OR PROVIDE ACCESS SO THAT WE CAN WRITE INTO THE DATABASE==============
        //================WE HAVE CREATED THE 4 CLASS(SEE NOTES IN NOTEBOOK) WHICH IS USER_DEFINED_HELPER CLASS===============================
        // ===============SO WE HAVE TO APPLY getwritabledatabase()==========================================================================

        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name1);
        values.put("email",email1);
        values.put("password",password1);
        values.put("gender",gender1);

        sqLiteDatabase.insert("register",null,values);
        sqLiteDatabase.close();

    }
}
