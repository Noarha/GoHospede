package application;

import java.time.LocalDate;

public class Hotel {

    private String nome;
    private String cidade;
    private LocalDate disponivelDe;
    private LocalDate disponivelAte;
    private double valor;
    private int quartos;

    public Hotel(String nome, String cidade,
                 LocalDate disponivelDe,
                 LocalDate disponivelAte,
                 double valor,
                 int quartos) {

        this.nome = nome;
        this.cidade = cidade;
        this.disponivelDe = disponivelDe;
        this.disponivelAte = disponivelAte;
        this.valor = valor;
        this.quartos = quartos;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public LocalDate getDisponivelDe() {
        return disponivelDe;
    }

    public LocalDate getDisponivelAte() {
        return disponivelAte;
    }

    public double getValor() {
        return valor;
    }

    public int getQuartos() {
        return quartos;
    }
}