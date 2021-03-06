package mawashi.alex.basicmvp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alessandro.argentier on 08/09/2016.
 */
public class DBModel {
    static SQLiteDatabase db = null;
    public static String TAG_DBMODEL = "DBModel";

    public DBModel() {

    }

    static public void create(Context c){
        db = c.openOrCreateDatabase("CandidatesDB", c.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS candidates (email VARCHAR(100) PRIMARY KEY, name VARCHAR(50), surname VARCHAR(50), course VARCHAR(30))");
        db.execSQL("CREATE TABLE IF NOT EXISTS courses (course_name VARCHAR(30) PRIMARY KEY, description VARCHAR(200))");
        Log.i(TAG_DBMODEL, "Creato il DB e le tabelle candidates e courses");
    }

    static public void insert_query(Context c, String Query) throws SQLException{
        db = c.openOrCreateDatabase("CandidatesDB", c.MODE_PRIVATE, null);
        db.execSQL(Query);
        Log.i(TAG_DBMODEL, "Inserito record: " + Query);
    }

    static public Cursor select_query(Context c, String Query) throws SQLException, Exception{
       Cursor response;
        db = c.openOrCreateDatabase("CandidatesDB", c.MODE_PRIVATE, null);
        response = db.rawQuery(Query, null);
        Log.i(TAG_DBMODEL, "Cursor di risposta generato");
        if(response.getCount()<0 || response==null) {
            Log.i(TAG_DBMODEL, "Cursore nullo o con meno di zero elementi, lancio Exception");
            throw new Exception("No elements in DB");
        }
        return response;
    }

}
