const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql');
const cors = require('cors');

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(cors());

const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'fca.00',
    database: 'CursosDB'
});

db.connect(err => {
    if (err) throw err;
    console.log('Conectado a la base de datos MySQL');
});

app.get('/temarios', (req, res) => {
    const query = 'SELECT * FROM TEMARIO';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.get('/profesores', (req, res) => {
    const query = 'SELECT * FROM PROFESOR';
    db.query(query, (err, results) => {
        if (err) throw err;
        res.json(results);
    });
});

app.get('/categorias', (req, res) => {
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

app.post('/alumnos', (req, res) => {
    const { nombre, correo, telefono, id_pago } = req.body;
    const query = 'INSERT INTO ALUMNO (nombre, correo, telefono, id_pago) VALUES (?, ?, ?, ?)';
    db.query(query, [nombre, correo, telefono, id_pago], (err, result) => {
        if (err) throw err;
        res.json({ id: result.insertId, nombre, correo, telefono, id_pago });
    });
})

app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:4000`);
});