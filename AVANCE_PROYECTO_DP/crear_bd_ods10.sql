-- Base de datos: ods10_db

-- Tabla: necesidades (registro de usuarios)
CREATE TABLE IF NOT EXISTS necesidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    grupo VARCHAR(50),
    descripcion TEXT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: recursos (recursos y ayudas)
CREATE TABLE IF NOT EXISTS recursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_donacion VARCHAR(100),
    nombre_ayudante VARCHAR(100),
    telefono_ayudante VARCHAR(20),
    direccion_entrega VARCHAR(200),
    descripcion TEXT,
    cantidad INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
