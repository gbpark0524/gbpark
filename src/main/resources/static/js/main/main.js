window.onload = (event) => {
	getNotionList(10);
	initModal("modalToMe", "modalContents", "btnModal", "closeModal", "btnCloseModal");
};

/*
* modal event
*/

function sendMsg() {
	if (chkToMe()) {
		postToMe();
		closeModal("modalToMe")
	}
}

/*
* notion
 */
function getNotionList(pageSize) {
	const requestOptions = {
		method: "GET",
		redirect: "follow"
	};

	fetch("/notion?pageSize=" + pageSize, requestOptions)
		.then(response => response.json())
		.then(({results}) => {
			setDisplay("loadingNotion","none")
			displayNotionList(results);
		})
		.catch(error => console.log("error", error));
}

function displayNotionList(results) {
	const notionList = document.getElementById("list-notion");
	while (notionList.hasChildNodes()) {
		notionList.removeChild(notionList.firstChild);
	}
	for (const {url, properties:{title:{title}}} of results) {
		const {plain_text} = title[0];
		const list = document.createElement("li");
		list.className = "child-notion";
		const link = document.createElement("a");
		link.setAttribute("href", url);
		link.innerText = plain_text.replace("- log", "")/* + " : " + result.last_edited_time.substring(0, 10)*/;
		notionList.appendChild(list);
		list.appendChild(link);
	}
}

/*
* to me
*/
function chkToMe() {
	const title = document.getElementById("toMeTitle").value;
	const message = document.getElementById("toMeMessage").value;
	if (!title || !message) {
		showToast('toastToMe');
		return false;
	}
	return true;
}

function postToMe() {
	const form = document.getElementById("formToMe");
	const [title, message, tel] = form;
	const formData = new FormData();
	formData.append("title", title.value);
	formData.append("message", message.value);
	formData.append("tel", tel.value);

	const requestOptions = {
		method: "POST",
		body: formData,
		redirect: "follow"
	};

	fetch("/tome", requestOptions)
		.then(response => response.text())
		.then(result => alert(result))
		.then(() => form.reset())
		.catch(error => alert(error))
		.then(error => console.log(error));
}