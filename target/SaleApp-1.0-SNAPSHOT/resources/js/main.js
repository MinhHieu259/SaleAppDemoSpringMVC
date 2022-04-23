/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function addComment(productId) {
    fetch(`/SaleApp/api/add-comment`, {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "productId": productId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);

        return res.json();
    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("commentArea");

        area.innerHTML = `
        <div class="row">
               <div class="col-md-2" style="padding: 10px">
                   <img class="rounded-circle img-fluid" src="${data.userId.avatar}"/>
               </div>
               <div class="col-md-10 my-date">
                   <p>${data.content}</p>
                   <i>${moment(data.createdDate).fromNow()}</i>
               </div>
           </div>  
    ` + area.innerHTML
    });
}

function addToCart(id, name, price) {
    event.preventDefault()
    fetch("/SaleApp/api/cart", {
        method: "post",
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data
    })
}

function updateCart(obj, productId) {
    fetch("/SaleApp/api/cart", {
        method: "put",
        body: JSON.stringify({
            "productId": productId,
            "productName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter
        let amount = document.getElementById("amountCart");
        amount.innerText = data.amount
    })
}

function deleteCartItem(productId) {
    if (confirm("Ban co chac muon xoa item nay khong ???") == true) {
        fetch(`/SaleApp/api/cart/${productId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let counter = document.getElementById("cartCounter");
            counter.innerText = data.counter
            let amount = document.getElementById("amountCart");
            amount.innerText = data.amount
            let row = document.getElementById(`product${productId}`)
            row.style.display = "none"
        })
    }
}

function pay() {
    if (confirm("Ban chac chan thanh toan ?") == true) {
        fetch("/SaleApp/api/pay", {
            method: "post"
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.info(code);
            location.reload();
        })
    }
}

