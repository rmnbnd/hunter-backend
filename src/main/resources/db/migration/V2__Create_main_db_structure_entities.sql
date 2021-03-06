DROP TABLE IF EXISTS user;

RENAME TABLE ROLE TO role;

CREATE TABLE IF NOT EXISTS performers_group (
  group_id INT NOT NULL AUTO_INCREMENT,
  group_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (group_id)
);

CREATE TABLE IF NOT EXISTS customer (
  customer_id INT NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  site VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS performer (
  performer_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  birth_date DATE NOT NULL,
  gender VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  group_id INT,
  role_id INT NOT NULL,
  FOREIGN KEY (group_id) REFERENCES performers_group(group_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (performer_id)
);

CREATE TABLE IF NOT EXISTS vacancy (
  vacancy_id INT NOT NULL AUTO_INCREMENT,
  vacancy_name VARCHAR(255) NOT NULL,
  customer_id INT NOT NULL,
  country VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  salary INT NOT NULL,
  required_experience_years INT NOT NULL,
  description TEXT NOT NULL,
  employment_type VARCHAR(255) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (vacancy_id)
);

CREATE TABLE IF NOT EXISTS vacancies_performers (
  performer_id INT NOT NULL,
  vacancy_id INT NOT NULL,
  PRIMARY KEY (performer_id, vacancy_id),
  FOREIGN KEY (performer_id) REFERENCES performer(performer_id),
  FOREIGN KEY (vacancy_id) REFERENCES vacancy(vacancy_id)
);

