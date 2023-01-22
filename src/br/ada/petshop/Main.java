package br.ada.petshop;

import br.ada.petshop.VO.ResponseVO;
import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Higiene;
import br.ada.petshop.enums.Porte;
import br.ada.petshop.enums.Vacinas;
import br.ada.petshop.models.*;
import br.ada.petshop.services.Petshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Petshop petshop = new Petshop();

        Cachorro animal01 = new Cachorro("Bob", LocalDate.of(2015,8,10), "Chuaua", Porte.PEQUENO,5.0, EstadoAnimal.SUJO, null, null);
        Cachorro animal02 = new Cachorro("Faisca", LocalDate.of(2016, 12, 10), "Basse", Porte.MEDIO,12.0, EstadoAnimal.SUJO, null, null);
        Gato animal03 = new Gato("Dexter", LocalDate.of(2014,8,10), "Persa", Porte.PEQUENO,5.0, EstadoAnimal.SUJO, null,null);
        Gato animal04 = new Gato("Conan", LocalDate.of(2017, 12, 10), "Siamês", Porte.PEQUENO,12.0, EstadoAnimal.SUJO, null, null);

        //ATENDIMENTO PARA 1 PET
        List<Animais> listaAnimais01 = new ArrayList<>();
        listaAnimais01.addAll(Arrays.asList(animal01));

        System.out.println("**CLIENTE COM 1 PET************************************************************");
        Cliente cliente01 = new Cliente(1, listaAnimais01);
        cliente01.setNome("Joel");

        ResponseVO atendimentoClinico = petshop.atendimentoClinico(cliente01, cliente01.getPets(), "teste obs");
        System.out.println(atendimentoClinico);

        List<Vacinas> vacinasList = new ArrayList<>();
        for (int i = 0; i < atendimentoClinico.getCliente().getPets().size(); i++) {
            vacinasList.add(Vacinas.valueOf(atendimentoClinico.getCliente().getPets().get(i).getObservacoes()));
        }

        ResponseVO vacinacao = petshop.vacinacao(cliente01, cliente01.getPets(), vacinasList, null);
        System.out.println(vacinacao);

        ResponseVO higienizacao = petshop.higienizar(cliente01, cliente01.getPets(), Higiene.BANHO_E_TOSA,"Cortar as unhas");
        System.out.println(higienizacao);

        List<Integer> listItens = new ArrayList<>();
        listItens.add(atendimentoClinico.getId());
        listItens.add(vacinacao.getId());
        listItens.add(higienizacao.getId());
        listItens.add(13);
        listItens.add(23);

        petshop.pagamentos(listItens);

        //ATENDIMENTO PARA 2 PETS
        System.out.println();
        System.out.println("**CLIENTE COM 2 PET***********************************************************");

        List<Animais> listaAnimais02 = new ArrayList<>();
        listaAnimais02.addAll(Arrays.asList(animal02, animal03));

        Cliente cliente02 = new Cliente(2, listaAnimais02);
        cliente02.setNome("Samuel");

        ResponseVO atendimentoClinico2 = petshop.atendimentoClinico(cliente02, cliente02.getPets(), "teste obs");
        System.out.println(atendimentoClinico);

        List<Vacinas> vacinasList2 = new ArrayList<>();
        for (int i = 0; i < atendimentoClinico2.getCliente().getPets().size(); i++) {
            vacinasList.add(Vacinas.valueOf(atendimentoClinico2.getCliente().getPets().get(i).getObservacoes()));
        }

        ResponseVO vacinacao2 = petshop.vacinacao(cliente02, cliente02.getPets(), vacinasList, null);
        System.out.println(vacinacao2);

        ResponseVO higienizacao2 = petshop.higienizar(cliente02, cliente02.getPets(), Higiene.BANHO_E_TOSA,"Cortar as unhas");
        System.out.println(higienizacao2);

        List<Integer> listItens2 = new ArrayList<>();
        listItens2.add(atendimentoClinico.getId());
        listItens2.add(vacinacao.getId());
        listItens2.add(higienizacao.getId());
        listItens2.add(11);
        listItens2.add(12);
        listItens2.add(21);
        listItens2.add(22);

        petshop.pagamentos(listItens2);

        System.out.println();
        System.out.println("**LISTA DE ALIMENTOS************************************************************");
        petshop.verAlimentos();
        System.out.println("**LISTA DE REMEDIOS************************************************************");
        petshop.verRemedios();

    }
}