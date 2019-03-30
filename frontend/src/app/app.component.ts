import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Message } from './message';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {

  public messages: Observable<Message[]>;

  constructor(private http: HttpClient) {
  }

  public ngOnInit() {
    this.messages = this.http.get<Message[]>(`${environment.apiUrl}/messages`);
  }

}
