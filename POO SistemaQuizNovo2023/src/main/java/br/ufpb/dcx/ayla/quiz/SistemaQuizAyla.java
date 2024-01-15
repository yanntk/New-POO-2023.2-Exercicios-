package br.ufpb.dcx.ayla.quiz;

import java.util.LinkedList;
import java.util.List;

public class SistemaQuizAyla implements SistemaQuiz{

    private List<Pergunta> perguntas;

    public SistemaQuizAyla(){
        this.perguntas = new LinkedList<>();
    }

    public SistemaQuizAyla(List<Pergunta> perguntas){
        this.perguntas = perguntas;
    }

    @Override
    public void cadastraPergunta(Pergunta p) {
        this.perguntas.add(p);
    }

    @Override
    public Pergunta sorteiaPergunta() throws  PerguntaNaoExisteException{
        if (this.perguntas.size()==0) {
            throw new PerguntaNaoExisteException("Não existe pergunta cadastrada");
        } else {
            int posicao = (int) (Math.random()*this.perguntas.size());
            return this.perguntas.get(posicao);
        }
    }

    public List<Pergunta> getTodasAsPerguntas(){
        return this.perguntas;
    }

}
