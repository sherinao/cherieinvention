import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { PublisherService } from '../../../services/publisher/publisher.service';
import { GiphyService } from '../../../services/giphy/giphy.service';
import { NgForm,} from '@angular/forms';

@Component({
  selector: 'app-publisher-edit',
  templateUrl: './publisher-edit.component.html',
  styleUrls: ['./publisher-edit.component.scss']
})

export class PublisherEditComponent implements OnInit {
 publisher: any = {};
  sub: Subscription;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private publisherService: PublisherService,
              private giphyService: GiphyService) { }

  ngOnInit() {
   this.sub = this.route.params.subscribe(params => {
          const id = params.id;
          if (id) {
            this.publisherService.get(id).subscribe((publisher: any) => {
              if (publisher) {
                this.publisher = publisher;
                this.giphyService.get(publisher.name).subscribe(url => publisher.giphyUrl = url);
              } else {
                console.log(`Publisher with id '${id}' not found, returning to list`);
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
    this.router.navigate(['/publisher-list']);
  }

  save(form: NgForm) {
    this.publisherService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.publisherService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
