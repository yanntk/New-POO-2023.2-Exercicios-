public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean ehAnonima;

    public Mensagem(String texto, String emailRemetente, boolean ehAnonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.ehAnonima = ehAnonima;

    }

    public Mensagem() {
        this("", "", true);

    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return this.emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean isEhAnonima() {
        return this.ehAnonima;
    }

    public void setEhAnonima(boolean ehAnonima) {
        this.ehAnonima = ehAnonima;
    }
}
