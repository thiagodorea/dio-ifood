package com.tdorea.carrinho.resource.dto;

import javax.persistence.Embeddable;

@Embeddable
public class ItemDto {
   private Long produtoId;
   private int quantidade;
   private Long idSacola;

   public ItemDto() {
   }

   public ItemDto(Long produtoId, int quantidade, Long idSacola) {
      this.produtoId = produtoId;
      this.quantidade = quantidade;
      this.idSacola = idSacola;
   }

   public Long getProdutoId() {
      return produtoId;
   }

   public void setProdutoId(Long produtoId) {
      this.produtoId = produtoId;
   }

   public int getQuantidade() {
      return quantidade;
   }

   public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
   }

   public Long getIdSacola() {
      return idSacola;
   }

   public void setIdSacola(Long idSacola) {
      this.idSacola = idSacola;
   }

}
