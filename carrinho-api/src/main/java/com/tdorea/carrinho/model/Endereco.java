package com.tdorea.carrinho.model;

import javax.persistence.Embeddable;
@Embeddable
public class Endereco {


   private String cep;
   private String complemento;

   public Endereco() {
   }

   public Endereco(String cep, String complemento) {
      this.cep = cep;
      this.complemento = complemento;
   }

   public String getCep() {
      return cep;
   }

   public void setCep(String cep) {
      this.cep = cep;
   }

   public String getComplemento() {
      return complemento;
   }

   public void setComplemento(String complemento) {
      this.complemento = complemento;
   }
}
