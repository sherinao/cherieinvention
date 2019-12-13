import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class PublisherService {

   constructor(private http: HttpClient) { }

   getAll(): Observable<any> {
      return this.http.get('//localhost:8090/publishers');
   }

   get(id: string) {
       return this.http.get('//localhost:8090/publishers/' + id);
   }

   save(publisher: any): Observable<any> {
       let result: Observable<any>;
       if (publisher.id) {
         result = this.http.post('//localhost:8090/publishers/publisher-edit', publisher);
       } else {
         result = this.http.post('//localhost:8090/publishers/publisher-add', publisher);
       }
       return result;
   }

   remove(href: string) {
       return this.http.delete(href);
   }
}
