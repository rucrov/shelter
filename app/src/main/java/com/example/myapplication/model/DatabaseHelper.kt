package com.example.myapplication.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MyDatabase"
        private const val DATABASE_VERSION = 1

        // Таблица пользователей
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val KEY_PHOTO = "photo"
        private const val KEY_NAME = "name"
        private const val KEY_JOB_TITLE = "job_title"
        private const val KEY_EXPERIENCE = "experience"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USERS_TABLE = ("CREATE TABLE $TABLE_USERS("
                + "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$KEY_PHOTO TEXT,"
                + "$KEY_NAME TEXT,"
                + "$KEY_JOB_TITLE TEXT,"
                + "$KEY_EXPERIENCE TEXT"
                + ")")
        db.execSQL(CREATE_USERS_TABLE)

        val values = ContentValues();
        values.put("id", 1);
        values.put("name", "Сыроежкин Аркадий Михайлович");
        values.put("job_title", "ветеринар");
        values.put("experience", "u",);
        values.put("photo", "gr",);
        db.insert(TABLE_USERS,null,values);
//        db.close()
        
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun addUser(user: User) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_PHOTO, user.photo)
        values.put(KEY_NAME, user.name)
        values.put(KEY_JOB_TITLE, user.jobTitle)
        values.put(KEY_EXPERIENCE, user.experience)
        db.insert(TABLE_USERS, null, values)
//        db.close()
    }

    fun getAllUsers(): List<User> {
        val userList = ArrayList<User>()
        val selectQuery = "SELECT * FROM $TABLE_USERS"
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val user = User(
                    cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                )
                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return userList
    }
//
//    fun getUserById(id: Long): User? {
//    val db = this.readableDatabase
//    val cursor: Cursor = db.query(
//        TABLE_USERS, arrayOf(
//            KEY_ID,
//            KEY_PHOTO,
//            KEY_NAME,
//            KEY_JOB_TITLE,
//            KEY_EXPERIENCE
//        ), "$KEY_ID=?", arrayOf(id.toString()), null, null, null, null
//    )
//    return if (cursor != null && cursor.moveToFirst()) {
//        val user = User(
//            cursor.getLong(cursor.getColumnIndex(KEY_ID)),
//            cursor.getString(cursor.getColumnIndex(KEY_PHOTO)),
//            cursor.getString(cursor.getColumnIndex(KEY_NAME)),
//            cursor.getString(cursor.getColumnIndex(KEY_JOB_TITLE)),
//            cursor.getString(cursor.getColumnIndex(KEY_EXPERIENCE))
//        )
//        cursor.close()
//        user
//    } else {
//        null
//    }
//}
}
