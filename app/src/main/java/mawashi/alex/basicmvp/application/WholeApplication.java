package mawashi.alex.basicmvp.application;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import mawashi.alex.basicmvp.model.CandidateDAO;
import mawashi.alex.basicmvp.model.CandidateModel;
import mawashi.alex.basicmvp.model.CourseDAO;
import mawashi.alex.basicmvp.model.CourseModel;
import mawashi.alex.basicmvp.model.DBModel;

/*
* This class starts before every Activity, then instantiate all presenter and data class which need to be unique*/
public class WholeApplication extends Application {

    public final String TAG_APPLICATION = "Application";
    CandidateDAO candidateDAO;
    CourseDAO courseDAO;
    DBModel DB;

    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(WholeApplication.this, "Creation of the APP", Toast.LENGTH_LONG).show();

        candidateDAO = new CandidateDAO(getApplicationContext());
        courseDAO = new CourseDAO(this);
        DB = new DBModel();
        DB.create(this);

        CourseModel cm1 = new CourseModel("AndroidONE", "Corso di specializzazione beginner");
        CourseModel cm2 = new CourseModel("AndroidTWO", "Corso di specializzazione intermediate");
        CourseModel cm3 = new CourseModel("AndroidTHREE", "Corso di specializzazione advanced");
        courseDAO.InsertCourse(cm1);  //inserisce nel DB
        courseDAO.InsertCourse(cm2);
        courseDAO.InsertCourse(cm3);
        Log.i(TAG_APPLICATION, "Creato il DB ed inseriti i corsi");

        CandidateModel Cm1 = new CandidateModel("errico@gmail.com", "errico", "favenza", "AndroidONE");
        CandidateModel Cm2 = new CandidateModel("marika@gmail.com", "marika", "favenza", "AndroidTWO");
        candidateDAO.InsertCandidate(Cm1);
        candidateDAO.InsertCandidate(Cm2);
        Log.i(TAG_APPLICATION, "Creato il DB ed inseriti i candidati");

    }


}
