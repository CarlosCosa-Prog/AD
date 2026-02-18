-- A utilizar para los ejercicios sobre empresa1


-- Crear tabla departamentos
CREATE TABLE departamentos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear tabla empleados
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    departamento_id INTEGER,
    fecha_contratacion DATE DEFAULT CURRENT_DATE,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id)
);

-- Crear índices para mejorar el rendimiento
CREATE INDEX idx_empleados_departamento_id ON empleados(departamento_id);
CREATE INDEX idx_empleados_apellido ON empleados(apellido);
CREATE INDEX idx_empleados_salario ON empleados(salario);

-- Insertar datos de ejemplo en departamentos
INSERT INTO departamentos (nombre) VALUES 
('Ventas'),
('TI'),
('Recursos Humanos'),
('Finanzas'),
('Marketing');

-- Insertar datos de ejemplo en empleados
INSERT INTO empleados (nombre, apellido, salario, departamento_id, fecha_contratacion) VALUES 
('Juan', 'Pérez', 35000.00, 1, '2022-01-15'),
('Marta', 'Gómez', 42000.00, 2, '2021-03-20'),
('David', 'Fernández', 28000.00, 3, '2023-05-10'),
('Ana', 'López', 38000.00, 1, '2022-08-30'),
('Carlos', 'Rodríguez', 45000.00, 2, '2020-11-05'),
('Laura', 'Martínez', 32000.00, 4, '2023-01-20'),
('Pedro', 'Sánchez', 29000.00, 5, '2022-12-01');

-- Crear una vista para empleados activos
CREATE VIEW vista_empleados_activos AS
SELECT 
    e.id,
    e.nombre,
    e.apellido,
    e.salario,
    e.fecha_contratacion,
    d.nombre as departamento_nombre
FROM empleados e
JOIN departamentos d ON e.departamento_id = d.id
WHERE e.activo = TRUE;

-- Función para calcular el salario promedio por departamento
CREATE OR REPLACE FUNCTION salario_promedio_departamento(dep_id INTEGER)
RETURNS DECIMAL AS $$
DECLARE
    promedio DECIMAL;
BEGIN
    SELECT AVG(salario) INTO promedio 
    FROM empleados 
    WHERE departamento_id = dep_id AND activo = TRUE;
    
    RETURN promedio;
END;
$$ LANGUAGE plpgsql;

-- Procedimiento para aumentar salarios por departamento
CREATE OR REPLACE PROCEDURE aumentar_salarios_departamento(
    IN dep_id INTEGER,
    IN porcentaje DOUBLE PRECISION
)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE empleados 
    SET salario = salario * (1 + porcentaje/100)
    WHERE departamento_id = dep_id AND activo = TRUE;
    
    COMMIT;
END;
$$;
