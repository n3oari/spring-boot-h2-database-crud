
INSERT INTO authors (name, last_name, email, age) VALUES
    ('Juan', 'Gómez', 'juan.gomez@test.com', 25),
    ('Juan', 'Hernández', 'juan.hernandez@test.com', 32),
    ('Juan', 'Díaz', 'juan.diaz@test.com', 29),
    ('Juan', 'Sánchez', 'juan.sanchez@test.com', 45),
    ('Juan', 'Ramírez', 'juan.ramirez@test.com', 33),
    ('Juan', 'Torres', 'juan.torres@test.com', 27),
    ('Juan', 'Flores', 'juan.flores@test.com', 38),
    ('Juan', 'Vargas', 'juan.vargas@test.com', 41),
    ('Juan', 'Castillo', 'juan.castillo@test.com', 36),
    ('Juan', 'Ruiz', 'juan.ruiz@test.com', 31);

INSERT INTO categories (name, description) VALUES
    ('Java', 'Fundamentos y POO'),
    ('Spring Boot', 'Desarrollo backend rápido'),
    ('Bases de Datos', 'SQL y optimización'),
    ('Frontend', 'React, Angular, Vue'),
    ('Cloud', 'Docker, AWS, Azure');


INSERT INTO tutorials (title, description, published, author_id, category_id) VALUES
    ('Aprende Java desde cero', 'Guía completa para principiantes', true, 1, 1),
    ('Spring Boot en 30 minutos', 'Configuración de microservicios', true, 2, 2),
    ('Dominando SQL', 'Consultas complejas y joins', false, 3, 3),
    ('Frontend Moderno', 'Introducción a componentes', true, 4, 4),
    ('Docker para principiantes', 'Contenedores y despliegue', true, 5, 5);


INSERT INTO comments (content, author_name, created_at, tutorial_id) VALUES
    ('Muy bueno tutorial, lo recomiendo!', 'Carlos', NOW(), 1),
    ('Carlos aquí, me ayudó bastante con los conceptos básicos', 'Carlos', NOW(), 2),
    ('Excelente explicación de los JOINs', 'Carlos', NOW(), 3),
    ('El mejor recurso de Frontend que he encontrado', 'Carlos', NOW(), 4),
    ('Carlos recomienda este tutorial 100%', 'Carlos', NOW(), 5),
    ('Perfecto para empezar con microservicios', 'Elena', NOW(), 2),
    ('Falta más profundidad en los ejemplos', 'Tomás', NOW(), 2),
    ('Lo mejor que he visto de Spring', 'Natalia', NOW(), 2),
    ('Los índices también son importantes, podrías añadirlos?', 'Ricardo', NOW(), 3),
    ('Me salvó en el examen de bases de datos', 'Gabriela', NOW(), 3),
    ('Muy claro y conciso', 'Fernando', NOW(), 3),
    ('Muy claro y conciso', 'Fernando', NOW(), 1),
    ('Muy claro, bueno y conciso', 'Carlos', NOW(), 1),
    ('Muy bueno y conciso', 'Carlos', NOW(), 1);