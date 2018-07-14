package com.gamal.inventoryapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gamal.inventoryapp.data.BookContract;
import com.gamal.inventoryapp.data.BookContract.BookEntry;
import com.gamal.inventoryapp.data.BookDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BookEntry.COLUMN_PRODUCT_NAME, "demo data");
        contentValues.put(BookEntry.COLUMN_PRICE, "55");
        contentValues.put(BookEntry.COLUMN_QUANTITY, 13);
        contentValues.put(BookEntry.COLUMN_SUPPLIER_NAME, "supplier");
        contentValues.put(BookEntry.COULMN_SUPPLIER_PHONE_NUMBER, "phone_number");

        BookDbHelper bookDbHelper = new BookDbHelper(getApplicationContext());
        SQLiteDatabase sqldb = bookDbHelper.getWritableDatabase();

        long result = sqldb.insert(BookContract.TABLE_NAME, null, contentValues);

        if (result == -1) {
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "sucessfully inserted", Toast.LENGTH_SHORT).show();
        }

    }

    public void readData(View v) {
        Cursor cursor = query();
        if (cursor == null) {
            Toast.makeText(this, "Oops an error Occured", Toast.LENGTH_SHORT).show();
        } else {
            TextView textView = findViewById(R.id.data);
            StringBuilder data = new StringBuilder();
            while (cursor.moveToNext()) {
                data.append(cursor.getString(cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_NAME)));
                data.append("--->");
                data.append(cursor.getInt(cursor.getColumnIndex(BookEntry.COLUMN_PRICE)));
                data.append("\n");
            }
            textView.setText(data.toString());
            cursor.close();
        }
    }

    public Cursor query() {
        BookDbHelper bookDbHelper = new BookDbHelper(getApplicationContext());
        SQLiteDatabase sqldb = bookDbHelper.getReadableDatabase();
        String[] porjection = {BookEntry.COLUMN_PRODUCT_NAME, BookEntry.COLUMN_PRICE};
        String selection = BookEntry.COLUMN_PRICE + " >= ?";
        String[] selectionArgs = {" 55 "};

        Cursor cursor = sqldb.query(BookContract.TABLE_NAME,
                porjection,
                selection,
                selectionArgs,
                null,
                null,
                "");

        return cursor;
    }
}
