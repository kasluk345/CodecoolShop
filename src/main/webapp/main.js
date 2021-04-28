const BASE_URL = 'http://localhost:8080';




(() => {
    console.log(document.getElementById('submit'));
    document.getElementById('submit').addEventListener('click', () => {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        fetch(`${BASE_URL}/login`, {
            method: 'POST',
            body: JSON.stringify({username, password})
        }).then(response => response.json())
            .then(response => console.log(response));
    });
})();