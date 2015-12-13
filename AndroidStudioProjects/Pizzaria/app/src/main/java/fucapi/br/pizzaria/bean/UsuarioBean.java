package fucapi.br.pizzaria.bean;

/**
 * Created by fernando on 12/12/15.
 */
public class UsuarioBean {

    private  String usunome;
    private  String ususenha;
    private  String usuemail;
    private  String usutipo;
    private  long usuid;

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

    public long getUsuid() {
        return usuid;
    }

    public void setUsuid(long usuid) {
        this.usuid = usuid;
    }
}
