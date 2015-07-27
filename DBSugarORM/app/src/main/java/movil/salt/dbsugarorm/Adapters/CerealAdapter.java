package movil.salt.dbsugarorm.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import movil.salt.dbsugarorm.Entidades.Cereal;
import movil.salt.dbsugarorm.R;

/**
 * Created by pc on 23/07/2015.
 */
public class CerealAdapter extends BaseAdapter {
    List<Cereal> data;
    Context context;

    public CerealAdapter(List<Cereal> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        if (convertView == null)
            v = View.inflate(context, R.layout.cerela_adapter,null);
        else
        v = convertView;

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView gramos = (TextView) v.findViewById(R.id.gramos);

        Cereal cereal = data.get(position);

        nombre.setText(cereal.getNombre());
        gramos.setText(cereal.getGramos());

        return v;
    }
}
