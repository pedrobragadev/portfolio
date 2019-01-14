var campoFiltro = document.querySelector("#filtrar-tabela");

campoFiltro.addEventListener("input", function(){

  var pacientes = document.querySelectorAll(".paciente");
  var regex = new RegExp(this.value, "i");

    for (var i = 0; i < pacientes.length; i++){
        var paciente = pacientes[i];
        var nome = paciente.querySelector(".info-nome").textContent;

        if(!regex.test(nome)){
          paciente.classList.add("invisivel");
        } else{
          paciente.classList.remove("invisivel");
        }
        if(this.value.length <= 0) {
          paciente.classList.remove("invisivel");
        }
    }

});
