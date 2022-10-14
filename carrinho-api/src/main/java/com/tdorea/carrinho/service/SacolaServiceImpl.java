package com.tdorea.carrinho.service;

import com.tdorea.carrinho.enumeration.FormaPagamento;
import com.tdorea.carrinho.model.Item;
import com.tdorea.carrinho.model.Restaurante;
import com.tdorea.carrinho.model.Sacola;
import com.tdorea.carrinho.repository.ItemRepository;
import com.tdorea.carrinho.repository.ProdutoRepository;
import com.tdorea.carrinho.repository.SacolaRepository;
import com.tdorea.carrinho.resource.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SacolaServiceImpl implements SacolaService{

   private final SacolaRepository sacolaRepository;
   private final ProdutoRepository produtoRepository;
   private final ItemRepository itemRepository;

   public SacolaServiceImpl(SacolaRepository sacolaRepository, ProdutoRepository produtoRepository, ItemRepository itemRepository) {
      this.sacolaRepository = sacolaRepository;
      this.produtoRepository = produtoRepository;
      this.itemRepository = itemRepository;
   }

   @Override
   public Item incluirItemSacola(ItemDto itemDto) {
      Sacola sacola = verSacola(itemDto.getIdSacola());
      if(sacola.isFechada()){throw new RuntimeException("Esta sacola está fechada");}
      Item itemParaSerInserido = new Item();
      itemParaSerInserido.setQuantidade(itemDto.getQuantidade());
      itemParaSerInserido.setSacola(sacola);
      itemParaSerInserido.setProduto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(()->{
         throw new RuntimeException("Esse produto não existe!");
      }));
      List<Item> itensDaSacola = sacola.getItens();
      if(itensDaSacola.isEmpty()){
         itensDaSacola.add(itemParaSerInserido);
      }else{
         Restaurante restauranteAtual =  itensDaSacola.get(0).getProduto().getRestaurante();
         Restaurante restauranteDoItemParaAdicionar = itemParaSerInserido.getProduto().getRestaurante();
         if(restauranteAtual.equals(restauranteDoItemParaAdicionar)){
            itensDaSacola.add(itemParaSerInserido);
         }else{
            throw new RuntimeException("Não é possível adicionar produtos de restaurantes diferente. Feche a sacola ou esvazie.");
         }
      }
      List<Double> valorDosItens = new ArrayList<>();
      for(Item itemDaSacola: itensDaSacola){
         Double valorTotalItem = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
         valorDosItens.add(valorTotalItem);
      }
      Double valorTotalScola = valorDosItens.stream().mapToDouble(valorTotalDeCadaItem -> valorTotalDeCadaItem).sum();
      sacola.setValorTotal(valorTotalScola);
      sacolaRepository.save(sacola);
      return itemRepository.save(itemParaSerInserido);
   }

   @Override
   public Sacola verSacola(Long id) {
      return sacolaRepository.findById(id).orElseThrow(()->{
         throw new RuntimeException("Sacola {id} não existe.");
      });
   }

   @Override
   public Sacola fecharSacola(Long id, int numeroFormaPagamento) {
      Sacola sacola = verSacola(id);
      if(sacola.getItens().isEmpty()) {
         throw new RuntimeException("Inclua item na sacola!");
      }
      FormaPagamento formaPagamento = numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
      sacola.setFormaPagamento(formaPagamento);
      sacola.setFechada(true);
      return sacolaRepository.save(sacola);
   }
}
