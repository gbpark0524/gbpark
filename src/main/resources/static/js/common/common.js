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
function initModal(modalId, btnId, contId) {
    const modal = document.getElementById(modalId);
    const brnModal = document.getElementById(btnId);
    const contModal = document.getElementById(contId);

    if (!modal || !brnModal || !contModal) return false;

    brnModal.onclick = function() {
        modal.style.display = "flex";
        modal.parentElement.classList.add("cant-scroll");
    }
    modal.onclick = function () {
        modal.style.display = "none";
        modal.parentElement.classList.remove("cant-scroll");
    }

    contModal.addEventListener('click', e => {
        e.stopImmediatePropagation();
    });
}
// modal end