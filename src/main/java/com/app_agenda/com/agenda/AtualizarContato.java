package com.app_agenda.com.agenda;
import java.sql.*;


public class AtualizarContato {

	
	public static void main(String[] args) {
        // Informações de conexão com o banco de dados
        String url = "jdbc:postgresql://localhost:5432/NoxtecDB";
        String username = "posgres";
        String password = "123";

        // Dados do contato a ser atualizado
        int contato_id; // ID do contato a ser atualizado
        String contato_nome; // Novo nome do contato
        String contato_email; // Novo email do contato
        String contato_celular; // Novo número de celular do contato
        String contato_telefone; // Novo número de telefone do contato
        char contato_sn_favorito; // Novo status de favorito do contato
        char contato_sn_ativo; // Novo status de ativo do contato
}
}