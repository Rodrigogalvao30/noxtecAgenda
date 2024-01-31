package com.app_agenda.com.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListarContatos {
	
	public static void main(String[] args) {
        try {
            // Conectar ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NoxtecDB", "posgres", "123");

            // Executar a consulta
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contatos");

            // Listar os contatos
            while (resultSet.next()) {
                int contatoId = resultSet.getInt("contato_id");
                String contatoNome = resultSet.getString("contato_nome");
                String contatoEmail = resultSet.getString("contato_email");
                String contatoCelular = resultSet.getString("contato_celular");
                String contatoTelefone = resultSet.getString("contato_telefone");
                char contatoSnFavorito = resultSet.getString("contato_sn_favorito").charAt(0);
                char contatoSnAtivo = resultSet.getString("contato_sn_ativo").charAt(0);
               
            }

            // Fechar conexão e recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


