package api.ejemplos.mis.mascotascoursera.vista.fragment;

import java.util.ArrayList;

import api.ejemplos.mis.mascotascoursera.adapter.ContactoAdaptador;
import api.ejemplos.mis.mascotascoursera.pojo.Contacto;

/**
 * Created by nicopro on 27/7/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRecyclerView(ContactoAdaptador adaptador);
}
