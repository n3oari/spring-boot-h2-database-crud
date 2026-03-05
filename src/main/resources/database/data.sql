
INSERT INTO authors (name, last_name, email, age) VALUES
    ('Juan', 'Pérez', 'juan.perez@test.com', 30),
    ('María', 'García', 'maria.garcia@test.com', 28),
    ('Carlos', 'López', 'carlos.lopez@test.com', 40),
    ('Ana', 'Martínez', 'ana.martinez@test.com', 35),
    ('Luis', 'Rodríguez', 'luis.rodriguez@test.com', 28);

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