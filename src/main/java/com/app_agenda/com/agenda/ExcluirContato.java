package com.app_agenda.com.agenda;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirContato {
	 
	
	public static void main(String[] args) {
		
		   // Informações de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/NoxtecDB";
        String username = "posgres";
        String password = "123";

        int contatoId = 1; // ID do contato a ser excluído
        
        try {
            Connection connection = DriverManager.getConnection(url, username,password );

            String sql = "DELETE FROM nome_da_tabela WHERE contato_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, contatoId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Contato excluído com sucesso!");
            } else {
                System.out.println("Nenhum contato encontrado com esse ID.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

