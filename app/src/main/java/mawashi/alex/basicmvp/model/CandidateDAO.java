package mawashi.alex.basicmvp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

import java.util.ArrayList;


public class CandidateDAO implements CandidateDAOInterface {

    String TAG_CANDIDATE_DAO = "CandidateDAO";
    Context context;

    public CandidateDAO(Context c){
        context = c;
    }


    @Override
    public void InsertCandidate(CandidateModel c){
        String Query = "INSERT INTO candidates VALUES ('" + c.getEmail() + "','" + c.getName() + "','" + c.getSurname() + "')";
        try {
            DBModel.insert_query(context, Query);
        }catch(SQLException sql_e){
            Log.i(TAG_CANDIDATE_DAO, sql_e.toString());
        }catch(Exception e){
            Log.i(TAG_CANDIDATE_DAO, e.toString());
        }
    }

    @Override
    public ArrayList<CandidateModel> getCandidates(){
        ArrayList<CandidateModel> result = new ArrayList<>();
        try {
            Cursor result_select = DBModel.select_query(context, "SELECT * FROM candidates");
            for(int i=0; i<result_select.getCount(); i++){
                result_select.moveToPosition(i);
                CandidateModel cm = new CandidateModel();
                cm.setEmail(result_select.getString(result_select.getColumnIndex("email")));
                cm.setName(result_select.getString(result_select.getColumnIndex("name")));
                cm.setSurname(result_select.getString(result_select.getColumnIndex("surname")));
                result.add(cm);
            }
        }catch(SQLException sql_e){
            result.add(new CandidateModel("none", "none", "none"));
            Log.i(TAG_CANDIDATE_DAO, sql_e.toString());
        }catch(Exception e){
            result.add(new CandidateModel("none", "none", "none"));
            Log.i(TAG_CANDIDATE_DAO, e.toString());
        }

        return result;
    }
}
