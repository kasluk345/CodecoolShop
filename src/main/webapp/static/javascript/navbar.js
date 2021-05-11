

function dynamicMargin(){
    let gLabel = document.getElementById("search-bar");
    let style = window.getComputedStyle(gLabel, null);
    document.getElementById("empty-div").style.width = style.getPropertyValue("width");
}

window.onload = dynamicMargin;

