package br.ada.petshop.models;

import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Porte;
import br.ada.petshop.models.Animais;

import java.time.LocalDate;
import java.util.List;


public class Cachorro extends Animais {

    public Cachorro() {
    }

    public Cachorro(String nome, LocalDate nascimento, String raca, Porte porte, Double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas, String observacoes) {
        super(nome, nascimento, raca, porte, peso, estado, vacinas, observacoes);
    }


}
