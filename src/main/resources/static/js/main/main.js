window.onload = (event) => {
	getNotionList(10);
};

/*
* modal event
*/
document.getElementById('toMeModal').addEventListener('shown.bs.modal', function () {
	document.getElementById('tome_title').focus();
});
// const toMeModal = new bootstrap.Modal(document.getElementById('toMeModal'));
//
// const toastEmpty = document.querySelector('.toast');
// const alertEmpty = new bootstrap.Toast(toastEmpty);

function sendMsg() {
	// title
	const title = document.getElementById("tome_title").value;
	const tel = document.getElementById("tome_tel").value;
	const message = document.getElementById("tome_message").value;
	toMeSave(title, tel, message);
}

/*
* notion
 */
function getNotionList(pageSize) {
	const loading = document.getElementById('loading-notion');
	loading.removeAttribute('hidden');
	const requestOptions = {
		method: 'GET',
		redirect: 'follow'
	};

	fetch("/notion?pageSize=" + pageSize, requestOptions)
		.then(response => response.json())
		.then(json => {
			loading.setAttribute('hidden', '');
			displayNotionList(json.results);
		})
		.catch(error => console.log('error', error));
}

function displayNotionList(results) {
	const notionList = document.getElementById("list-notion");
	while (notionList.hasChildNodes()) {
		notionList.removeChild(notionList.firstChild);
	}
	for (const result of results) {
		const list = document.createElement('li');
		list.className = "child-notion";
		const link = document.createElement('a');
		link.setAttribute("href", result.url);
		const title = result.properties.title.title[0].plain_text;
		link.innerText = title.replace("- log", "") + " : " + result.last_edited_time.substring(0, 10);
		notionList.appendChild(list);
		list.appendChild(link);
	}
}

/*
* to me
*/
function toMeSave(title, tel, message) {
	if (!title || !message) {
		alertEmpty.show();
		return;
	}

    var formdata = new FormData();
    formdata.append("title", title);
    formdata.append("message", message);
    formdata.append("tel", tel);

	const requestOptions = {
		method: 'POST',
		body: formdata,
		redirect: 'follow'
	};

	fetch("/tome", requestOptions)
		.then(response => response.text())
		.then(result => alert(result))
		.then(() => toMeModal.hide())
		.catch(error => alert(error))
		.then(error => console.log(error));
}
