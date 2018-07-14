package com.gamal.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gamal.inventoryapp.data.BookContract.BookEntry;

/**
 * @author gamal
 */
public class BookDbHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "library.db";
    private final static int DATABASE_VERSION = 1;

    public BookDbHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + BookContract.TABLE_NAME + " ("
                + BookEntry.COULMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BookEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL,"
                + BookEntry.COLUMN_PRICE + " TEXT NOT NULL,"
                + BookEntry.COLUMN_QUANTITY + " INTEGER NOT NULL,"
                + BookEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL,"
                + BookEntry.COULMN_SUPPLIER_PHONE_NUMBER + " TEXT NOT NULL" + " );";

        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
