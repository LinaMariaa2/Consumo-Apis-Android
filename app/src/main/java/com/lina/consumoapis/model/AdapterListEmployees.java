package com.lina.consumoapis.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lina.consumoapis.R;
import java.util.ArrayList;

// Un Adapter conecta los datos con las vistas gráficas en este caso los empleados los mostrara en el list view
public class AdapterListEmployees extends BaseAdapter {

    Context context;
    ArrayList<Employees> list;

    public AdapterListEmployees(Context context, ArrayList<Employees> list) {
        this.context = context;
        this.list = new ArrayList<>(list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView tvName, tvSalary;

        //Esto infla el layout XML
        view = LayoutInflater.from(context).inflate(R.layout.item_list_employees, viewGroup, false);

        /*Busaca los elementos */
        tvName = view.findViewById(R.id.tvNameItem);
        tvSalary = view.findViewById(R.id.tvSalaryItem);

        /* Fill views inserta los datos en la vista */
        tvName.setText(list.get(i).getEmployee_name());
        tvSalary.setText(String.valueOf(list.get(i).getEmployee_salary()));

        return view;
    }
}
