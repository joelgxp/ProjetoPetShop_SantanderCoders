package br.ada.petshop.services;

import br.ada.petshop.VO.ResponseVO;
import br.ada.petshop.enums.EstadoAnimal;
import br.ada.petshop.enums.Higiene;
import br.ada.petshop.enums.Servicos;
import br.ada.petshop.enums.Vacinas;
import br.ada.petshop.models.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Petshop {
    private String cnpj;
    private Endereco endereco;
    private final int HIGIENIZAR = 1;
    private final int VACINAR = 3;
    private final int ATENDIMENTO_CLINICO = 2;
    private static List<Remedios> remediosList = criarListaRemedios();
    private static List<Alimentos> alimentosList = criarListaAlimentos();


    public Petshop() {
    }

    private static List<Remedios> criarListaRemedios() {
        var remedio01 =  new Remedios(11, "Medicamento Anti-inflamatório Dermatite Cães/gatos", new BigDecimal("45.50"));
        var remedio02 =  new Remedios(12, "Medicamento Corticoide, Sarnas,dermatite Cães E Gatos", new BigDecimal("59.90"));
        var remedio03 =  new Remedios(13, "Anti Inflamatório Dexagard Para Cães E Gatos", new BigDecimal("29.90"));

        return Arrays.asList(remedio01, remedio02, remedio03);
    }

    private static List<Alimentos> criarListaAlimentos() {
        var alimento01 =  new Alimentos(21, "Comida Natural para Cachorro sabor Carne", new BigDecimal("89.90"));
        var alimento02 =  new Alimentos(22, "Alimento para Gatos Bancat 25kg", new BigDecimal("79.90"));
        var alimento03 =  new Alimentos(23, "Pet Protein Proteico Em Pó Cães Gato", new BigDecimal("69.90"));

        return Arrays.asList(alimento01, alimento02, alimento03);
    }



    public ResponseVO higienizar (Cliente cliente, List<Animais> animais, Higiene higiene, String Observacoes) {
        for(int i = 0; i < animais.size(); i++) {
            if (higiene.equals(Higiene.BANHO_E_TOSA)) {
                animais.get(i).setEstado(EstadoAnimal.LIMPO_E_TOSADO);
            } else if(higiene.equals(Higiene.BANHO)){
                animais.get(i).setEstado(EstadoAnimal.LIMPO);
            }
        }
        BigDecimal valor = BigDecimal.valueOf(animais.size());
        return new ResponseVO(HIGIENIZAR, Servicos.HIGIENIZAR, new BigDecimal("120").multiply(valor), cliente);
    }

    public ResponseVO atendimentoClinico (Cliente cliente, List<Animais> animais, String Observacoes) {

        Random random = new Random();

        for (int i = 0; i < animais.size(); i++) {
            int aleatorio = random.nextInt(1, 6);
            switch (aleatorio) {
                case 1:
                    animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_01));
                    break;
                case 2:
                    animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_02));
                    break;
                case 3:
                    animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_03));
                    break;
                case 4:
                    animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_04));
                    break;
                case 5:
                    animais.get(i).setObservacoes(String.valueOf(Vacinas.VACINA_05));
                    break;
            }
        }
        BigDecimal valor = BigDecimal.valueOf(animais.size());

        return new ResponseVO(ATENDIMENTO_CLINICO, Servicos.ATENDIMENTO_CLINICO, new BigDecimal("300").multiply(valor), cliente);
    }

    public ResponseVO vacinacao (Cliente cliente, List<Animais> animais, List<Vacinas> vacinas, String Observacoes) {

        for(int i = 0; i < animais.size(); i++){
            List<EsquemaVacinal> esquemaVacinalList = new ArrayList<>();
            esquemaVacinalList.add(new EsquemaVacinal(LocalDate.of(2022,8,2),vacinas.get(i),"Vacinado"));
            animais.get(i).setVacinas(esquemaVacinalList);
        }
        BigDecimal valor = BigDecimal.valueOf(animais.size());
        return new ResponseVO(VACINAR, Servicos.VACINACAO, new BigDecimal("80.0").multiply(valor), cliente);
    }

    public void verAlimentos(){
        alimentosList.forEach(alimentos -> System.out.println(alimentos));
    }

    public void verRemedios(){
        remediosList.forEach(remedios -> System.out.println(remedios));
    }

    public void pagamentos(List<Integer> itens) {
        Double valorServ = 0.0;
        Double valorProd = 0.0;
        for(int i = 0; i<itens.size(); i++){
            if (itens.get(i) == 1) {
                valorServ += 120.0;
            }else if (itens.get(i) == 2) {
                valorServ += 300.0;
            }else if (itens.get(i) == 3) {
                valorServ += 80.0;
            }else if (itens.get(i) == 11) {
                valorProd += 45.50;
            }else if (itens.get(i) == 12) {
                valorProd += 59.90;
            }else if (itens.get(i) == 13) {
                valorProd += 29.90;
            }else if (itens.get(i) == 21) {
                valorProd += 89.90;
            }else if (itens.get(i) == 22) {
                valorProd += 79.90;
            }else if (itens.get(i) == 23) {
                valorProd += 69.90;

            }
        }
        //Double valor = atendimentoClinico().getCliente().getPets().size();
        System.out.println("******* COMPROVATE DE PAGAMENTO ******");
        System.out.printf("Valor total em servicos: %.2f %n", valorServ);
        System.out.printf("Valor total em produtos: %.2f %n", valorProd);
        System.out.printf("Valor total a pagar: %.2f %n", valorProd + valorServ);


    }


}
