import { Component, OnInit } from '@angular/core';
import { PublisherService } from '../../../services/publisher/publisher.service';
import { GiphyService } from '../../../services/giphy/giphy.service'

@Component({
  selector: 'app-publisher-list',
  templateUrl: './publisher-list.component.html',
  styleUrls: ['./publisher-list.component.scss']
})
export class PublisherListComponent implements OnInit {
 publishers: Array<any>;

   constructor(private publisherService: PublisherService, private giphyService: GiphyService) { }

   ngOnInit() {
     this.publisherService.getAll().subscribe(data => {
       this.publishers = data;
       for (const publisher of this.publishers) {
               this.giphyService.get(publisher.name).subscribe(url => publisher.giphyUrl = url);
       }
     });
   }
}
