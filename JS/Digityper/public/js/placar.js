const placar = $('.placar');

function inserePlacar() {
    let corpoTabela = placar.find('tbody');
    let usuario = "Pedro";
    let numPalavras = $('#contador-palavras').text();

    let linha = insereLinha(usuario, numPalavras);
    linha.find('.botao-remover').click(removeLinha);
    corpoTabela.append(linha);

    placar.slideDown(500);
    scrollPlacar();
}

function insereLinha(usuario, palavras) {
    let linha = $('<tr>');
    let colunaUsuario = $('<td>').text(usuario);
    let colunaPalavras = $('<td>').text(palavras);
    let colunaExcluir = $('<td>');

    let link = $('<a>').attr('href','#').addClass('botao-remover');
    let icone = $('<i>').addClass('small material-icons').text('delete');
    link.append(icone);
    colunaExcluir.append(link);

    linha.append(colunaUsuario);
    linha.append(colunaPalavras);
    linha.append(colunaExcluir);

    return linha;
}

function removeLinha(e) {
    e.preventDefault();

    let linha = $(this).parent().parent();
    linha.fadeOut(600, function () {
        linha.remove();
    })
}

function mostraPlacar() {
    placar.stop().slideToggle(600);
}

function scrollPlacar() {
    let posicaoPlacar = placar.offset().top;

    $('body, html').animate({
        scrollTop: posicaoPlacar + "px"
    }, 1000);
}