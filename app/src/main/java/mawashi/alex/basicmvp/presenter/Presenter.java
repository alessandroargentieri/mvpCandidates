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
        /////
      /*  candidateArray.clear();
        candidateArray.add(new CandidateModel("alessio@gioia.it", "alessio", "gioia"));
        candidateArray.add(new CandidateModel("michele@gioia.it", "michele", "gioia"));
        candidateArray.add(new CandidateModel("antonio@gioia.it", "antonio", "gioia"));
        candidateArray.add(new CandidateModel("lucia@gioia.it", "lucia", "gioia"));
        candidateArray.add(new CandidateModel("marica@gioia.it", "marica", "gioia"));
        candidateArray.add(new CandidateModel("debora@gioia.it", "debora", "gioia"));
        candidateArray.add(new CandidateModel("teo@gioia.it", "teo", "gioia"));
        candidateArray.add(new CandidateModel("elisa@gioia.it", "elisa", "gioia")); */
        /////
        for(int i=0; i<result.size();i++){
            candidateArray.add(result.get(i));
        }
    }


}
