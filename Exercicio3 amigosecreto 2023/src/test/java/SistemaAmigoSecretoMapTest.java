import org.junit.Assert;
import org.junit.Test;

public class SistemaAmigoSecretoMapTest {
    SistemaAmigoMap sistemaAmigoMap = new SistemaAmigoMap();

    @Test
    public void testCadastrarAmigo() {
        Amigo amigo = new Amigo("Lucas", "lucas@email", "felipe@email");
        sistemaAmigoMap.amigosMap.put(amigo.getNome(), amigo);
        Assert.assertTrue(sistemaAmigoMap.amigosMap.containsKey("Lucas") && sistemaAmigoMap.amigosMap.get("Lucas") != null);
    }

    @Test
    public void testConfigurarAmigo() {
        sistemaAmigoMap.cadastrarAmigo("Lucas", "lucas@email");
        sistemaAmigoMap.cadastrarAmigo("felipe", "felipe@email");
        try {
            sistemaAmigoMap.configuraAmigoSecretoDe("lucas@email", "felipe@email");
            Assert.assertEquals("felipe@email", sistemaAmigoMap.amigosMap.get("Lucas").getEmailAmigoSorteado());
        } catch (AmigoInexistenteException e) {
            System.out.println("Não deveria lançar exceção");
        }
    }

    @Test
    public void testPesquisaAmigoSecreto() {
        sistemaAmigoMap.cadastrarAmigo("Lucas", "lucas@email");
        try {
            sistemaAmigoMap.configuraAmigoSecretoDe("lucas@email", "felipe@email");
        } catch (AmigoInexistenteException e) {
            System.out.println("não deveria lançar excessão");
        }

        try {
            sistemaAmigoMap.pesquisaAmigoSecretoDe("lucas@email");
            Assert.assertEquals("felipe@email", sistemaAmigoMap.amigosMap.get("Lucas").getEmailAmigoSorteado());
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println("não deveria lançar excessão");
        }
    }

    @Test
    public void testPesquisarTodasAsMensagens() {
        sistemaAmigoMap.pesquisaTodasAsMensagens();

    }

    @Test
    public void testPesquisarMensagensAnonimas() {
        sistemaAmigoMap.pesquisarMensagensAnonimas();

    }
}
