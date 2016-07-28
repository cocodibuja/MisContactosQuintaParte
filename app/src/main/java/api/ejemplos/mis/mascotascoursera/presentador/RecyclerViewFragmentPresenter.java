package api.ejemplos.mis.mascotascoursera.presentador;

import android.content.Context;

import java.util.ArrayList;

import api.ejemplos.mis.mascotascoursera.db.ConstructorContactos;
import api.ejemplos.mis.mascotascoursera.pojo.Contacto;
import api.ejemplos.mis.mascotascoursera.vista.fragment.IRecyclerViewFragmentView;

/**
 * Created by nicopro on 28/7/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter
{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosDeBaseDatos();
    }

    @Override
    public void obtenerContactosDeBaseDatos() {

        //vamos a hacerle creer que los datos los obtiene de la base de datos pero en realidad son dummy
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos(); //Nos devuelve una ArrayList de Contactos y lo guardo
        mostarContactosEnRecyclerView();
    }

    @Override
    public void mostarContactosEnRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();// Este es para mostrarlo y de que forma lo queremos mostrar

    }
}
