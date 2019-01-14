const campo = $(".campo-digitacao");
const btnReiniciar = $("#btn-restart");
let tempoInicial = $("#tempo-digitacao").text();

$(function(){
    atualizaTamanhoFrase();
    inicializaContadores();
    inicializaCronometro();
    verificaMarcador();
    btnReiniciar.click(reiniciaJogo);
    $('#btn-score').click(mostraPlacar);
    attScoreboard();
});

function atualizaTamanhoFrase() {
    let frase = $(".frase").text();
    let numPalavras = frase.split(" ").length;
    let tamanhoFrase = $("#tamanho-frase");
    tamanhoFrase.text(numPalavras);
}

function inicializaContadores() {
    campo.on("input", function() {
        let conteudo = campo.val();

        let qtdPalavras = conteudo.split(/\S+/).length - 1;
        $("#contador-palavras").text(qtdPalavras);

        let qtdCaracteres = conteudo.replace(/\s+/g,'').length;
        $("#contador-caracteres").text(qtdCaracteres);
    });
}

function inicializaCronometro() {
    let tempoRestante = $("#tempo-digitacao").text();
    campo.one("focus", function() {
        let cronometroID = setInterval(function() {
            tempoRestante--;
            $("#tempo-digitacao").text(tempoRestante);
            if (tempoRestante < 1) {
                clearInterval(cronometroID);
                tempoEsgotado();
            }
        }, 1000);
    });
}

function tempoEsgotado() {
    campo.attr("disabled", true);
    btnReiniciar.removeAttr("disabled");
    btnReiniciar.toggleClass('disabled', false);
    campo.toggleClass('campo-desativado',true);
    inserePlacar();
    $('.placar').stop().slideDown(600);
}

function reiniciaJogo() {
    btnReiniciar.attr("disabled","disabled");
    btnReiniciar.toggleClass('disabled', true);
    campo.attr("disabled", false);
    campo.val("");
    $("#contador-palavras").text("0");
    $("#contador-caracteres").text("0");
    $("#tempo-digitacao").text(tempoInicial);
    campo.toggleClass('campo-desativado',false);
    inicializaCronometro();
    campo.toggleClass('borda-certa',false);
    campo.toggleClass('borda-errada',false);
}

function verificaMarcador() {
    campo.on("input",function () {
        let frase = $('.frase').text();
        let fraseInserida = campo.val();
        if(frase.startsWith(fraseInserida) ){
            campo.toggleClass('borda-certa',true);
            campo.toggleClass('borda-errada',false);
        } else{
            campo.toggleClass('borda-errada',true);
            campo.toggleClass('borda-certa',false);
        }
    })
}

function attInitialTime(tempo) {
    tempoInicial = tempo;
    $("#tempo-digitacao").text(tempo);
}
