package movil.salt.dbsugarorm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import movil.salt.dbsugarorm.Entidades.Cereal;

/**
 * Created by pc on 26/07/2015.
 */
public class AlertAgregar extends DialogFragment {

    EditText nombre,gramos;
    MainActivity mainActivity;
    String tituloAlerta = "Agregar";

    public void init(MainActivity mainActivity, String tituloAlerta) {
        this.mainActivity = mainActivity;
        this.tituloAlerta = tituloAlerta;
    }

    public AlertAgregar() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(tituloAlerta);
        View v = View.inflate(getActivity(),R.layout.alert_agregar,null);
        builder.setView(v);
        //LayoutInflater inflater = getActivity().getLayoutInflater();
        //builder.setView(inflater.inflate(R.layout.alert_agregar, null));

        nombre = (EditText) v.findViewById(R.id.A_nombre);
        gramos = (EditText) v.findViewById(R.id.A_gramos);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                if (tituloAlerta == MainActivity.TITULO_ALERTA_AGREGAR)
                {

                Cereal cereal = new Cereal();

                if (nombre.getText().toString() != null && gramos.getText().toString() != null) {
                    cereal.setNombre(nombre.getText().toString());
                    cereal.setGramos(gramos.getText().toString());

                    cereal.save();

                    mainActivity.CargarItems();

                    Toast.makeText(getActivity(), "Cereal agragado", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Edit Textx nulos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mainActivity.EditarCereal(nombre.getText().toString(),gramos.getText().toString());
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        return builder.create();




    }
}
