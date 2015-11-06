package br.univille.dsi2015android;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.univille.dao.Produto;


public class IncluirProdutoActivity extends ActionBarActivity {
    private EditText txtCodigo, txtDesc, txtValor;
    private IncluirProdutoActivity me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir_produto);
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDesc = (EditText) findViewById(R.id.txtDesc);
        txtValor = (EditText) findViewById(R.id.txtValor);
        me = this;
    }
    public void confirmar_handle(View e){
        Produto prod = new Produto();
        prod.setDescricao(txtDesc.getText().toString());
        prod.setCodigo(Integer.parseInt(txtCodigo.getText().toString()));
        prod.setValor(Float.parseFloat(txtValor.getText().toString()));


        new SaveDataREST<Produto>() {
            protected void onPostExecute(Boolean result) {
                Toast.makeText(me, "Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        }.execute("http://192.168.104.216:8080/DSI2015WebRest/rest", "saveProduto", prod);
        finish();
    }
    public void cancelar_handle(View e){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_incluir_produto, menu);
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
