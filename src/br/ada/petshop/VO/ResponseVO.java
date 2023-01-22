package br.ada.petshop.VO;

import br.ada.petshop.enums.Servicos;
import br.ada.petshop.models.Animais;
import br.ada.petshop.models.Cliente;

import java.math.BigDecimal;

public class ResponseVO {

    private int id;
    private Servicos servicos;
    private BigDecimal valor;
    private Cliente cliente;

    public ResponseVO() {
    }

    public ResponseVO(int id, Servicos servicos, BigDecimal valor, Cliente cliente) {
        this.id = id;
        this.servicos = servicos;
        this.valor = valor;
        this.cliente = cliente;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "id=" + id +
                ", servicos=" + servicos +
                ", valor=" + valor +
                ", cliente=" + cliente +
                '}';
    }
}
