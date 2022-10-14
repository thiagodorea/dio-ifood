package com.tdorea.carrinho.service;

import com.tdorea.carrinho.model.Item;
import com.tdorea.carrinho.model.Sacola;
import com.tdorea.carrinho.resource.dto.ItemDto;

public interface SacolaService{
   Item incluirItemSacola(ItemDto itemDto);
   Sacola verSacola(Long id);
   Sacola fecharSacola(Long id, int formaPagamento);
}
