package br.ada.petshop.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private int id;
    private List<Animais> pets = new ArrayList<>();


    public Cliente(int id, List<Animais> pets) {
        this.id = id;
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animais> getPets() {
        return pets;
    }

    public void setPets(List<Animais> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome= " + this.getNome() +
                ", pets=" + pets +
                '}';
    }
}
