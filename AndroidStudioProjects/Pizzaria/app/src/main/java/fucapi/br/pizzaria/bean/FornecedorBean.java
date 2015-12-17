package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 14/12/15.
 */
public class FornecedorBean implements Serializable {

    private String cnpj,fone,razao;
    private Long idFor;

    @Override
    public String toString() {
        return  razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public Long getIdFor() {
        return idFor;
    }

    public void setIdFor(Long idFor) {
        this.idFor = idFor;
    }
}
