function changeTotal(name, items) {
    var count = Number(document.getElementsByName(name)[0].value);
    var priceString = document.getElementsByName(name + ".price")[0].textContent;
    priceString = priceString.substring(0, priceString.length - 1);
    var price = Number(priceString);
    var total = count * price;
    document.getElementsByName(name + ".subTotal")[0].textContent = total + "$";
    for(var i = 0; i < items.length; i++) {
        if (items[i] !== name) {
            count = Number(document.getElementsByName(items[i])[0].value);
            priceString = document.getElementsByName(items[i] + ".price")[0].textContent;
            priceString = priceString.substring(0, priceString.length - 1);
            price = Number(priceString);
            total += count * price;
        }
    }
    document.getElementsByName("total")[0].textContent = total + "$";
}