import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../../../services/book/book.service';
import { InventoryService } from '../../../services/inventory/inventory.service';
import { GiphyService } from '../../../services/giphy/giphy.service';
import { NgForm,} from '@angular/forms';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.scss']
})
export class BookEditComponent implements OnInit {
 book: any = {};
  inventories: Array<any>;
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private bookService: BookService,
              private inventoryService: InventoryService,
              private giphyService: GiphyService) {
  }

   ngOnInit() {
      this.inventoryService.getAll().subscribe(data => {
        this.inventories = data;
      });

      this.sub = this.route.params.subscribe(params => {
        const id = params.id;
        if (id) {
          this.bookService.get(id).subscribe((book: any) => {
            if (book) {
              this.book = book;
              this.giphyService.get(book.name).subscribe(url => book.giphyUrl = url);
            } else {
              console.log(`Book with id '${id}' not found, returning to list`);
              this.gotoList();
            }
          });
        }
      }
      );
    }

    ngOnDestroy() {
      this.sub.unsubscribe();
    }

    gotoList() {
      this.router.navigate(['/book-list']);
    }

    save(form: NgForm) {
      this.bookService.save(form).subscribe(result => {
        this.gotoList();
      }, error => console.error(error));
    }

    remove(href) {
      this.bookService.remove(href).subscribe(result => {
        this.gotoList();
      }, error => console.error(error));
    }
}
