package ptithcm.edu.vn.dovui.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ptithcm.edu.vn.dovui.Module.diem;
import ptithcm.edu.vn.dovui.R;

public class DiemAdapter extends ArrayAdapter<diem> {

    private Context context;
    private int resource;
    private ArrayList<diem> arrResult;


    public DiemAdapter(Context context, int resource, ArrayList<diem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrResult = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_xemdiem, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.tv_ID = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tv_ten= (TextView) convertView.findViewById(R.id.tv_ten);
            viewHolder.tv_diemtoan = (TextView) convertView.findViewById(R.id.tv_diemtoan);
            viewHolder.tv_diemdongvat= (TextView) convertView.findViewById(R.id.tv_diemdongvat);
            viewHolder.tv_diemamnhac = (TextView) convertView.findViewById(R.id.tv_diemamnhac);
            viewHolder.tv_diemiq= (TextView) convertView.findViewById(R.id.tv_diemiq);
            viewHolder.tv_diemthienvan = (TextView) convertView.findViewById(R.id.tv_diemthienvan);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }



        diem result = arrResult.get(position);

        viewHolder.tv_ID.setText(""+result.getMaDiem());
        viewHolder.tv_ten.setText(result.getTen());
        viewHolder.tv_diemtoan.setText(""+result.getDiemtoan());
        viewHolder.tv_diemdongvat.setText(""+result.getDiemdongvat());
        viewHolder.tv_diemamnhac.setText(""+result.getDiemamnhac());
        viewHolder.tv_diemiq.setText(""+result.getDiemiq());
        viewHolder.tv_diemthienvan.setText(""+result.getDiemthienvan());
        return convertView;

    }

    public class ViewHolder{

        TextView tv_ID;
        TextView tv_ten;
        TextView tv_diemtoan;
        TextView tv_diemdongvat;
        TextView tv_diemamnhac;
        TextView tv_diemiq;
        TextView tv_diemthienvan;
//
//        convertView = LayoutInflater.from(context).inflate(R.layout.row_xemdiem,parent,false);
//
//        TextView makh = convertView.findViewById(R.id.tv_id);
//        TextView tenkh = convertView.findViewById(R.id.tv_ten);
//        TextView diemtoan = convertView.findViewById(R.id.tv_diemtoan);
//        TextView diemdongvat = convertView.findViewById(R.id.tv_diemdongvat);
//        TextView diemamnhac = convertView.findViewById(R.id.tv_diemamnhac);
//        TextView diemiq = convertView.findViewById(R.id.tv_diemiq);
//        TextView diemthienvan = convertView.findViewById(R.id.tv_diemthienvan);
//
//        makh.setText(arrResult.get(position).getMaDiem()+"");
//        tenkh.setText(arrResult.get(position).getTen());
//        diemtoan.setText(arrResult.get(position).getDiemtoan());
//        diemdongvat.setText(arrResult.get(position).getDiemdongvat());
//        diemamnhac.setText(arrResult.get(position).getDiemamnhac());
//        diemiq.setText(arrResult.get(position).getDiemiq());
//        diemthienvan.setText(arrResult.get(position).getDiemthienvan());
//        return convertView;

    }
}
