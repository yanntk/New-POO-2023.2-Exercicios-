package br.ufpb.dcx.ayla.quiz;

import java.util.List;

public interface SistemaQuiz {
    void cadastraPergunta(Pergunta p);
    Pergunta sorteiaPergunta() throws PerguntaNaoExisteException;

    List<Pergunta> getTodasAsPerguntas();
}
