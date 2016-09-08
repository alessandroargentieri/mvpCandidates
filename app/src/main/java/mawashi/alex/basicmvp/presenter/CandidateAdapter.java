package mawashi.alex.basicmvp.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mawashi.alex.basicmvp.R;
import mawashi.alex.basicmvp.model.CandidateModel;

/**
 * Created by alessandro.argentier on 08/09/2016.
 */
public class CandidateAdapter extends ArrayAdapter<CandidateModel> {

    private Context mContext;
    private ArrayList<CandidateModel> candidateModelArrayList;

    private String email;
    private String name;
    private String surname;


    public CandidateAdapter(Context mContext, ArrayList<CandidateModel> arrayList) {
        super(mContext, R.layout.custom_list_item, arrayList);
        this.mContext = mContext;
        this.candidateModelArrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //1. Create inflater
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //2. Get the row View from inflater
        View rowView = inflater.inflate(R.layout.custom_list_item, parent, false);
        //3. Get the elements of custom_list_item
        TextView email_txt = (TextView) rowView.findViewById(R.id.emailText);
        TextView name_txt = (TextView) rowView.findViewById(R.id.nameText);
        TextView surname_txt = (TextView) rowView.findViewById(R.id.surnameText);

        //4.fill the row
        CandidateModel item = candidateModelArrayList.get(position);
        email_txt.setText(item.getEmail());
        name_txt.setText(item.getName());
        surname_txt.setText(item.getSurname());
        //5.row built, it can be returned

        return rowView;
    }


}
