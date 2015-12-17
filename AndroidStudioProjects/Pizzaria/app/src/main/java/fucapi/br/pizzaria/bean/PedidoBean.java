package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 14/12/15.
 */
public class PedidoBean implements Serializable {

    private int idPro, idUser, idEntr;
    private String valor, nomecli, descripro;
    private Long idPedido;

    @Override
    public String toString() {
        return nomecli+"\n"+valor;
    }

    public String getDescripro() {
        return descripro;
    }

    public void setDescripro(String descripro) {
        this.descripro = descripro;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEntr() {
        return idEntr;
    }

    public void setIdEntr(int idEntr) {
        this.idEntr = idEntr;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
