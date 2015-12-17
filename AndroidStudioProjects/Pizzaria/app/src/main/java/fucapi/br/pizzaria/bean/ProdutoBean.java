package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 14/12/15.
 */
public class ProdutoBean implements Serializable {

    private String descricao,qtd,valor;
    private Long proid;

    public ProdutoBean(){}

    public ProdutoBean(String descricao, String valor){
        this.descricao = descricao;
        this.valor=valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }
}
