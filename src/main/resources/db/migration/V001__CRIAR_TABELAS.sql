CREATE TABLE IF NOT EXISTS person (
    
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    birth_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS phone (
    id BIGSERIAL PRIMARY KEY,
    phone_type VARCHAR(10) NOT NULL DEFAULT 'HOME',
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS person_phones (
    phones_id BIGINT NOT NULL,
    person_id BIGINT NOT NULL,

    PRIMARY KEY (person_id, phones_id),

    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (phones_id) REFERENCES phone(id)
);