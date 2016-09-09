package mawashi.alex.basicmvp.presenter;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import mawashi.alex.basicmvp.model.CandidateDAO;
import mawashi.alex.basicmvp.model.CandidateModel;
import mawashi.alex.basicmvp.model.CourseDAO;
import mawashi.alex.basicmvp.model.CourseModel;

public class Presenter {

    public final String TAG_PRESENTER = "Presenter";
    ListView listView;
    ArrayList<CandidateModel> candidateArray = new ArrayList<>();
    CandidateAdapter candidateAdapter;

    Context context;

    CandidateDAO candidateDAO;// = new CandidateDAO(context);
    CourseDAO courseDAO;

    public Presenter(Context context){
        this.context = context;
        candidateDAO = new CandidateDAO(context);
        courseDAO = new CourseDAO(context);
    }


    public void addCandidate(String email, String name, String surname, String course){
        CandidateModel newCandidate = new CandidateModel(email, name, surname, course);
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
        // gestisco l'evento onClick sulla riga
      //  listView.setOnItemClickListener(new ListClickHandler());

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

    public void fillSpinner(Context c, Spinner spinner){
        ArrayList<CourseModel> corsi = new ArrayList<>();
        corsi = courseDAO.getCourses();
        Log.i(TAG_PRESENTER, "Lettura corsi dal DB andato a buon fine");

        ArrayList<String> course_name = new ArrayList<>();
        for(int i=0; i<corsi.size(); i++){
            CourseModel cm = corsi.get(i);
            course_name.add(cm.getCoursename());
        }
        Log.i(TAG_PRESENTER, "Lettura nomi corsi andato a buon fine");
        //la lista nello spinner non ha un formato custom, quindi non bisogna creare una classe adapter custom
        //gli passiamo direttamente l'arraylist completo e non vuoto da riempire, quindi non si usa .notifyDataSetChanged()
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, course_name);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }



    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int pos, long arg3) {
            final CandidateModel itemclicked = candidateArray.get(pos);
            Toast.makeText(context, itemclicked.getCourse(), Toast.LENGTH_LONG).show();
        }
    }

}
