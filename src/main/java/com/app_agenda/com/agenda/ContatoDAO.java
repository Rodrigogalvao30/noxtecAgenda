package com.app_agenda.com.agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContatoDAO {
	
	  private Connection connection;

	    public ContatoDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean cadastrarContato(Contato contato) {
	        try {
	            // Verificar se o número de celular já foi cadastrado anteriormente
	            if (verificarCelularExistente(contato.getCelular())) {
	                return false;   // Retorna false se o celular já estiver cadastrado
	            }
	            
	            // Inserir o contato no banco de dados
	            String sql = "INSERT INTO desafio.coontato (contato_nome, contato_email, contato_celular, contato_telefone, "
	                    + "contato_sn_favorito, contato_sn_ativo, contato_dh_cad) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, contato.getNome());
	            stmt.setString(2, contato.getEmail());
	            stmt.setString(3, contato.getCelular());
	            stmt.setString(4, contato.getTelefone());
	            stmt.setString(5, String.valueOf(contato.getSnFavorito()));
	            stmt.setString(6, String.valueOf(contato.getSnAtivo()));
	           
	            
	            stmt.executeUpdate();
	            stmt.close();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    private boolean verificarCelularExistente(String celular) throws SQLException {
	        String sql = "SELECT COUNT(*) AS total FROM desafio.coontato WHERE contato_celular = ?";
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, celular);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            int total = rs.getInt("total");
	            return total > 0;
	        }
	        
	        return false;
	    } 
	    
	   
	    
	}


