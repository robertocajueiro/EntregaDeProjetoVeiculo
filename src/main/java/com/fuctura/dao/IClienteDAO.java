/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fuctura.dao;

import com.fuctura.dto.ClienteDTO;
import com.fuctura.model.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Roberto Dantas
 */
public interface IClienteDAO {

    void inserir(EntityManager em, Cliente cliente);

    Cliente buscar(EntityManager em, int codigo);

    List<Cliente> buscarTodos(EntityManager em);

    List<Cliente> buscarPorNome(EntityManager em, String nome);

    List<ClienteDTO> buscarTodosNomeECPF(EntityManager em);

}
