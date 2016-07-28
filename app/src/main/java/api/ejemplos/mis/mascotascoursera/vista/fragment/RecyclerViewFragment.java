package api.ejemplos.mis.mascotascoursera.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import api.ejemplos.mis.mascotascoursera.R;
import api.ejemplos.mis.mascotascoursera.adapter.ContactoAdaptador;
import api.ejemplos.mis.mascotascoursera.pojo.Contacto;
import api.ejemplos.mis.mascotascoursera.presentador.IRecyclerViewFragmentPresenter;
import api.ejemplos.mis.mascotascoursera.presentador.RecyclerViewFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment  implements IRecyclerViewFragmentView{

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;




    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);


        // Acá le estoy pasando que quiero mostrar
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    /*

    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.forest_mushroom_icon,"pepe Grillo", "7777777","pepegrillo@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon,"Juan peroz", "22222222","juanperoz@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon,"Amalia Gomez", "55557777","AmaliaGomez@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.candy_icon,"Joana Lopez", "43334444443","Joanalopez@gmail.com", likes));

    }

    */



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm); // le estoy diciendo que reciclerView se comporte como linearlayoutManager
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity()); // una vez que lo cargue
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(ContactoAdaptador adaptador) { // anahi lo tiene como RV
        rvContactos.setAdapter(adaptador); //lo tengo que mostrar

    }
}
