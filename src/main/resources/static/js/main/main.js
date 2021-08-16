/*
* modal event
*/
document.getElementById('toMeModal').addEventListener('shown.bs.modal', function () {
    document.getElementById('tome_title').focus();
});
const toMeModal = new bootstrap.Modal(document.getElementById('toMeModal'));

const toastEmpty = document.querySelector('.toast');
const alertEmpty = new bootstrap.Toast(toastEmpty);

function sendMsg() {
    // title
    const title = document.getElementById("tome_title").value;
    const message = document.getElementById("tome_message").value;
    toMeSave(title,message);
}

/*
* to me
*/
function toMeSave(title, message) {
    if(!title || !message) {
        alertEmpty.show();
        return;
    }

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

    fetch("/tome", requestOptions)
        .then(response => response.text())
        .then(result => alert(result))
        .then(() => toMeModal.hide())
        .catch(error => alert(error));
}
