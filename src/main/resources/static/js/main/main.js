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
		.then(json => {
			setDisplay("loadingNotion","none")
			displayNotionList(json.results);
		})
		.catch(error => console.log("error", error));
}

function displayNotionList(results) {
	const notionList = document.getElementById("list-notion");
	while (notionList.hasChildNodes()) {
		notionList.removeChild(notionList.firstChild);
	}
	for (const result of results) {
		const list = document.createElement("li");
		list.className = "child-notion";
		const link = document.createElement("a");
		link.setAttribute("href", result.url);
		const title = result.properties.title.title[0].plain_text;
		link.innerText = title.replace("- log", "")/* + " : " + result.last_edited_time.substring(0, 10)*/;
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
	const formData = new FormData();
	const {value} = form["title"];
	formData.append("title", value);
	formData.append("message", form["message"].value);
	formData.append("tel", form["tel"].value);

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