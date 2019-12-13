//---Angular Material Components--------------------:
import { MatCheckboxModule } from '@angular/material';
import { MatButtonModule } from '@angular/material';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
//---end of material imports----------------------------------
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FlexLayoutModule } from "@angular/flex-layout";
import { BookListComponent } from './components/book/book-list/book-list.component';
import { BookEditComponent } from './components/book/book-edit/book-edit.component';
import { AuthorListComponent } from './components/author/author-list/author-list.component';
import { AuthorEditComponent } from './components/author/author-edit/author-edit.component';
import { PublisherListComponent } from './components/publisher/publisher-list/publisher-list.component';
import { PublisherEditComponent } from './components/publisher/publisher-edit/publisher-edit.component';
import { HomeComponent } from './components/home/home.component';
import { SidenavListComponent } from './components/navigation/sidenav-list/sidenav-list.component';
import { InventoryEditComponent } from './components/inventory/inventory-edit/inventory-edit.component';
import { InventoryListComponent } from './components/inventory/inventory-list/inventory-list.component';
import { MediaComponent } from './components/barcode/media/media.component';
// the scanner!
import { ZXingScannerModule } from '@zxing/ngx-scanner';

const routes: Routes = [

   { path: '', redirectTo: '/home', pathMatch: 'full' },
   { path: 'home', component: HomeComponent },
   { path: 'book-list', component: BookListComponent },
   { path: 'book-add', component: BookEditComponent },
   { path: 'book-edit/:id', component: BookEditComponent },
   { path: 'inventory-list', component: InventoryListComponent },
   { path: 'inventory-add', component: InventoryEditComponent },
   { path: 'inventory-edit/:id', component: InventoryEditComponent },
   { path: 'author-list', component: AuthorListComponent },
   { path: 'author-add', component: AuthorEditComponent },
   { path: 'author-edit/:id', component: AuthorEditComponent },
   { path: 'publisher-list', component: PublisherListComponent },
   { path: 'publisher-add', component: PublisherEditComponent },
   { path: 'publisher-edit/:id', component: PublisherEditComponent },
   { path: 'barcode/:id', component: MediaComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookEditComponent,
    AuthorListComponent,
    PublisherListComponent,
    AuthorEditComponent,
    PublisherEditComponent,
    HomeComponent,
    SidenavListComponent,
    InventoryEditComponent,
    InventoryListComponent,
    MediaComponent
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes, { enableTracing: true } ),
    HttpClientModule,
    FormsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    FlexLayoutModule,
    ZXingScannerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
