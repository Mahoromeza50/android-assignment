package com.example.carinem.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.carinem.model.friend;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteAssetHelper {
    private static final String DB_NAME="carinedata.db";
private static final int DB_VER=1;
    public database(Context context){
    super(context,DB_NAME,null,DB_VER);
}
public List<friend>getfriends()
{
    SQLiteDatabase db=getReadableDatabase();
    SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
    String[] sqlselect={"id","name","address","phone","email"};
    String tableName="friend";
    qb.setTables(tableName);
    Cursor cursor=qb.query(db,sqlselect,null,null,null,null,null);
    List<friend>result=new ArrayList<>();
    if (cursor.moveToFirst())
    {
        do {
            friend friend=new friend();
            friend.setId(cursor.getInt(cursor.getColumnIndex("id")));
            friend.setName(cursor.getString(cursor.getColumnIndex("name")));
            friend.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            friend.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            friend.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            result.add(friend);
        }while (cursor.moveToNext());
    }
    return result;
}
public List<String>getNames()
{
    SQLiteDatabase db=getReadableDatabase();
    SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
    String[] sqlselect={"name"};
    String tableName="friend";
    qb.setTables(tableName);
    Cursor cursor=qb.query(db,sqlselect,null,null,null,null,null);
    List<String>result=new ArrayList<>();
    if (cursor.moveToFirst())
    {
        do {

            result.add(cursor.getString(cursor.getColumnIndex("name")));
        }while (cursor.moveToNext());
    }
    return result;
}
public List<friend>getfriendByname(String name)
{
    SQLiteDatabase db=getReadableDatabase();
    SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
    String[] sqlselect={"id","name","address","phone","email"};
    String tableName="friend";
    qb.setTables(tableName);
   // Cursor cursor=qb.query(db,sqlselect,"name = ?",new String[]{name},null,null,null);
    Cursor cursor=qb.query(db,sqlselect,"name like ?",new String[]{"&"+name+"&"},null,null,null);
    List<friend>result=new ArrayList<>();
    if (cursor.moveToFirst())
    {
        do {
            friend friend=new friend();
            friend.setId(cursor.getInt(cursor.getColumnIndex("id")));
            friend.setName(cursor.getString(cursor.getColumnIndex("name")));
            friend.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            friend.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            friend.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            result.add(friend);
        }while (cursor.moveToNext());
    }
    return result;
}
}
