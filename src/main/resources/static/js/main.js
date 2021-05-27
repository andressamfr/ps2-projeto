let formJogos = document.getElementById("formJogos");

formJogos.addEventListener('submit', async (event) => {
    event.preventDefault();

    let formData = new FormData(formJogos);
    let requestJson = JSON.stringify(Object.fromEntries(formData));
    console.log(requestJson);
    await fetch('/api/jogos', {
        method: 'POST',
        headers: {
            // 'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: requestJson
    }).then((response) => {
        console.log(response);
    }).catch(err => console.log(err)); 
})