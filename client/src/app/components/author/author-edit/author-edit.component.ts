import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthorService } from '../../../services/author/author.service';
import { GiphyService } from '../../../services/giphy/giphy.service';
import { NgForm,} from '@angular/forms';
@Component({
  selector: 'app-author-edit',
  templateUrl: './author-edit.component.html',
  styleUrls: ['./author-edit.component.scss']
})
export class AuthorEditComponent implements OnInit {
   author: any = {};
   sub: Subscription;
   constructor(private route: ActivatedRoute,
               private router: Router,
               private authorService: AuthorService,
               private giphyService: GiphyService) { }

   ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
           const id = params.id;
           if (id) {
             this.authorService.get(id).subscribe((author: any) => {
               if (author) {
                 this.author = author;
                 this.giphyService.get(author.name).subscribe(url => author.giphyUrl = url);
               } else {
                 console.log(`Author with id '${id}' not found, returning to list`);
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
     this.router.navigate(['/author-list']);
   }

   save(form: NgForm) {
     this.authorService.save(form).subscribe(result => {
       this.gotoList();
     }, error => console.error(error));
   }

   remove(href) {
     this.authorService.remove(href).subscribe(result => {
       this.gotoList();
     }, error => console.error(error));
   }
}
