INSERT INTO users (id, name, lastname, username, password, enabled) VALUES (1, 'admin', 'admin', 'admin', '$2a$12$sd8kggglHMSjBM8wwCSq6eEHpW2pT.xvX27QeR.VkNBAvXdDouINW', 1);
INSERT INTO roles (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);

INSERT INTO products (id, name, price, stock) VALUES (1, 'Product 1', 100, 10);
INSERT INTO products (id, name, price, stock) VALUES (2, 'Product 2', 200, 20);
INSERT INTO products (id, name, price, stock) VALUES (3, 'Product 3', 300, 30);
INSERT INTO products (id, name, price, stock) VALUES (4, 'Product 4', 400, 40);
INSERT INTO products (id, name, price, stock) VALUES (5, 'Product 5', 500, 50);