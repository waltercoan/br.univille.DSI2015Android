package br.univille.dsi2015android;

import java.util.List;

import retrofit.RestAdapter;
import android.os.AsyncTask;

public class LoadDataREST<E> extends AsyncTask<Object, Void, List<E>>{
	List<E> list = null;
	
	@Override
	protected List<E> doInBackground(Object... params) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				    .setEndpoint(params[0].toString())
				    .build();
		Glassfish service  = restAdapter.create(Glassfish.class);
		
		//coloque aqui um IF para cada metodo 
		if(params[1].equals("getAllProdutos"))
			list = (List<E>) service.getAllProdutos();
		//if(params[1].equals("saveCliente"))
		//	service.save((Cliente)params[3]);
		
		return list;
	}
	
}
