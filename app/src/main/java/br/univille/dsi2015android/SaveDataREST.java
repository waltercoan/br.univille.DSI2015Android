package br.univille.dsi2015android;

import br.univille.dao.Produto;
import retrofit.RestAdapter;
import android.os.AsyncTask;
import java.util.List;


public class SaveDataREST<E> extends AsyncTask<Object, Void, Boolean>{

	@Override
	protected Boolean doInBackground(Object... params) {
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(params[0].toString())
			.build();
		Glassfish service  = restAdapter.create(Glassfish.class);

        //coloque aqui um IF para cada metodo
        if(params[1].equals("saveProduto"))
            service.saveProduto((Produto)params[2]);

		return Boolean.TRUE;
	}


}
