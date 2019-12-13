import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { PublisherService } from '../../../services/publisher/publisher.service';
import { AuthorService } from '../../../services/author/author.service';
import { InventoryService } from '../../../services/inventory/inventory.service';
import { GiphyService } from '../../../services/giphy/giphy.service';
import { NgForm,} from '@angular/forms';

@Component({
  selector: 'app-inventory-edit',
  templateUrl: './inventory-edit.component.html',
  styleUrls: ['./inventory-edit.component.scss']
})
export class InventoryEditComponent implements OnInit {
   inventory: any = {};
    authors: Array<any>;
    publishers: Array<any>;
    sub: Subscription;

    constructor(private route: ActivatedRoute,
                private router: Router,
                private inventoryService: InventoryService,
                private authorService: AuthorService,
                private publisherService: PublisherService,
                private giphyService: GiphyService) {
    }

     ngOnInit() {
        this.authorService.getAll().subscribe(data => {
         this.authors = data;
        });

        this.publisherService.getAll().subscribe(data => {
           this.publishers = data;
        });

        this.sub = this.route.params.subscribe(params => {
          const id = params.id;
          if (id) {
            this.inventoryService.get(id).subscribe((inventory: any) => {
              if (inventory) {
                this.inventory = inventory;
                this.giphyService.get(inventory.name).subscribe(url => inventory.giphyUrl = url);
              } else {
                console.log(`Inventory with id '${id}' not found, returning to list`);
                this.gotoList();
              }
            });
          }
        });
      }

      ngOnDestroy() {
        this.sub.unsubscribe();
      }

      gotoList() {
        this.router.navigate(['/inventory-list']);
      }

      save(form: NgForm) {
        this.inventoryService.save(form).subscribe(result => {
          this.gotoList();
        }, error => console.error(error));
      }

      remove(href) {
        this.inventoryService.remove(href).subscribe(result => {
          this.gotoList();
        }, error => console.error(error));
      }
}
