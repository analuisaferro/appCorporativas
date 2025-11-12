const BASE_URL = 'http://localhost:8080';

// ---------------------- HOTÉIS ----------------------
function listarHoteis() {
    fetch(`${BASE_URL}/hoteis`)
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('lista-hoteis');
            lista.innerHTML = '';
            data.forEach(h => {
                const item = document.createElement('li');
                item.textContent = `ID: ${h.id} - ${h.nome} - ${h.endereco} - ${h.telefone}`;
                lista.appendChild(item);
            });
        });
}

function criarHotel() {
    const nome = document.getElementById('hotel-nome').value;
    const endereco = document.getElementById('hotel-endereco').value;
    const telefone = document.getElementById('hotel-telefone').value;

    fetch(`${BASE_URL}/hoteis`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, endereco, telefone })
    })
    .then(res => res.json())
    .then(() => {
        listarHoteis();
        document.getElementById('hotel-nome').value = '';
        document.getElementById('hotel-endereco').value = '';
        document.getElementById('hotel-telefone').value = '';
    });
}

// ---------------------- QUARTOS ----------------------
function listarQuartos() {
    fetch(`${BASE_URL}/quartos`)
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('lista-quartos');
            lista.innerHTML = '';
            data.forEach(q => {
                const item = document.createElement('li');
                item.textContent = `ID: ${q.id} - Nº: ${q.numero} - Tipo: ${q.tipo} - Preço: R$${q.precoNoite} - Disponível: ${q.status} - HotelID: ${q.hotelId}`;
                lista.appendChild(item);
            });
        });
}

function criarQuarto() {
    const numero = parseInt(document.getElementById('quarto-numero').value);
    const tipo = document.getElementById('quarto-tipo').value;
    const precoNoite = parseFloat(document.getElementById('quarto-preco').value);
    const status = document.getElementById('quarto-status').checked;
    const idHotel = parseInt(document.getElementById('quarto-hotelId').value);

    fetch(`${BASE_URL}/quartos`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ numero, tipo, precoNoite, status, idHotel })
    })
    .then(res => res.json())
    .then(() => {
        listarQuartos();
        document.getElementById('quarto-numero').value = '';
        document.getElementById('quarto-tipo').value = '';
        document.getElementById('quarto-preco').value = '';
        document.getElementById('quarto-status').checked = false;
        document.getElementById('quarto-hotelId').value = '';
    });
}

// ---------------------- RESERVAS ----------------------
function listarReservas() {
    fetch(`${BASE_URL}/reservas`)
        .then(res => res.json())
        .then(data => {
            const lista = document.getElementById('lista-reservas');
            lista.innerHTML = '';
            data.forEach(r => {
                const item = document.createElement('li');
                item.textContent = `ID: ${r.id} - HospedeID: ${r.hospede.id} - QuartoID: ${r.quarto.id} - Checkin: ${r.dataCheckin} - Checkout: ${r.dataCheckout} - Ativa: ${r.status}`;
                lista.appendChild(item);
            });
        });
}

function criarReserva() {
    const idHospede = parseInt(document.getElementById('reserva-hospedeId').value);
    const idQuarto = parseInt(document.getElementById('reserva-quartoId').value);
    const dataCheckin = document.getElementById('reserva-checkin').value;
    const dataCheckout = document.getElementById('reserva-checkout').value;
    const status = document.getElementById('reserva-status').checked;

    fetch(`${BASE_URL}/reservas`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ idHospede, idQuarto, dataCheckin, dataCheckout, status })
    })
    .then(res => res.json())
    .then(() => {
        listarReservas();
        document.getElementById('reserva-hospedeId').value = '';
        document.getElementById('reserva-quartoId').value = '';
        document.getElementById('reserva-checkin').value = '';
        document.getElementById('reserva-checkout').value = '';
        document.getElementById('reserva-status').checked = false;
    });
}

// ---------------------- INICIALIZAÇÃO ----------------------
window.onload = function() {
    listarHoteis();
    listarQuartos();
    listarReservas();
};
