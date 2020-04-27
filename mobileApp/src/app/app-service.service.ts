import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {

  constructor(private http: HttpClient) { }
  contactNumber(data){
    let url ='http://localhost:9091/number/probability?number='+data;
    console.log(url);
    return this.http.get(url);
  }
}
