import { Component, OnInit } from '@angular/core';
import { AuthorService } from '../../../services/author/author.service';
import { GiphyService } from '../../../services/giphy/giphy.service'

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.scss']
})
export class AuthorListComponent implements OnInit {

    authors: Array<any>;

     constructor(private authorService: AuthorService, private giphyService: GiphyService) { }

     ngOnInit() {
       this.authorService.getAll().subscribe(data => {
         this.authors = data;
         for (const author of this.authors) {
                 this.giphyService.get(author.name).subscribe(url => author.giphyUrl = url);
         }
       });
     }
}
