import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  errorMsg= 'An error occured during loading the page'
  
  constructor() { }

  ngOnInit(): void {
  }

}
