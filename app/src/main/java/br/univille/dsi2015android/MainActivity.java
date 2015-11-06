package br.univille.dsi2015android;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.univille.dao.Produto;


public class MainActivity extends ActionBarActivity {
    private List<Produto> colProdutos = new ArrayList<Produto>();
    private ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProdutos = (ListView)findViewById(R.id.listaproduto);


        Log.i("dsi", "  iniciando... ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        new LoadDataREST<Produto>(){
            @Override
            protected void onPostExecute(List<Produto> produtos) {
                super.onPostExecute(produtos);
                updateList(produtos);
            }
        }.execute("http://192.168.104.216:8080/DSI2015WebRest/rest","getAllProdutos");

    }

    public void click_incluir(View o){
        Intent i = new Intent(this,IncluirProdutoActivity.class);
        startActivity(i);
    }


    public void updateList(List<Produto> colProdutos){
        this.colProdutos = colProdutos;

        Log.i("dsi", "voltou algo: " + colProdutos.size());
        ArrayAdapter<Produto> adapter =
                new ArrayAdapter<Produto>(this,android.R.layout.simple_list_item_1, colProdutos);

        listaProdutos.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
