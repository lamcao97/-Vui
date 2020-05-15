package ptithcm.edu.vn.dovui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ToanAdapter extends ArrayAdapter<Toan> {
    private Context context;
    private int resource;

    private ArrayList<Toan> arrToan;
    public ToanAdapter( Context context, int resource, ArrayList<Toan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrToan = objects;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row_ketqua_toanhoc,parent,false);
        TextView txt_daban = convertView.findViewById(R.id.dacuaban);
        TextView txt_dadung = convertView.findViewById(R.id.dadung);

        return convertView;
    }
}
