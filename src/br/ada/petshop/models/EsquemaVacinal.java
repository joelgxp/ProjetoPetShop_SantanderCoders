package br.ada.petshop.models;

import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Porte;
import br.ada.petshop.enums.Vacinas;

import java.time.LocalDate;

public class EsquemaVacinal extends Animais{
    private LocalDate data;
    private Vacinas vacina;
    private String observacoes;

    public EsquemaVacinal(LocalDate data, Vacinas vacinas, String observacoes) {
        this.data = data;
        this.vacina = vacinas;
        this.observacoes = observacoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    @Override
    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "EsquemaVacinal{" +
                "data=" + data +
                ", vacina=" + vacina +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
