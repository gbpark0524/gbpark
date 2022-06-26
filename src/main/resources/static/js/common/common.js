window.addEventListener('load', function() {
    prohibitIE();
});

function giveOverEvent(nodes) {
    Array.prototype.forEach.call(nodes, function(e){
        // 마우스 오버 이벤트
        e.addEventListener("mouseover",function(event) {
            if(event.target.tagName.toLowerCase() === "li"){
                event.target.classList.add("current");
            }else if(event.target.tagName.toLowerCase() === "a") {
                event.target.parentElement.classList.add("current");
            }
        });
        e.addEventListener("mouseout",function() {
            Array.prototype.forEach.call(nodes, function(e){
                e.classList.remove("current");
            });
        });
    });
}

function prohibitIE() {
    if(checkIE()) {
        alert("본 페이지는 ie를 지원하지 않습니다. \n 다른 브라우저를 이용하시기 바랍니다.");
        window.close();
    }
}

function checkIE() {
    const ua = window.navigator.userAgent;
    const msie = ua.indexOf('MSIE ');
    const trident = ua.indexOf('Trident/');

    return (msie > 0 || trident > 0);
}

function setDisplay(selector, display) {
    const nodes = document.querySelectorAll(chkSelector(selector));
    Array.prototype.forEach.call(nodes, function(e){
        e.style.display = display;
    });
}

function chkSelector(selector) {
    if(selector.indexOf(".") !== 0 && selector.indexOf("#") !== 0) {
        const sel = selector.includes("-") ? "." : "#";
        selector = sel + selector;
    }
    return selector;
}

function classToggle(selector, class1, class2) {
    const nodes = document.querySelectorAll(chkSelector(selector));
    Array.prototype.forEach.call(nodes, function(e){
        e.classList.toggle(class1);
        if(typeof class2 != 'undefined') {
            e.classList.toggle(class2);
        }
    });
}

// modal
function initModal(modalId, contId, btnId, ...closeIds) {
    const modal = document.getElementById(modalId);
    const btnModal = document.getElementById(btnId);
    const contModal = document.getElementById(contId);

    if (!modal || !btnModal || !contModal) return false;

    btnModal.onclick = function() {
        modal.style.display = "flex";
        modal.parentElement.classList.add("cant-scroll");
    }
    modal.onclick = function () {
        closeModal(modalId);
    }

    for (const closeId of closeIds) {
        try {
            document.getElementById(closeId).onclick = function () {closeModal(modalId)};
        } catch (e) {console.log(e)}
    }

    contModal.addEventListener('click', e => {
        e.stopImmediatePropagation();
    });
}

function closeModal(modalId) {
    const modal = document.getElementById(modalId);
    modal.style.display = "none";
    modal.parentElement.classList.remove("cant-scroll");
}
// modal end

function showToast(toastId) {
    const modal = document.getElementById(toastId);
    modal.classList.remove('hide');
    setTimeout(function() {
        modal.classList.add('show');
    }, 100);

    setTimeout(function() {
        hideToast(toastId);
    },7000);
}

function hideToast(toastId) {
    const modal = document.getElementById(toastId);
    modal.classList.remove('show');
    setTimeout(function() {
        modal.classList.add('hide');
    }, 2000);
}