
INSERT INTO authors (id, name, lastName, email, age) VALUES
    (1, 'Juan', 'Pérez', 'juan.perez@test.com', 30),
    (2, 'María', 'García', 'maria.garcia@test.com', 28),
    (3, 'Carlos', 'López', 'carlos.lopez@test.com', 40),
    (4, 'Ana', 'Martínez', 'ana.martinez@test.com', 35),
                                                         (5, 'Luis', 'Rodríguez', 'luis.rodriguez@test.com', 28);
INSERT INTO categories (id, name, description) VALUES
    (1, 'Java', 'Fundamentos y POO'),
    (2, 'Spring Boot', 'Desarrollo backend rápido'),
    (3, 'Bases de Datos', 'SQL y optimización'),
    (4, 'Frontend', 'React, Angular, Vue'),
    (5, 'Cloud', 'Docker, AWS, Azure');

INSERT INTO tutorials (id, title, description, published, author_id, category_id) VALUES
    (1, 'Aprende Java desde cero', 'Guía completa para principiantes', true, 1, 1),
    (2, 'Spring Boot en 30 minutos', 'Configuración de microservicios', true, 2, 2),
    (3, 'Dominando SQL', 'Consultas complejas y joins', false, 3, 3),
    (4, 'Frontend Moderno', 'Introducción a componentes', true, 4, 4),
    (5, 'Docker para principiantes', 'Contenedores y despliegue', true, 5, 5);