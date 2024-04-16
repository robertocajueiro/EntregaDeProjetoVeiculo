/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fuctura.dao;

import com.fuctura.jdbc.ConnectionFactory;
import com.fuctura.model.Cliente;
import com.fuctura.model.Vendedor;
import com.fuctura.model.WebServiceCep;
import com.fuctura.view.FrmLogin;
import com.fuctura.view.FrmMenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto Dantas
 */
public class VendedorDAO {

    private Connection con;

    public VendedorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo cadastrar cliente
    public void cadastrarVendedor(Vendedor obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "insert  into tb_vendedor(nome, email, senha) "
                    + "values (?,?,?)";

            // Segundo passo: conectar o banco de dados e organizar o sql.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());

            // Terceiro passo: Executar comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Metodo alterar cliente
    public void alterarVendedor(Vendedor obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "update  tb_vendedor set nome=?, email=?, senha=? where codigo = ?";

            // Segundo passo: conectar o banco de dados e organizar o sql.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());

            stmt.setInt(4, obj.getCodigo());

            // Terceiro passo: Executar comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Metodo excluir vendedor
    public void excluirVendedor(Vendedor obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "delete from tb_vendedor where codigo = ?";

            // Segundo passo: conectar o banco de dados e organizar o sql.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodigo());

            // Terceiro passo: Executar comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido  com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    // Metodo listar todos os Vendedores
    public List<Vendedor> listarVendedores() {
        try {
            // primeiro passo - criar a lista
            List<Vendedor> lista = new ArrayList<>();

            // segundo passo - criar o sql, organizar e executar
            String sql = "select * from tb_vendedor";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor obj = new Vendedor();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    // Método buscar vendedores por nome
    public List<Vendedor> buscaVendedorPorNome(String nome) {
        try {
            // primeiro passo - criar a lista
            List<Vendedor> lista = new ArrayList<>();

            // segundo passo - criar o sql, organizar e executar
            String sql = "select * from tb_vendedor where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor obj = new Vendedor();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    // Metodo consulta vendedor por nome
    public Vendedor consultaPorNome(String nome) {
        try {
            //1 passo criar o sql, organizar e executar
            String sql = "select * from tb_vendedor where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Vendedor obj = new Vendedor();

            if (rs.next()) {
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));

            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado " + e);
            return null;
        }

    }

    // Método buscar vendedores por nome
//    public List<Cliente> buscaVendedorPorCPF(String cpf) {
//        try {
//            // primeiro passo - criar a lista
//            List<Cliente> lista = new ArrayList<>();
//
//            // segundo passo - criar o sql, organizar e executar
//            String sql = "select * from tb_cliente where cpf like ?";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, cpf);
//
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Cliente obj = new Cliente();
//
//                obj.setId(rs.getInt("id"));
//                obj.setNome(rs.getString("nome"));
//                obj.setRg(rs.getString("rg"));
//                obj.setCpf(rs.getString("cpf"));
//                obj.setEmail(rs.getString("email"));
//                obj.setTelefone(rs.getString("telefone"));
//                obj.setCelular(rs.getString("celular"));
//                obj.setCep(rs.getString("cep"));
//                obj.setEndereco(rs.getString("endereco"));
//                obj.setNumero(rs.getInt("numero"));
//                obj.setComplemento(rs.getString("complemento"));
//                obj.setBairro(rs.getString("bairro"));
//                obj.setCidade(rs.getString("cidade"));
//                obj.setUf(rs.getString("uf"));
//
//                lista.add(obj);
//            }
//
//            return lista;
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro: " + erro);
//            return null;
//        }
//
//    }
    // Buscar CEP
    public Cliente buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Cliente obj = new Cliente();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }

    /// verificar
    public List<Vendedor> listar(EntityManager em) {
        String comando = "select u from Vendedor u";
        TypedQuery<Vendedor> query = em.createQuery(comando, Vendedor.class);
        return query.getResultList();
    }

    // Metodo efetuaLogin
    public void efetuaLogin(String email, String senha) {
        try {

            // 1 passo - SQL
            String sql = "select * from tb_vendedor where email=? and senha=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario conectou
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");
                FrmMenu tela = new FrmMenu();
                tela.usuarioLogado = rs.getString("nome");
                tela.setVisible(true);
            } else {
                // Dados  incorretos 
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                new FrmLogin().setVisible(true);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }

}
