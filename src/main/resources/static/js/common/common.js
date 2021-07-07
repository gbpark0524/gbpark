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

