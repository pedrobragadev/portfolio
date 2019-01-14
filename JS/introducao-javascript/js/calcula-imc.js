var titulo = document.querySelector(".titulo");
titulo.textContent = "Aparecida Nutricionista";

var pacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < pacientes.length; i++) {

  paciente = pacientes[i];
  var peso = paciente.querySelector(".info-peso").textContent;
  var altura = paciente.querySelector(".info-altura").textContent;

  var tdImc = paciente.querySelector(".info-imc");

  var pesoEhValido = validaPeso(peso);
  var alturaEhValido = validaAltura(altura);

  if(!alturaEhValido){
    tdImc.textContent = "Altura com erro";
    paciente.classList.add("paciente-invalido");
  }

  if(!pesoEhValido){
    tdImc.textContent = "Peso com erro";
    paciente.classList.add("paciente-invalido");
  }
  if(pesoEhValido && alturaEhValido){
    var imc = calculaImc(peso, altura);
    tdImc.textContent = imc
  }

}

function calculaImc(peso, altura){
  var imc = 0;
  var imc = peso / (altura * altura);
  return imc.toFixed(2);

}

function validaPeso(peso){
  if(peso <= 0 || peso >= 700){
    return false;
  } else{
    return true;
  }
}

function validaAltura(altura){
  if(altura <= 0 || altura >= 2.80){
    return false;
  } else{
    return true;
  }
}
