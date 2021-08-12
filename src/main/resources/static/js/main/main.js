// modal event
document.getElementById('toMeModal').addEventListener('shown.bs.modal', function () {
    document.getElementById('title').focus();
});

function sendMsg() {
    // title
    const title = document.getElementById("tome_title");
    const message = document.getElementById("tome_message");
    toMeSave(title,message);
}

// to me
function toMeSave(title, message) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "title": title,
        "message": message
    });

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("localhost:8080/tome", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}
