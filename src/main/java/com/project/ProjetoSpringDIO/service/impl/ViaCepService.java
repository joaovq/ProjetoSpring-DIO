package com.project.ProjetoSpringDIO.service.impl;

import com.project.ProjetoSpringDIO.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    // Poderia usar também a anotação @GetMapping, ja indicando que é um Get  passanto somente
    // (value ="/{cep}/json/" ) como parametro
    @RequestMapping(method = RequestMethod.GET,value ="/{cep}/json/" )
    Endereco consultarCep(@PathVariable("cep") String cep);
}
