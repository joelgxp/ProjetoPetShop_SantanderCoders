package br.ada.petshop;

import br.ada.petshop.VO.ResponseVO;
import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Higiene;
import br.ada.petshop.enums.Porte;
import br.ada.petshop.enums.Vacinas;
import br.ada.petshop.models.Animais;
import br.ada.petshop.models.Cachorro;
import br.ada.petshop.models.Cliente;
import br.ada.petshop.models.Gato;
import br.ada.petshop.services.Petshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Petshop petshop = new Petshop();

        Cachorro animal01 = new Cachorro("Bob", LocalDate.of(2015,8,10), "Chuaua", Porte.PEQUENO,5.0, EstadoAnimal.SUJO, null, null);
        Cachorro animal02 = new Cachorro("Faisca", LocalDate.of(2016, 12, 10), "Basse", Porte.MEDIO,12.0, EstadoAnimal.SUJO, null, null);
        Gato animal03 = new Gato("Dexter", LocalDate.of(2014,8,10), "Persa", Porte.PEQUENO,5.0, EstadoAnimal.SUJO, null,null);
        Gato animal04 = new Gato("Conan", LocalDate.of(2017, 12, 10), "Siamês", Porte.PEQUENO,12.0, EstadoAnimal.SUJO, null, null);

        List<Animais> listaAnimais01 = new ArrayList<>();
        listaAnimais01.addAll(Arrays.asList(animal01));
        Cliente cliente01 = new Cliente(1, listaAnimais01);
        cliente01.setNome("Joel");


        ResponseVO atendimentoClinico = petshop.atendimentoClinico(cliente01, cliente01.getPets(), "teste obs");
        //System.out.println(atendimentoClinico);

        List<Integer> listItens = new ArrayList<>();
        listItens.add(atendimentoClinico.getId());

        petshop.pagamentos(listItens);




    }
}