package br.univille.dsi2015android;

        import java.util.List;

import br.univille.dao.Produto;
        import retrofit.http.Body;
        import retrofit.http.GET;
        import retrofit.http.POST;

/**
 * Created by Walter on 30/10/2015.
 */
public interface Glassfish {
    @GET("/produto/all")
    List<Produto> getAllProdutos();
    @POST("/produto/save")
    void saveProduto(@Body Produto produto);
    
}
