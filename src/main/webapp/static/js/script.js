function addProduct(name="unknown product") {

//local storage

    fetch("http://localhost:8080/api/product", {
        method: "POST",
        body: JSON.stringify({name})
    })//.then(response => response.json())
        .then(response => {
            console.log(name);
            alert("Added: "+name);
            let cart = document.getElementsByClassName('customer_cart')[0];
            cart.insertAdjacentHTML('beforeend', '<div class="customer_products">---'+name+'</div>');
            console.log(response);
        })

}