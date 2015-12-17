package fucapi.br.pizzaria.bean;

import java.io.Serializable;

/**
 * Created by fernando on 12/12/15.
 */
public class UsuarioBean implements Serializable{

    private  String usunome;
    private  String ususenha;
    private  String usuemail;
    private  String usutipo;
    private  Long usuid;

    @Override
    public String toString() {
        return  usunome;
    }

    public String getUsunome() {
        return usunome;
    }

    public void setUsunome(String usunome) {
        this.usunome = usunome;
    }

    public String getUsusenha() {
        return ususenha;
    }

    public void setUsusenha(String ususenha) {
        this.ususenha = ususenha;
    }

    public String getUsuemail() {
        return usuemail;
    }

    public void setUsuemail(String usuemail) {
        this.usuemail = usuemail;
    }

    public String getUsutipo() {
        return usutipo;
    }

    public void setUsutipo(String usutipo) {
        this.usutipo = usutipo;
    }

    public Long getUsuid() {
        return usuid;
    }

    public void setUsuid(Long usuid) {
        this.usuid = usuid;
    }
}
