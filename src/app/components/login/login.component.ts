import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Credenciais } from 'src/app/models/credenciais';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private toast: ToastrService,
    private service: AuthService,
    private router: Router) { }

  creds: Credenciais = {
    email: '',
    senha: ''
  }

  email = new FormControl(null, Validators.email);
  senha = new FormControl(null, Validators.minLength(3));

  ngOnInit(): void {
  }


  logar() {
    this.service.authenticate(this.creds).subscribe(
      (resposta: HttpResponse<string>) => {
        const authorizationHeader = resposta.headers.get('Authorization');
        if (authorizationHeader) {
          const token = authorizationHeader.substring(7);
          this.service.successfulLogin(token);
          this.router.navigate([''])
        } else {
          console.error('O cabeçalho de autorização não está presente na resposta.');
        }
      },
      (error: any) => {
        this.toast.error('Ocorreu um erro ao fazer a solicitação:', 'Login');
      }
    );
  }

  validaCampos(): boolean {
    return this.email.valid && this.senha.valid
  }


}
