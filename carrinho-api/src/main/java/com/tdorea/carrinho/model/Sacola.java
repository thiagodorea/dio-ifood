package com.tdorea.carrinho.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdorea.carrinho.enumeration.FormaPagamento;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Sacola {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JsonIgnore
   private Cliente cliente;
   @OneToMany(cascade = javax.persistence.CascadeType.ALL)
   private List<Item> itens;
   private Double valorTotal;
   @Enumerated
   private FormaPagamento formaPagamento;
   private boolean fechada;

   public Sacola() {
   }

   public Sacola(Long id, Cliente cliente, List<Item> itens, Double valorTotal, FormaPagamento formaPagamento, boolean fechada) {
      this.id = id;
      this.cliente = cliente;
      this.itens = itens;
      this.valorTotal = valorTotal;
      this.formaPagamento = formaPagamento;
      this.fechada = fechada;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public List<Item> getItens() {
      return itens;
   }

   public void setItens(List<Item> itens) {
      this.itens = itens;
   }

   public Double getValorTotal() {
      return valorTotal;
   }

   public void setValorTotal(Double valorTotal) {
      this.valorTotal = valorTotal;
   }

   public FormaPagamento getFormaPagamento() {
      return formaPagamento;
   }

   public void setFormaPagamento(FormaPagamento formaPagamento) {
      this.formaPagamento = formaPagamento;
   }

   public boolean isFechada() {
      return fechada;
   }

   public void setFechada(boolean fechada) {
      this.fechada = fechada;
   }


}
