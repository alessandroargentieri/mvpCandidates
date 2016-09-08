package mawashi.alex.basicmvp.application;

import android.app.Application;
import android.widget.Toast;

import mawashi.alex.basicmvp.model.CandidateDAO;
import mawashi.alex.basicmvp.model.CandidateModel;
import mawashi.alex.basicmvp.model.CourseDAO;
import mawashi.alex.basicmvp.model.CourseModel;

/*
* This class starts before every Activity, then instantiate all presenter and data class which need to be unique*/
public class WholeApplication extends Application {

    CandidateDAO candidateDAO;
    CourseDAO courseDAO;

    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(WholeApplication.this, "Creation of the APP", Toast.LENGTH_LONG).show();
        candidateDAO = new CandidateDAO(getApplicationContext());
        courseDAO = new CourseDAO(this); //nel costruttore inizializza il DB
        CourseModel cm1 = new CourseModel("AndroidONE", "Corso di specializzazione beginner");
        CourseModel cm2 = new CourseModel("AndroidTWO", "Corso di specializzazione intermediate");
        CourseModel cm3 = new CourseModel("AndroidTHREE", "Corso di specializzazione advanced");
        courseDAO.InsertCourse(cm1);  //inserisce nel DB
        courseDAO.InsertCourse(cm2);
        courseDAO.InsertCourse(cm3);

        CandidateModel Cm1 = new CandidateModel("errico@gmail.com", "errico", "favenza");
        CandidateModel Cm2 = new CandidateModel("marika@gmail.com", "marika", "favenza");
        candidateDAO.InsertCandidate(Cm1);
        candidateDAO.InsertCandidate(Cm2);

    }


}
