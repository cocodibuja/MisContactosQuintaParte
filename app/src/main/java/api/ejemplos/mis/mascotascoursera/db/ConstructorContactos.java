package api.ejemplos.mis.mascotascoursera.db;

import android.content.Context;

import java.util.ArrayList;

import api.ejemplos.mis.mascotascoursera.R;
import api.ejemplos.mis.mascotascoursera.pojo.Contacto;

/**
 * Created by nicopro on 28/7/16.
 */
public class ConstructorContactos {

    private Context context;

    public ConstructorContactos( Context context) {
        this.context = context;
    }

    // no importa de donde obtenga los datos tienen que venir en un ArrayList

    public ArrayList<Contacto> obtenerDatos(){

        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.forest_mushroom_icon,"pepe Grillo", "7777777","pepegrillo@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon,"Juan peroz", "22222222","juanperoz@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon,"Amalia Gomez", "55557777","AmaliaGomez@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.candy_icon,"Joana Lopez", "43334444443","Joanalopez@gmail.com", 9));

        return contactos;

    }
}
