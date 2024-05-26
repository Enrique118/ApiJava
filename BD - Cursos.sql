CREATE DATABASE CursosDB;

USE CursosDB;

-- Tabla de ALUMNO
CREATE TABLE ALUMNO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    id_pago INT,
    no_telefono VARCHAR(15)
);

-- Tabla de PROFESOR
CREATE TABLE PROFESOR (
    cedula INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)
);

-- Tabla de CATEGORIA
CREATE TABLE CATEGORIA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL
);

-- Tabla de TEMARIO
CREATE TABLE TEMARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    anio INT,
    estatus VARCHAR(50),
    temas TEXT,
    objetivo TEXT
);

-- Tabla de CURSO
CREATE TABLE CURSO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    horario VARCHAR(50),
    cupo INT,
    duracion VARCHAR(50),
    id_temario INT,
    id_profesor INT,
    costo DECIMAL(10, 2),
    id_categoria INT,
    FOREIGN KEY (id_temario) REFERENCES TEMARIO(id),
    FOREIGN KEY (id_profesor) REFERENCES PROFESOR(cedula),
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id)
);

-- Relaciones (opcionalmente con constraints adicionales)

ALTER TABLE CURSO
    ADD CONSTRAINT FK_CURSO_PROFESOR FOREIGN KEY (id_profesor) REFERENCES PROFESOR(cedula),
    ADD CONSTRAINT FK_CURSO_TEMARIO FOREIGN KEY (id_temario) REFERENCES TEMARIO(id),
    ADD CONSTRAINT FK_CURSO_CATEGORIA FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id);
