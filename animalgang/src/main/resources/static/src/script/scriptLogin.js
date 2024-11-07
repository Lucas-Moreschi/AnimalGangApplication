let usernameRef = document.getElementById("username");
let passwordRef = document.getElementById("password");
let eyeL = document.querySelector(".eyeball-l");
let eyeR = document.querySelector(".eyeball-r");
let handL = document.querySelector(".hand-l");
let handR = document.querySelector(".hand-r");

let normalEyeStyle = () => {
  eyeL.style.cssText = `
    left:0.6em;
    top: 0.6em;
  `;
  eyeR.style.cssText = `
  right:0.6em;
  top:0.6em;
  `;
};

let normalHandStyle = () => {
  handL.style.cssText = `
        height: 2.81em;
        top:8.4em;
        left:7.5em;
        transform: rotate(0deg);
    `;
  handR.style.cssText = `
        height: 2.81em;
        top: 8.4em;
        right: 7.5em;
        transform: rotate(0deg)
    `;
};
//When clicked on username input
usernameRef.addEventListener("focus", () => {
  eyeL.style.cssText = `
    left: 0.75em;
    top: 1.12em;  
  `;
  eyeR.style.cssText = `
    right: 0.75em;
    top: 1.12em;
  `;
  normalHandStyle();
});
//When clicked on password input
passwordRef.addEventListener("focus", () => {
  handL.style.cssText = `
        height: 6.56em;
        top: 3.87em;
        left: 11.75em;
        transform: rotate(-155deg);    
    `;
  handR.style.cssText = `
    height: 6.56em;
    top: 3.87em;
    right: 11.75em;
    transform: rotate(155deg);
  `;
  normalEyeStyle();
});
//When clicked outside username and password input
document.addEventListener("click", (e) => {
  let clickedElem = e.target;
  if (clickedElem != usernameRef && clickedElem != passwordRef) {
    normalEyeStyle();
    normalHandStyle();
  }
});


// EM DESENVOLVIMENTO:

// Adicionando o ouvinte de evento para o envio do formulário de login
document.getElementById('form').addEventListener('submit', function (event) {
    event.preventDefault(); // Impede o envio tradicional do formulário

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const data = {
        login: username,
        password: password
    };

    // Fazer requisição de login
    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Erro ao tentar fazer login. Status: ${response.status}`);
        }
        return response.json(); // Converte a resposta para JSON
    })
    .then(data => {
        if (data.token) {
            localStorage.setItem('authToken', data.token); // Armazena o token
            //alert(`Token recebido: ${data.token}`); // Exibe o token para debug

            window.location.href = '/editar-pets'; // Redireciona para a página protegida
        } else {
            showError('Falha ao obter o token.');
        }
    })
    .catch(error => {
        console.error('Erro ao tentar fazer login:', error);
        showError('Erro ao tentar fazer login.');
    });
});

function showError(message) {
    const errorMessageElement = document.getElementById('error-message');
    errorMessageElement.textContent = message;
    errorMessageElement.style.display = 'block'; // Exibe a mensagem de erro
}

function getAuthToken() {
    return localStorage.getItem('authToken');
}

function fetchWithAuth(url, options = {}) {
    const token = getAuthToken();

    if (token) {
        options.headers = {
            ...options.headers,
            'Authorization': `Bearer ${token}`
        };
    }

    console.log('Headers:', options.headers);

    return fetch(url, options)
        .then(response => {
            if (response.status === 401) {
                window.location.href = '/login';
                throw new Error('Token expirado ou inválido. Redirecionando para login.');
            }
            return response.json(); // Converte a resposta para JSON
        })
        .then(data => {
            return data; // Retorna os dados da requisição (opcional)
        })
        .catch(error => {
            console.error('Erro na requisição protegida:', error);
            showError('Erro na requisição protegida.');
        });
}