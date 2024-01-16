public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, boolean ehAnonima, String emailDestinatario) {
        super(texto, emailRemetente, ehAnonima);
        this.emailDestinatario = emailDestinatario;

    }

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

//    public String getTextoCompletoAExibir() {
//        //TODO:
//    }
}
