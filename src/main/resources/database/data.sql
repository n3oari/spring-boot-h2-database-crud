-- Usuarios (Necesarios para los comentarios)
INSERT INTO users (username, email, fullname) VALUES
                                                  ('CarlosDev', 'carlos@test.com', 'Carlos'),
                                                  ('ElenaTech', 'elena@test.com', 'Elena'),
                                                  ('TomasBackend', 'tomas@test.com', 'Tomás'),
                                                  ('NataliaSpring', 'natalia@test.com', 'Natalia'),
                                                  ('RicardoDB', 'ricardo@test.com', 'Ricardo'),
                                                  ('GabrielaSQL', 'gabriela@test.com', 'Gabriela'),
                                                  ('FernandoCode', 'fernando@test.com', 'Fernando');

-- Autores
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

-- Categorías
INSERT INTO categories (name, description) VALUES
                                               ('Java', 'Fundamentos y POO'),
                                               ('Spring Boot', 'Desarrollo backend rápido'),
                                               ('Bases de Datos', 'SQL y optimización'),
                                               ('Frontend', 'React, Angular, Vue'),
                                               ('Cloud', 'Docker, AWS, Azure');

-- Tutoriales
INSERT INTO tutorials (title, description, published, author_id, category_id) VALUES
                                                                                  ('Aprende Java desde cero', 'Guía completa para principiantes', true, 1, 1),
                                                                                  ('Spring Boot en 30 minutos', 'Configuración de microservicios', true, 2, 2),
                                                                                  ('Dominando SQL', 'Consultas complejas y joins', false, 3, 3),
                                                                                  ('Frontend Moderno', 'Introducción a componentes', true, 4, 4),
                                                                                  ('Docker para principiantes', 'Contenedores y despliegue', true, 5, 5);

-- Comentarios (Usando user_id en lugar de author_name)
INSERT INTO comments (content, user_id, created_at, tutorial_id) VALUES
                                                                     ('Muy bueno tutorial, lo recomiendo!', 1, NOW(), 1),
                                                                     ('Carlos aquí, me ayudó bastante con los conceptos básicos', 1, NOW(), 2),
                                                                     ('Excelente explicación de los JOINs', 1, NOW(), 3),
                                                                     ('El mejor recurso de Frontend que he encontrado', 1, NOW(), 4),
                                                                     ('Carlos recomienda este tutorial 100%', 1, NOW(), 5),
                                                                     ('Perfecto para empezar con microservicios', 2, NOW(), 2),
                                                                     ('Falta más profundidad en los ejemplos', 3, NOW(), 2),
                                                                     ('Lo mejor que he visto de Spring', 4, NOW(), 2),
                                                                     ('Los índices también son importantes, podrías añadirlos?', 5, NOW(), 3),
                                                                     ('Me salvó en el examen de bases de datos', 6, NOW(), 3),
                                                                     ('Muy claro y conciso', 7, NOW(), 3),
                                                                     ('Muy claro y conciso', 7, NOW(), 1),
                                                                     ('Muy claro, bueno y conciso', 1, NOW(), 1),
                                                                     ('Muy bueno y conciso', 1, NOW(), 1);