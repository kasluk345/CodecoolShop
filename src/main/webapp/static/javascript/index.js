

function dynamicMargin(){
    // let searchWidth= document.getComputedStyle(document.getElementById('search-bar').width);
    // document.getElementById('empty-div').setAttribute("style","width:"+searchWidth+"px");
    let gLabel = document.getElementById("search-bar");
    let style = window.getComputedStyle(gLabel, null);
    document.getElementById("empty-div").style.width = style.getPropertyValue("width");
}

window.onload = dynamicMargin;

