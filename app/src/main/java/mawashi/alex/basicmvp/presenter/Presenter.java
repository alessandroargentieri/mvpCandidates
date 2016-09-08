package mawashi.alex.basicmvp.presenter;


import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mawashi.alex.basicmvp.model.CandidateDAO;
import mawashi.alex.basicmvp.model.CandidateModel;

public class Presenter {
    ListView listView;
    ArrayList<CandidateModel> candidateArray = new ArrayList<>();
    CandidateAdapter candidateAdapter;

    Context context;

    CandidateDAO candidateDAO;// = new CandidateDAO(context);

    public Presenter(Context context){
        this.context = context;
        candidateDAO = new CandidateDAO(context);
    }


    public void addCandidate(String email, String name, String surname){
        CandidateModel newCandidate = new CandidateModel(email, name, surname);
       // CandidateDAO candidateDAO = new CandidateDAO();
        candidateDAO.InsertCandidate(newCandidate);

        fillCandidateList();
        candidateAdapter.notifyDataSetChanged();
    }


    public void initLista(Context c, ListView listView){
        //affidare la lista all'adapter
        this.listView = listView;
        candidateAdapter = new CandidateAdapter(c, candidateArray);
        listView.setAdapter(candidateAdapter);

        fillCandidateList();

        candidateAdapter.notifyDataSetChanged();

    }


    public void fillCandidateList(){
        candidateArray.clear();
        ArrayList<CandidateModel> result;// = new ArrayList<>();
        result = candidateDAO.getCandidates();
        for(int i=0; i<result.size();i++){
            candidateArray.add(result.get(i));
        }
    }


}
