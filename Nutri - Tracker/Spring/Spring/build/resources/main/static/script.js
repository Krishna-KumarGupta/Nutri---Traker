// Sample data to simulate product search
const products = [
    {
        name: "Maggie Noodles",
        barcode: "8901058905090",
        ingredients: "Wheat Flour, Palm Oil, Salt, Sugar",
        imageUrl: "https://example.com/images/maggie.jpg"
    },
    {
        name: "Amul Butter",
        barcode: "8901268406661",
        ingredients: "Milk, Salt",
        imageUrl: "https://example.com/images/amul_butter.jpg"
    },
    {
        name: "Coca Cola",
        barcode: "8901809000837",
        ingredients: "Carbonated Water, Sugar, Caffeine",
        imageUrl: "https://example.com/images/coca_cola.jpg"
    },
    {
        name: "Maggie Noodles",
        barcode: "8901058905090",
        ingredients: "Wheat Flour, Palm Oil, Salt, Sugar",
        imageUrl: "https://example.com/images/maggie.jpg"
    }
];

// Function to render the products
function renderProducts(productList) {
    const productContainer = document.getElementById('product-list');
    productContainer.innerHTML = '';

    productList.forEach(product => {
        const productElement = document.createElement('div');
        productElement.className = 'product-item';

        productElement.innerHTML = `
            <img src="${product.imageUrl}" alt="${product.name}">
            <h2>${product.name}</h2>
            <p>Barcode: ${product.barcode}</p>
            <p>Ingredients: ${product.ingredients}</p>
        `;

        productContainer.appendChild(productElement);
    });
}

// Function to handle search
function handleSearch() {
    const query = document.getElementById('search-bar').value.toLowerCase();
    const filteredProducts = products.filter(product =>
        product.name.toLowerCase().includes(query)
    );
    renderProducts(filteredProducts);
}

// Attach the search handler to the input field
document.getElementById('search-bar').addEventListener('input', handleSearch);

// Initially render all products
renderProducts(products);

// script.js
document.addEventListener('DOMContentLoaded', () => {
    const scannerButton = document.getElementById('scanner-button');

    scannerButton.addEventListener('click', () => {
        window.location.href = 'scanner.html';
    });
});
