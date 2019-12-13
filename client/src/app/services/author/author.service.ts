import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class AuthorService {
  constructor(private http: HttpClient) { }

   getAll(): Observable<any> {
      return this.http.get('//localhost:8090/authors');
   }

   get(id: string) {
       return this.http.get('//localhost:8090/authors/' + id);
   }

   save(author: any): Observable<any> {
       let result: Observable<any>;
       if (author.id) {
         result = this.http.post('//localhost:8090/authors/author-edit', author);
       } else {
         result = this.http.post('//localhost:8090/authors/author-add', author);
       }
       return result;
   }

   remove(href: string) {
       return this.http.delete(href);
   }
}
