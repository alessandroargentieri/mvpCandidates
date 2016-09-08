package mawashi.alex.basicmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import mawashi.alex.basicmvp.R;
import mawashi.alex.basicmvp.presenter.Presenter;

public class ViewActivity extends AppCompatActivity {

    EditText emailEdit, nameEdit, surnameEdit;
    Spinner chooseCourse;
    ListView listView;
    String result="";

    //forse da sostituire con un richiamo ad application
    Presenter presenter = new Presenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_layout);

        emailEdit    = (EditText) findViewById(R.id.editEmail);
        nameEdit     = (EditText) findViewById(R.id.editName);
        surnameEdit  = (EditText) findViewById(R.id.editSurname);
        chooseCourse = (Spinner) findViewById(R.id.spinnerChoose);
        listView     = (ListView) findViewById(R.id.list);

      //  presenter = new Presenter(this);

        presenter.initLista(this, listView);

    }

    //button to add a Candidate
    public void Add(View v){
        presenter.addCandidate(emailEdit.getText().toString(),
                                        nameEdit.getText().toString(),
                                        surnameEdit.getText().toString());


    }



}
