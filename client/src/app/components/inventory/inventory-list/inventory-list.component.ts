import { Component, OnInit } from '@angular/core';
import { InventoryService } from '../../../services/inventory/inventory.service';
import { GiphyService } from '../../../services/giphy/giphy.service';

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.scss']
})
export class InventoryListComponent implements OnInit {
 inventories: Array<any>;

   constructor(private inventoryService: InventoryService, private giphyService: GiphyService) { }

   ngOnInit() {
     this.inventoryService.getAll().subscribe(data => {
         this.inventories = data;
         for (const inventory of this.inventories) {
                 this.giphyService.get(inventory.name).subscribe(url => inventory.giphyUrl = url);
         }
     });
   }
}
