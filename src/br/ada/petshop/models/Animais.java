package br.ada.petshop.models;

import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Porte;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Animais {
    private String nome;
    private LocalDate nascimento;
    private String raca;
    private Porte porte;
    private Double peso;
    private EstadoAnimal estado;
    private List<EsquemaVacinal> vacinas;
    private String observacoes;

    public Animais() {
    }

    public Animais(String nome, LocalDate nascimento, String raca, Porte porte, Double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas, String observacoes) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.porte = porte;
        this.peso = peso;
        this.estado = estado;
        this.vacinas = vacinas;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<EsquemaVacinal> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<EsquemaVacinal> vacinas) {
        this.vacinas = vacinas;
    }

    @Override
    public String toString() {
        return "Animais{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", raca='" + raca + '\'' +
                ", porte=" + porte +
                ", peso=" + peso +
                ", estado=" + estado +
                ", vacinas=" + vacinas +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
