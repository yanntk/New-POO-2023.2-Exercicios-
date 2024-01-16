import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    List<Mensagem> mensagens;
    Map<String, Amigo> amigosMap;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigosMap = new HashMap<>();

    }

    public void cadastrarAmigo(String nomeAmigo, String emailAmigo) {
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo, null);
        amigosMap.put(nomeAmigo, amigo);

    }

    public List<Mensagem> pesquisarMensagensAnonimas () {
        List<Mensagem> mensagensRetornar = new ArrayList<>();
        for(Mensagem m : this.mensagens) {
            if(m.isEhAnonima()) {
                mensagensRetornar.add(m);
            }
        }

        return mensagensRetornar;
    }

    public void configuraAmigoSecretoDe (String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        for(Amigo a : this.amigosMap.values()) {
            if(a.getEmail().equals(emailDaPessoa)) {
                a.setEmailAmigoSorteado(emailAmigoSorteado);
            } else {
                throw new AmigoInexistenteException("");
            }
        }
    }

    public List<Mensagem> pesquisaTodasAsMensagens () {
        return new ArrayList<>(this.mensagens);
    }

    public String pesquisaAmigoSecretoDe (String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo a : this.amigosMap.values()) {
            if(a.getEmail().equals(emailDaPessoa)) {
                String amigoSecreto = a.getEmailAmigoSorteado();
                if(amigoSecreto == null) {
                    throw new AmigoNaoSorteadoException("");
                } else {
                    return amigoSecreto;
                }
            }
        }
        throw new AmigoInexistenteException("");
    }

}
