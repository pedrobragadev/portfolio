$('#btn-shuffle').click(randomText);
$('#btn-search').click(searchText);
$('#btn-sync').click(syncScoreboard);

function randomText() {
    $('#button-bar').hide();
    $('#spinner').show();

    $.get("http://localhost:3000/frases",changeText)
        .fail(function () {
            $('#error').show();
            setTimeout(function () {
                $('#error').hide();
            }, 4000);
        })
        .always(function () {
            $('#button-bar').show();
            $('#spinner').hide();
        });

}

function changeText(data) {
    let text = $('.frase');
    let randomNumber = Math.floor(Math.random() * data.length);
    text.text(data[randomNumber].texto);
    atualizaTamanhoFrase();
    attInitialTime(data[randomNumber].tempo);
}

function searchText() {
    $('#button-bar').hide();
    $('#spinner').show();
    let idSearched = $('#phrase-id').val();
    let idObj = {id: idSearched};

    $.get("http://localhost:3000/frases",idObj,changeSearchedText)
        .fail(function () {
            $('#error').show();
            setTimeout(function () {
                $('#error').hide();
            }, 4000);
        })
        .always(function () {
            $('#button-bar').show();
            $('#spinner').hide();
        });
}

function changeSearchedText(data) {
    let text = $('.frase');
    text.text(data.texto);
    atualizaTamanhoFrase();
    attInitialTime(data.tempo);
}

function syncScoreboard() {
    let scoreboard = [];
    let lines = $("tbody>tr");

    lines.each(function () {
        let user = $(this).find("td:nth-child(1)").text();
        let words = $(this).find("td:nth-child(2)").text();

        let score = {
            usuario: user,
            pontos: words
        };
        scoreboard.push(score);

    });

        let objScore = {
            placar: scoreboard
        };

    $.post("http://localhost:3000/placar", objScore, function () {
        $('#sucess').show();
        setTimeout(function () {
            $('#sucess').hide();
        }, 4000);});
}

function attScoreboard() {
    $.get("http://localhost:3000/placar", function (data) {
        $(data).each(function () {
            let line = insereLinha(this.usuario, this.pontos);

            line.find(".botao-remover").click(removeLinha);

            $("tbody").append(line);
        });
    });
}
