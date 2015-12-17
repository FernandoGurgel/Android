package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 14/12/15.
 */
public class ClienteBean implements Serializable {

    private String telefone,nome,endereco;
    private Long idcli;

    @Override
    public String toString() {
        return  nome ;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdcli() {
        return idcli;
    }

    public void setIdcli(Long idcli) {
        this.idcli = idcli;
    }
}
