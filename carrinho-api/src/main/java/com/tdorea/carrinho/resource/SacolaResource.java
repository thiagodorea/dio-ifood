package com.tdorea.carrinho.resource;

import com.tdorea.carrinho.model.Item;
import com.tdorea.carrinho.model.Sacola;
import com.tdorea.carrinho.resource.dto.ItemDto;
import com.tdorea.carrinho.service.SacolaService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/ifood/sacolas")
@RestController
@RequestMapping("/ifood/sacolas")
public class SacolaResource {

   private final SacolaService sacolaService;

   public SacolaResource(SacolaService sacolaService) {
      this.sacolaService = sacolaService;
   }

   @PostMapping
   public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
      return sacolaService.incluirItemSacola(itemDto);
   }

   @GetMapping("/{id}")
   public Sacola verSacola(@PathVariable("id") Long id){
      return sacolaService.verSacola(id);
   }

   @PatchMapping("/fecharSacola/{sacolaId}")
   public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId, @RequestParam("formaPagamento") int formaPagamento){
      return sacolaService.fecharSacola(sacolaId,formaPagamento);
   }

}
