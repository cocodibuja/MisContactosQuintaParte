package api.ejemplos.mis.mascotascoursera.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import api.ejemplos.mis.mascotascoursera.pojo.Contacto;
import api.ejemplos.mis.mascotascoursera.DetalleContactoActivity;
import api.ejemplos.mis.mascotascoursera.R;

/**
 * Created by nicopro on 26/7/16.
 */
public class ContactoAdaptador extends RecyclerView.Adapter <ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;



    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {

        this.contactos= contactos;  //<--- ACA TENGO QUE RECIBIR LA LISTA QUE VOY A TRANSFERIR A LLM
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());

        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + "Likes");


        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();


                Intent intentAbrirContacto = new Intent(activity,DetalleContactoActivity.class);
                intentAbrirContacto.putExtra("nombre",contacto.getNombre());
                intentAbrirContacto.putExtra("telefono",contacto.getTelefono());
                intentAbrirContacto.putExtra("email",contacto.getEmail());
                activity.startActivity(intentAbrirContacto);
            }
        });


        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private ImageButton btnLike;
        private TextView tvLikes;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }

}
