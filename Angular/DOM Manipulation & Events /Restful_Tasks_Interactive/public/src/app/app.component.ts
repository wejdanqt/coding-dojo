import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  tasks: any;
  clicked = false ; 


  constructor(private _httpService: HttpService){
    
  }
  ngOnInit(){
    this.getTasksFromService();
  }

  onShowAllButtonClick(): void { 
    let observable = this._httpService.getTasks();
    observable.subscribe(data => {
       console.log("Got the data !", data)
       this.tasks = data
       this.clicked = true;
    });
}

onShowButtonClick(id: String){

  console.log(id)
   
}

  getTasksFromService(){
   
  }

}
