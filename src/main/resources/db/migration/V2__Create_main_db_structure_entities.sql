CREATE TABLE IF NOT EXISTS job (
  job_id INT NOT NULL AUTO_INCREMENT,
  job_name VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  salary INT NOT NULL,
  experience_years INT NOT NULL,
  employment_type VARCHAR(255) NOT NULL,
  PRIMARY KEY (job_id)
);

CREATE TABLE IF NOT EXISTS resume (
  resume_id INT NOT NULL AUTO_INCREMENT,
  performer_id INT NOT NULL,
  country VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  job_id INT NOT NULL,
  FOREIGN KEY (job_id) REFERENCES job(job_id),
  FOREIGN KEY (performer_id) REFERENCES performer(performer_id) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (resume_id)
);