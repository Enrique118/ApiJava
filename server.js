const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const cors = require('cors');

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(cors());

const db = mysql.createConnection({
    host: 'root',
    user: 'root',
    password: 'fca.00',
    database: 'cursosdb'
});

db.connect(err => {
    if (err) throw err;
    console.log('Conectado a la base de datos MySQL');
});

app.get('/temario', (req, res) => {
    const query = 'SELECT * FROM TEMARIO';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.get('/profesor', (req, res) => {
    const query = 'SELECT * FROM PROFESOR';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.get('/categoria', (req, res) => {
    const query = 'SELECT * FROM CATEGORIA';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.get('/cursos', (req, res) => {
    const query = 'SELECT * FROM CURSO';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.post('/alumno', (req, res) => {
    const { nombre, correo, no_telefono, id_pago } = req.body;
    const query = 'INSERT INTO ALUMNO (nombre, correo, no_telefono, id_pago) VALUES (?, ?, ?, ?)';
    db.query(query, [nombre, correo, no_telefono, id_pago], (err, result) => {
        if (err) throw err;
        res.json({ id: result.insertId, nombre, correo, no_telefono, id_pago });
    });
});

app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:4000`);
});

