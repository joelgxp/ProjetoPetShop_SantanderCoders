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
        var remedio01 =  new Remedios(11, "Medicamento Anti-inflamatório Dermatite Cães/gatos", new BigDecimal("45.40"));
        var remedio02 =  new Remedios(12, "Medicamento Corticoide, Sarnas,dermatite Cães E Gatos", new BigDecimal("59.35"));
        var remedio03 =  new Remedios(13, "Anti Inflamatório Dexagard Para Cães E Gatos", new BigDecimal("29.90"));
        var remedio04 =  new Remedios(14, "Calmante Natural Para Caes E Gatos 30 Cápsulas Nicpharma", new BigDecimal("18.50"));
        var remedio05 =  new Remedios(15, "Antibiótico Ourofino Celesporin 12 Comprimidos", new BigDecimal("46.90"));

        return Arrays.asList(remedio01, remedio02, remedio03, remedio04, remedio05);
    }

    private static List<Alimentos> criarListaAlimentos() {
        var alimento01 =  new Alimentos(21, "Comida Natural para Cachorro sabor Carne", new BigDecimal("89.90"));
        var alimento02 =  new Alimentos(22, "Alimento para Gatos Bancat 25kg", new BigDecimal("73.50"));
        var alimento03 =  new Alimentos(23, "Pet Protein Proteico Em Pó Cães Gato", new BigDecimal("59.90"));
        var alimento04 =  new Alimentos(24, "Papinha Gato (gatos filhotes)", new BigDecimal("8.39"));
        var alimento05 =  new Alimentos(25, "Petisco Comida Natural Para Cachorros E Gatos", new BigDecimal("58.0"));

        return Arrays.asList(alimento01, alimento02, alimento03, alimento04, alimento05);
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
        return new ResponseVO(VACINAR, Servicos.VACINACAO, new BigDecimal("80.0"), cliente);
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
            }else if (itens.get(i) == 4) {
                valorProd = 59.90;
            }else if (itens.get(i) == 5) {
                valorProd = 39.90;
            }else if (itens.get(i) == 6) {
                valorProd = 29.90;

            }
        }
        System.out.printf("******* COMPROVATE DE PAGAMENTO ******");
        System.out.println();
        System.out.println("Valor total em servicos: " + valorServ);
        System.out.println("Valor total em produtos: " + valorProd);


    }


}
