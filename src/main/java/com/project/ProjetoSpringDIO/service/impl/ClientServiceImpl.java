package com.project.ProjetoSpringDIO.service.impl;

import com.project.ProjetoSpringDIO.model.Cliente;
import com.project.ProjetoSpringDIO.model.ClienteRepository;
import com.project.ProjetoSpringDIO.model.Endereco;
import com.project.ProjetoSpringDIO.model.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private  ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
       return clienteRepository.findAll();
    }
    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClientePorCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBancoDeDados = clienteRepository.findById(id);
        if(clienteBancoDeDados.isPresent()){
            salvarClientePorCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClientePorCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet( () -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
