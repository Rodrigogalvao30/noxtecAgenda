package com.app_agenda.com.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class AgendaController {
	
	    @Autowired
	    private AgendaService AgendaContatos;

	    @GetMapping("/contatos")
	    public List<Contato> listarExemplos() {
	        return ListarContatos.ListarContatos();
	    }

	    @PostMapping("/contatos")
	    public listarContacts criarContato(@RequestBody listar exemplo) {
	        return ContatoDAO.ContatoDAO(exemplo);
	    }
	    
	    // Build Delete Todo REST API
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> ExcluirContato(@PathVariable("id") Long todoId){
	        todoService.deleteTodo(todoId);
	        return ResponseEntity.ok("contato deletado com sucesso!.");
	    }
	    
	    

}
