document.addEventListener('DOMContentLoaded', () => {
  const homeButton = document.getElementById('home-button');
  const scannerButton = document.getElementById('scanner-button');
  const tableBody = document.querySelector('#product-details-table tbody');

  // Redirect to home page
  homeButton.addEventListener('click', () => {
    window.location.href = 'index.html';
  });

  // Redirect to scanner page
  scannerButton.addEventListener('click', () => {
    window.location.href = 'scanner.html';
  });

  // Get barcode from URL
  const urlParams = new URLSearchParams(window.location.search);
  const barcode = urlParams.get('barcode');

  // Fetch product details from Spring Boot backend
  fetch(`/api/products/${barcode}`)
    .then(response => response.json())
    .then(data => {
      console.log(data); // Check what the response looks like here
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${data.productName}</td>
        <td>${data.barcode}</td>
        <td>${data.ingredients.join(', ')}</td>
      `;
      tableBody.appendChild(row);
    })
    .catch(err => {
      console.error('Error fetching product details:', err);
    });
});
