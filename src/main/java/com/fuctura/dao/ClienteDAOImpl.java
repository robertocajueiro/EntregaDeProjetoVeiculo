/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fuctura.dao;

import com.fuctura.dto.ClienteDTO;
import com.fuctura.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto Dantas
 */
public class ClienteDAOImpl implements IClienteDAO {

    @Override
    public void inserir(EntityManager em, Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (HeadlessException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    @Override
    public Cliente buscar(EntityManager em, int codigo) {
        Cliente resultadoConsulta = em.find(Cliente.class, 1);
        return resultadoConsulta;
    }

    @Override
    public List<Cliente> buscarTodos(EntityManager em) {
        String comando = "select u from Cliente u";
        TypedQuery<Cliente> query = em.createQuery(comando, Cliente.class);
        return query.getResultList();
    }

    @Override
    public List<Cliente> buscarPorNome(EntityManager em, String nome) {
        String comando = "select u from Cliente u where nome like :parametro";
        TypedQuery<Cliente> query = em.createQuery(comando, Cliente.class);
        query.setParameter("parametro", nome);

        return query.getResultList();
    }

    @Override
    public List<ClienteDTO> buscarTodosNomeECPF(EntityManager em) {
        String comando = "select new com.fuctura.dto.ClienteDTO(nome, cpf) from Cliente u";
        TypedQuery<ClienteDTO> query = em.createQuery(comando, ClienteDTO.class);
        return query.getResultList();
    }

}
