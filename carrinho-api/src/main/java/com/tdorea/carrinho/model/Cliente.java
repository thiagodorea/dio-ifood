package com.tdorea.carrinho.model;

import org.hibernate.annotations.Generated;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   @Embedded
   private Endereco endereco;

   public Cliente() {
   }

   public Cliente(Long id, String nome, Endereco endereco) {
      this.id = id;
      this.nome = nome;
      this.endereco = endereco;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Endereco getEndereco() {
      return endereco;
   }

   public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
   }
}
