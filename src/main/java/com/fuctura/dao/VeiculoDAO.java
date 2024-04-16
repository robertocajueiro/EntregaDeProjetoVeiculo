/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fuctura.dao;

import com.fuctura.jdbc.ConnectionFactory;
import com.fuctura.model.Veiculo;
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
public class VeiculoDAO {

    private Connection con;

    public VeiculoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo cadastrar veiculo
    public void cadastrarVeiculo(Veiculo obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "insert  into tb_veiculo(placa,marca,modelo,ano, valor) "
                    + "values (?,?,?,?,?)";

            // Segundo passo: conectar o banco de dados e organizar o sql.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getPlaca());
            stmt.setString(2, obj.getMarca());
            stmt.setString(3, obj.getModelo());
            stmt.setInt(4, obj.getAno());
            stmt.setDouble(5, obj.getValor());

            // Terceiro passo: Executar comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Metodo alterar veiculo
    public void alterarVeiculo(Veiculo obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "update  tb_veiculo set placa=?,marca=?,modelo=?,ano=?, valor=? where codigo = ?";

            // Segundo passo: conectar o banco de dados e organizar o sql.
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getPlaca());
            stmt.setString(2, obj.getMarca());
            stmt.setString(3, obj.getModelo());
            stmt.setInt(4, obj.getAno());
             stmt.setDouble(5, obj.getValor());

            stmt.setInt(6, obj.getCodigo());

            // Terceiro passo: Executar comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Metodo excluir veiculo
    public void excluirVeiculo(Veiculo obj) {

        try {

            //Primeiro passo: criar o comando sql
            String sql = "delete from tb_veiculo where codigo = ?";

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

    // Metodo listar todos os veiculos
    public List<Veiculo> listarVeiculos() {
        try {
            // primeiro passo - criar a lista
            List<Veiculo> lista = new ArrayList<>();

            // segundo passo - criar o sql, organizar e executar
            String sql = "select * from tb_veiculo";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo obj = new Veiculo();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setPlaca(rs.getString("placa"));
                obj.setMarca(rs.getString("marca"));
                obj.setModelo(rs.getString("modelo"));
                obj.setAno(rs.getInt("ano"));
                obj.setValor(rs.getDouble("valor"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    // Método buscar veiculo por placa
    public List<Veiculo> buscaVeiculoPorPlaca(String placa) {
        try {
            // primeiro passo - criar a lista
            List<Veiculo> lista = new ArrayList<>();

            // segundo passo - criar o sql, organizar e executar
            String sql = "select * from tb_veiculo where placa like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo obj = new Veiculo();

                obj.setCodigo(rs.getInt("codigo"));
                obj.setPlaca(rs.getString("placa"));
                obj.setMarca(rs.getString("marca"));
                obj.setModelo(rs.getString("modelo"));
                obj.setAno(rs.getInt("ano"));
                obj.setValor(rs.getDouble("valor"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    // Metodo consulta veiculo por nome
    public Veiculo consultaPorPlaca(String placa) {
        try {
            //1 passo criar o sql, organizar e executar
            String sql = "select * from tb_veiculo where placa = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, placa);

            ResultSet rs = stmt.executeQuery();
            Veiculo obj = new Veiculo();

            if (rs.next()) {

                obj.setCodigo(rs.getInt("codigo"));
                obj.setPlaca(rs.getString("placa"));
                obj.setMarca(rs.getString("marca"));
                obj.setModelo(rs.getString("modelo"));
                obj.setAno(rs.getInt("ano"));
                obj.setValor(rs.getDouble("valor"));

            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado " + e);
            return null;
        }

    }

}
