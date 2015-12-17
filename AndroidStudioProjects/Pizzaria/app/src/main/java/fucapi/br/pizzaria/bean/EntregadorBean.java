package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 14/12/15.
 */
public class EntregadorBean implements Serializable {

    private String nome, fone;
    private Long idEnt;

    @Override
    public String toString() {
        return  nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Long getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(Long idEnt) {
        this.idEnt = idEnt;
    }
}
