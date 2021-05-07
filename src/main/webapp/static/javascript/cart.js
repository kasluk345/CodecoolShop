function addProduct(product="unknown product") {

    let productJSON = getDict(product);

    fetch("http://localhost:8080/api/product", {
        method: "POST",
        body: JSON.stringify(productJSON)
    })//.then(response => response.json())
        .then(response => {
            manageProducts(productJSON);
            updateTotalPrice();
            console.log(response);
        })
}

function getDict(product) {
    let productDict = {};
    //INPUT: product as below
    //{"id: 3, name: Amazon Fire HD 8, defaultPrice: 89,00, category: magic_wand, supplier: Eeylops Owl Emporium"}
    let all = product.split(", ");
    for (let i = 0; i < all.length; i++) {
        //add pair key:value to productDict
        productDict[all[i].split(":")[0]] = all[i].split(":")[1];
    }
    return productDict;
}

function manageProducts(productJSON) {
    let productID = productJSON.id;
    let productName = productJSON.name; //product.split(":")[2].split(",")[0];
    let productPrice = parseFloat(productJSON.defaultPrice.replace(",",".")).toFixed(2);

    if(!updateProductInCart(productID,"+")) {
        insertProductToCart(productID, productName, productPrice);
    }
}

function insertProductToCart(productID,productName, productPrice, productQuantity=1){
    let cart = document.getElementsByClassName('customer_products')[0];
    cart.insertAdjacentHTML('beforeend',
        '<tr class="customer_products" >' +
        '<td class="customer_product_ID" hidden>'+productID+'</td>' +
        '<td class="customer_product_name">'+productName+'</td>' +
        '<td class="customer_product_quantity">'+productQuantity+'</td>' +
        '<td class="customer_product_price">'+productPrice+'</td>' +
        '<td class="customer_product_remove" onclick="removeFromList(this)">remove</td>' +
        '</tr>');
}

function updateTotalPrice() {
    let totalPrice = 0.0;
    let allProductsPrice = document.getElementsByClassName('customer_product_price');
    let allProductsQuantity = document.getElementsByClassName('customer_product_quantity');

    for(let i=1; i<allProductsPrice.length;i++) {
        totalPrice += parseFloat(allProductsPrice[i].innerText * allProductsQuantity[i].innerText);
    }
    document.getElementById("total_price").innerText = totalPrice.toFixed(2);
}

function removeFromList(HTMLelement){
    let elementToRemove = HTMLelement.parentElement;
    let elementToRemoveID = elementToRemove.childNodes[0].innerText.replace(" ","");

    fetch("http://localhost:8080/api/product/del", {
        method: "DELETE",
        body: elementToRemoveID //remove backend
    }).then(response => {
            //remove frontend
            updateProductInCart(elementToRemoveID,"-");
            if(elementToRemove.childNodes[2].innerText==0) {elementToRemove.remove();}
            updateTotalPrice();
            console.log(response);
        })
}

function clearCart(){
    //remove backend
    fetch("http://localhost:8080/api/product/del", {
        method: "DELETE",
        body: "-1"
    })//.then(response => response.json())
        .then(response => {
            //remove frontend
            deleteAllProducts();
            updateTotalPrice();
            console.log(response);
        })
}

function deleteAllProducts() {
    let cart = document.getElementsByClassName("customer_products");
    for(let i=1;i<cart.length;i++) {
        cart[i].remove();
    }
}

function updateProductInCart(productID,operation="+") {
    let cart = document.getElementsByClassName("customer_products");
    let updatedQuantity;
    for(product of cart) {
        let prodID = product.childNodes[0].innerText; //current product ID
        if(parseInt(prodID) == parseInt(productID)) {
            let previousQuantity = product.childNodes[2].innerText
            if(operation==="+") {
                updatedQuantity = parseInt(previousQuantity) + 1;
            } else if(operation==="-"){
                updatedQuantity = parseInt(previousQuantity) - 1;
            }
            product.childNodes[2].innerText = updatedQuantity;

            return true; //update existing
        }
    }
    return false; // add new product
}

function getProducts() {
    // get product from backend (cartDao)
    fetch("http://localhost:8080/api/product/get", {  //example url: http://swapi.dev/api/planets/1/
        method: "GET",
    }).then(response => response.json())
        .then(response => {loadProducts(response);})
/*            .then(res => res.text())          // convert to plain text
                .then(text => console.log(text));*/
}

function loadProducts(productsList) {
    //display product on frontend
    for(let i=0;i<productsList.ProductsInCart.length;i++) {
        let productJSON = productsList.ProductsInCart[i];
        manageProducts(productJSON)
    }
    updateTotalPrice();
}

window.onload = function(){ getProducts()}; // load products to cart when open / index site