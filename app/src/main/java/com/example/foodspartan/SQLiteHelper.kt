package com.example.foodspartan

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context): SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "student.db"
        private const val TBL_STUDENT = "tbl_student"
        private const val ID = "id"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblStudent = ("CREATE TABLE" + TBL_STUDENT + "("
                + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, "
                + EMAIL + " TEXT " + PASSWORD + " TEXT " + " )")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_STUDENT")
        onCreate(db)
    }

    fun insertStudent(std: StudentModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, std.id)
        contentValues.put(NAME, std.name)
        contentValues.put(EMAIL, std.email)
        contentValues.put(PASSWORD, std.password)

        val success = db.insert(TBL_STUDENT, null, contentValues)
        db.close()
        return success
    }

    fun getAllStudent(): ArrayList<StudentModel>{
        val stdList: ArrayList<StudentModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_STUDENT"
        val db = this.readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id:Int
        var name:String
        var email:String
        var password:String

        return stdList
    }
}