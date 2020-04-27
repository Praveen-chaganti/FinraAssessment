import { Component } from '@angular/core';
import {FormBuilder, Validators, RequiredValidator, FormControl, FormGroup} from '@angular/forms';
import { OnInit } from '@angular/core';
import { AppServiceService } from './app-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  contactForm: FormGroup;
  pNumbers: any;
  buttonClicked = false;
  constructor(private formBuilder: FormBuilder, private service: AppServiceService){}
  ngOnInit(){
  this.contactForm=  this.formBuilder.group({
    phoneNumber: ['', Validators.compose([Validators.required, this.checkLength])],
});
}
  checkLength(value: FormControl) {
    let phoneNumber = value.value;
    console.log(value);
    let valid = {};
    if (phoneNumber) {
      let number = value.value.toString();
    // let number;
      console.log(number.length);
      if (number.length == 7 || number.length == 10) {
        valid = {};
      } else {
        valid = { numberLength: true }
      }
    } else {

    }

    return valid;

  }
contact(){
    this.buttonClicked = true;
 if(this.contactForm.valid){
   this.buttonClicked = false;
   this.service.contactNumber(this.contactForm.getRawValue().phoneNumber).subscribe( (data) =>
   {
     this.pNumbers = data;
     console.log(this.pNumbers)
   });
 } else {
   this.pNumbers = null;
 }

}
}
