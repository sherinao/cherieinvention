import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class InventoryService {
  constructor(private http: HttpClient) { }
  rootUrl: string = '//localhost:8090/';
  baseUrl: string = '//localhost:8090';

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl+'/inventories');
  }

  get(id: string) {
     return this.http.get(this.baseUrl+'/inventories/'+ id);
  }

  save(inventory: any): Observable<any> {
     let result: Observable<any>;
     if (inventory.id) {
       result = this.http.post(this.baseUrl+'/inventory-edit', inventory);
     } else {
       result = this.http.post(this.baseUrl+'/inventory-add', inventory);
     }
     return result;
  }

  remove(href: string) {
     return this.http.delete(href);
  }
}
