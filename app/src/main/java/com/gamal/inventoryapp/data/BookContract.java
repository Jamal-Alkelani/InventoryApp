package com.gamal.inventoryapp.data;

import android.provider.BaseColumns;

public class BookContract {
    public final static String TABLE_NAME = "books";

    private BookContract() {
    }

    public final static class BookEntry implements BaseColumns {

        public final static String COULMN_ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "product_name";
        public final static String COLUMN_PRICE = "price";
        public final static String COLUMN_QUANTITY = "quantity";
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";
        public final static String COULMN_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";
    }
}
