import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { Exemplo } from '../models/agenda.model';
import { agendaervice } from '../services/agenda.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,BrowserModule,
    FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'app-agenda';
}

export class AgendaContatos implements OnInit {

  agenda: Exemplo[] = [];

  constructor(private agendaservice: agendaservice) { }

  ngOnInit(): void {
    this.listaragenda();
  }

  listaragenda(): void {
    this.agendaservice.listaragenda().subscribe(
      agenda => this.agenda = agenda
    );
  }

  criarExemplo(): void {
    const exemplo: Exemplo = {
     
    };

    this.agendaservice.criarExemplo(exemplo).subscribe(
      novoExemplo => {
        this.agenda.push(novoExemplo);
        // 
      }
    );
