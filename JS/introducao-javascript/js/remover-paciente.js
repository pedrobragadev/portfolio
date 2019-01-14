var tabela = document.querySelector("#tabela-pacientes");

tabela.addEventListener("dblclick", function(e){
  e.preventDefault;
  e.target.parentNode.classList.add("fadeOut");

  setTimeout(function(){
      e.target.parentNode.remove();
  },550);

})
