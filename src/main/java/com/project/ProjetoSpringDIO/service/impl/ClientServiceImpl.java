package com.project.ProjetoSpringDIO.service.impl;

import com.project.ProjetoSpringDIO.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteService{

    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
