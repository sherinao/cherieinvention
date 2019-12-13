import { Component, OnInit, ViewChild, NgModule  } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { InventoryService } from '../../../services/inventory/inventory.service';
import { ZXingScannerComponent  } from '@zxing/ngx-scanner';
import { Result } from '@zxing/library';


@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.scss']
})

export class MediaComponent implements OnInit {
  @ViewChild('scanner',{static:false})
  scanner: ZXingScannerComponent;

  qrResultString: string;

  inventory: any = {};
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private inventoryService: InventoryService) {}

      ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
          const id = params.id;
          if (id) {
            this.inventoryService.get(id).subscribe((inventory: any) => {
              if (inventory) {
                this.inventory = inventory;

              } else {
                console.log(`Inventory with id '${id}' not found, returning to list`);
               // this.gotoList();
              }
            });
          }
        });
        }



      handleQrCodeResult(resultString: string) {
          console.log('Result: ', resultString);
          this.qrResultString = resultString;
      }
 }
