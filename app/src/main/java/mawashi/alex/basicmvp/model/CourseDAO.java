package mawashi.alex.basicmvp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

import java.util.ArrayList;

/**
 * Insert and get from DB the data
 */
public class CourseDAO implements CourseDAOInterface{

    String TAG_COURSE_DAO = "CourseDAO";
    Context context;

    public CourseDAO(Context context){
        //createDB
        context = context;
        DBModel.create(context);
    }

    @Override
    public void InsertCourse(CourseModel c){
        String Query = "INSERT INTO courses VALUES ('" + c.getCoursename() + "','" + c.getDescription() + "')";
        try {
            DBModel.insert_query(context, Query);
        }catch(SQLException sql_e){
            Log.i(TAG_COURSE_DAO, sql_e.toString());
        }catch(Exception e){
            Log.i(TAG_COURSE_DAO, e.toString());
        }
    }

    @Override
    public ArrayList<CourseModel> getCourses(){
        ArrayList<CourseModel> result = null;
        try {
            Cursor result_select = DBModel.select_query(context, "SELECT * FROM courses");
            for(int i=0; i<result_select.getCount(); i++){
                result_select.moveToPosition(i);
                CourseModel cm = new CourseModel();
                cm.setCoursename(result_select.getString(result_select.getColumnIndex("course_name")));
                cm.setDescription(result_select.getString(result_select.getColumnIndex("description")));
                result.add(cm);
            }
        }catch(SQLException sql_e){
            result.add(new CourseModel("none", "none"));
            Log.i(TAG_COURSE_DAO, sql_e.toString());
        }catch(Exception e){
            result.add(new CourseModel("none", "none"));
            Log.i(TAG_COURSE_DAO, e.toString());
        }

        return result;
    }
}
