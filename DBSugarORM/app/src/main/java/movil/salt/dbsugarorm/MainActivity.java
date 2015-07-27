package movil.salt.dbsugarorm;

import android.app.DialogFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import movil.salt.dbsugarorm.Adapters.CerealAdapter;
import movil.salt.dbsugarorm.Entidades.Cereal;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static final String TITULO_ALERTA_AGREGAR = "Agregar";
    public static final String TITULO_ALERTA_EDITAR = "Editar";

    FloatingActionButton btn_float;
    ListView list;
    List<Cereal> data;
    CerealAdapter adapter;
    Cereal cereal, cerealEdit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        btn_float = (FloatingActionButton) findViewById(R.id.float_btn);

        cereal = new Cereal();

        btn_float.setOnClickListener(this);

        registerForContextMenu(list);


       CargarItems();

    }


    @Override
    public void onClick(View v) {

        AlertAgregar alertAgregar = new AlertAgregar();
        alertAgregar.init(this, TITULO_ALERTA_AGREGAR);

        alertAgregar.show(getFragmentManager(), "texto no se");
    }

    public final void CargarItems()
    {
        data = cereal.listAll(Cereal.class);
        adapter = new CerealAdapter(data,this);
        list.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Cereal cereal = new Cereal();

        //cereales = new ArrayList<>();

        data = cereal.listAll(Cereal.class);


        switch (item.getItemId())
        {
            case R.id.menu_eliminar:

               // cereal = new Cereal();
                cereal = data.get(info.position);
                cereal.delete();
                CargarItems();
                Toast.makeText(this,"Eliminador",Toast.LENGTH_SHORT).show();

                break;
            case R.id.menu_editar:
                cerealEdit = data.get(info.position);
                AlertAgregar alertAgregar = new AlertAgregar();
                alertAgregar.init(this,TITULO_ALERTA_EDITAR);
                alertAgregar.show(getFragmentManager(),"nose");



                CargarItems();
                Toast.makeText(this,"Editar",Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onContextItemSelected(item);
    }

    public void EditarCereal(String nombre, String gramos)
    {
        cerealEdit.setGramos(gramos);
        cerealEdit.setNombre(nombre);
        cerealEdit.save();
        CargarItems();
    }
}
