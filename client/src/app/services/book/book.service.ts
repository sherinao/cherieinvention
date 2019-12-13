import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class BookService {

  constructor(private http: HttpClient) { }
  baseUrl: string = '//localhost:8090/books';

   getAll(): Observable<any> {
      return this.http.get(this.baseUrl);
   }

   get(id: string) {
       return this.http.get(this.baseUrl+'/'+ id);
   }

   save(book: any): Observable<any> {
       let result: Observable<any>;
       if (book.id) {
         result = this.http.post(this.baseUrl+'/book-edit', book);
       } else {
         result = this.http.post(this.baseUrl+'/book-add', book);
       }
       return result;
   }

   remove(href: string) {
       return this.http.delete(href);
   }
}
