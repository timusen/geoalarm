package com.chadov.getalarm.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Timus on 14.11.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DbHelper.class.getSimpleName();

    /**
     * Имя файла базы данных
     */
    private static final String DATABASE_NAME = "geoalarm.db";

    /**
     * Версия базы данных. При изменении схемы увеличить на единицу
     */
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Вызывается при создании базы данных
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE " + DbContract.LocationEntry.TABLE_NAME + " ("
                + DbContract.LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DbContract.LocationEntry.COLUMN_RADIUS + " INTEGER NOT NULL DEFAULT 100, "
                + DbContract.LocationEntry.COLUMN_LATITUDE + " REAL NOT NULL DEFAULT 0, "
                + DbContract.LocationEntry.COLUMN_LONGITUDE + " REAL NOT NULL DEFAULT 0, "
                + DbContract.LocationEntry.COLUMN_ACTIVE + " INTEGER NOT NULL DEFAULT 0);";

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    /**
     * Вызывается при обновлении схемы базы данных
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_NAME);
        // Создаём новую таблицу
        onCreate(db);
    }
}