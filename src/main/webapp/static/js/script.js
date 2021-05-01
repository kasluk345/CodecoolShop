function addProduct(product="unknown product") {
    //local storage

    let productDict = getDict(product);
    let productName = productDict.name; //product.split(":")[2].split(",")[0];
    let productPrice = parseFloat(productDict.defaultPrice.replace(",",".")).toFixed(2);

    fetch("http://localhost:8080/api/product", {
        method: "POST",
        body: JSON.stringify(productDict)
    })//.then(response => response.json())
        .then(response => {
            insertProductToCart(productName,productPrice)
            alert("Added: "+productName);
            updateTotalPrice();
            console.log(response);
        })
}

function getDict(product) {
    console.log(product)
    let productDict = {};
    //INPUT: product as below
    //{"id: 3, name: Amazon Fire HD 8, defaultPrice: 89,00, category: magic_wand, supplier: Eeylops Owl Emporium"}
    let all = product.split(", ");
    for (let i = 0; i < all.length; i++) {
        //add pair key:value to productDict
        productDict[all[i].split(":")[0]] = all[i].split(":")[1];
    }
    //let test = { "name":"John", "age":30, "city":"New York"};
    return productDict;
}

function insertProductToCart(productName, productPrice){
    let cart = document.getElementsByClassName('customer_cart')[0];
    cart.insertAdjacentHTML('beforeend',
        '<div class="customer_products">' +
        '<span class="customer_product_name">---'+productName+'</span>' +
        '<span class="customer_product_price"> | '+productPrice+'</span>' +
        '</div>');
}

function updateTotalPrice() {
    let totalPrice = 0.0;
    let allProducts = document.getElementsByClassName('customer_product_price');

    console.log(allProducts);

    for(product of allProducts) {
        console.log(product.innerText);
        totalPrice += parseFloat(product.innerText.replace("|",""));
        console.log(totalPrice.toFixed(2));
    }

    document.getElementById("total_price").innerText = totalPrice.toFixed(2);
}