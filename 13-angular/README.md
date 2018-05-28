# Architektura

- Component - "strona", posiada szablon html i kontroler
- Service - miejsce na logikę
- Router - definiuje nawigację między stronami
- Module - aplikację można podzielić na moduły, aplikacja musi mieć co najmniej jeden moduł (*root module*)

[Więcej informacji](https://angular.io/guide/architecture)

Fronendowy kod będziemy pisać w [Typescripcie](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)

# Demo

## Instalacja

### Node i NPM
Uruchom skrypt instalujący node JS:
```bash
./install-node.sh
```
### ng-cli

Więcej: https://github.com/angular/angular-cli#installation

```bash
npm install -g @angular/cli
```

## Jak używać

[Więcej o używaniu ng-cli](https://github.com/angular/angular-cli#usage)

### Tworzenie projektu
```bash
ng new my-first-ng-app --routing
cd my-first-ng-app
```

### Uruchomienie projektu
```bash
ng serve
```


### Struktura projektu
Jeśli wszystko zadziałało poprawnie, pod adresem http://localhost:4200/ będzie dostępna strona naszej aplikacji.

Kod aplikacji jest w `src/`, znajdziemy tam m.in. `index.html`.

Miejsce na testy to `e2e/`.

W `src/app` znajdziemy główny komponent, a w nim:
- app.component.css - miejsce na klasy css dla tego komponentu (globalne klasy umieścić można w `src/styles.css`)
- app.component.html - szablon html komponentu
- app.component.spec.ts - testy
- app.component.ts - kod kontrolera
- app.module.ts - definicję głównego modułu
- app-routing.module.ts - moduł z routerem, dodany dlatego że w `ng new` dodaliśmy przełącznik `--routing`

### Dodawanie nowego service'u
```bash
ng generate service data
```

Nowy service został `src/app/data.service.ts`, zmieńmy to co w nim jest na:
```typescript
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private list: Data[] = [];

  constructor() {
    this.list.push({name: 'John', number: 13});
    this.list.push({name: 'Joan', number: 12});
  }

  addData(d: Data) {
    this.list.push(d);
  }

  getData(): Data[] {
    return this.list;
  }

}

export class Data {
  name: string;
  number: number;
}

```
### Dodawanie nowych komponentów/stron
Dodajmy teraz nowy komponent, w którym skorzystamy z powyższego service'u:
```bash
ng g component list
```

Żeby nowy komponent był dostępny pod pewnym URLem, dodajmy go do routes w `app-routing.module.ts`:
```typescript
import {ListComponent} from './list/list.component';

const routes: Routes = [{ path: 'list', component: ListComponent }];
```

Aby sprawdzić, czy to działa, otwórz w przeglądarce http://localhost:4200/list

### Wykorzystanie danych z service'u
W komponencie `list.component.ts`, pobierzmy dane z service'u i przypiszmy do pola dataList:
```typescript
import {Component, OnInit} from '@angular/core';
import {Data, DataService} from '../data.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  dataList: Data[];

  constructor(private list: DataService) {
  }

  ngOnInit() {
    this.dataList = this.list.getData();
  }
}
```

Teraz, dodajmy tabelkę w szablonie html `list.component.html`:
```html
<div>
  <table>
    <thead>
    <tr>
      <th>Name</th>
      <th>Number</th>
    </tr>
    </thead>
    <tbody>
    <tr *ngFor="let data of dataList">
      <td>{{data.name}}</td>
      <td>{{data.number}}</td>
    </tr>
    </tbody>
  </table>
</div>

```

### Formularz
Stwórzmy prosty formularz dzięki któremu dodamy kolejne wpisy:
```bash
ng g component new-data
```

Dodajmy nowy komponent do routera w `app-routing.module.ts`:
```typescript
import {NewDataComponent} from './new-data/new-data.component';

const routes: Routes = [
  {path: 'list', component: ListComponent},
  {path: 'new-data', component: NewDataComponent}
];
```

W `app.modules.html` możemy utworzyć proste menu:
```html
<ul>
  <li><a routerLink="/list">data list</a></li>
  <li><a routerLink="/new-data">new data</a></li>
</ul>

<router-outlet></router-outlet>
```

Będziemy potrzebowali zależności od kolejnego angularowego modułu (do dodania w `app.module.ts`):
```typescript
import { FormsModule } from '@angular/forms';

...
imports: [
    ...
    FormsModule
  ],
```

Stwórzmy nowy formularz w `src/app/new-data/new-data.component.html`:
```html
<form (submit)="addData()">
  <label for="name">Name</label>
  <input type="text" id="name" [(ngModel)]="newData.name"/>
  <label for="number">Number</label>
  <input type="text" id="number" [(ngModel)]="newData.number"/>

  <button type="submit">Save</button>
</form>

```

I dodajmy kod kontrolera do `src/app/new-data/new-data.component.ts`:
```typescript
import {Component, OnInit} from '@angular/core';
import {Data, DataService} from '../data.service';

@Component({
  selector: 'app-new-data',
  templateUrl: './new-data.component.html',
  styleUrls: ['./new-data.component.css']
})
export class NewDataComponent implements OnInit {

  newData: Data;

  constructor(private dataService: DataService) {
    this.newData = new Data();
  }

  ngOnInit() {
  }

  save() {
    this.dataService.addData(this.newData);
  }


}
```

## Jak używać z Javą i mavenem
