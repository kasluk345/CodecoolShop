function addProduct(name="unknown product") {
    console.log(name);
    alert("Added: "+name);
    let cart = document.getElementsByClassName('customer_cart')[0];
    cart.insertAdjacentHTML('beforeend', '<div class="customer_products">---'+name+'</div>');

}