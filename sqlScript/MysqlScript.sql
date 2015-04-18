DROP DATABASE IF EXISTS viajes;
CREATE DATABASE viajes
	DEFAULT CHARACTER SET = utf8
	DEFAULT COLLATE = utf8_bin;

USE viajes;

CREATE TABLE estado(
	estadoId INTEGER     NOT NULL auto_increment,
	nombre   VARCHAR(40) NOT NULL,
	PRIMARY KEY(estadoId)
)ENGINE = innodb;

CREATE TABLE municipio(
	municipioId INTEGER     NOT NULL auto_increment,
	nombre      VARCHAR(40) NOT NULL,
	estadoId    INTEGER     NOT NULL,
	PRIMARY KEY (municipioId),
	FOREIGN KEY fk_estadoid_municipio(estadoId)
		REFERENCES estado(estadoId)
		ON DELETE RESTRICT
) ENGINE = innodb;

CREATE TABLE locacion(
	locacionId  INTEGER     NOT NULL auto_increment,
	nombre      VARCHAR(40) NOT NULL,
	municipioId INTEGER     NOT NULL,
	PRIMARY KEY (locacionId),
	FOREIGN KEY fk_minicipioid_locacion(municipioId)
		REFERENCES municipio(municipioId)
		ON DELETE RESTRICT
) ENGINE = innodb;

CREATE TABLE transporte(
	transporteId INTEGER     NOT NULL auto_increment,
	nombre       VARCHAR(20) NOT NULL,
	PRIMARY KEY (transporteId)
) ENGINE = innodb;

CREATE TABLE empresa(
	empresaId      INTEGER     NOT NULL auto_increment,
	nombre         VARCHAR(50) NOT NULL,
	transporteId   INTEGER     NOT NULL,
	rfc            VARCHAR(14) NOT NULL,
	PRIMARY KEY(empresaId),
	FOREIGN KEY fk_empresa_transporte(transporteId)
		REFERENCES transporte(transporteId)
		ON DELETE RESTRICT,
	CONSTRAINT un_empresa_rfc UNIQUE(rfc)
) ENGINE = innodb;

CREATE TABLE corrida(
	corridaId     INTEGER NOT NULL auto_increment,
	ciudadPartida INTEGER NOT NULL,
	fechaPartida  DATE    NOT NULL,
	ciudadDestino INTEGER NOT NULL,
	fechaDestino  DATE    NOT NULL,
	empresaId     INTEGER NOT NULL,
	costo         REAL    NOT NULL,
	PRIMARY KEY (corridaId),
	FOREIGN KEY fk_corrida_empresa(empresaId)
		REFERENCES empresa(empresaId)
		ON DELETE RESTRICT,
	FOREIGN KEY fk_corrida_locacion_p(ciudadPartida)
		REFERENCES locacion(locacionId)
		ON DELETE RESTRICT,
	FOREIGN KEY fk_corrida_locacion_L(ciudadDestino)
		REFERENCES locacion(locacionId)
		ON DELETE RESTRICT,
	CONSTRAINT ch_costo CHECK(costo > 0)

) ENGINE = innodb;

CREATE TABLE cliente(
	clienteId INTEGER     NOT NULL,
	nombre    VARCHAR(20) NOT NULL,
	apellido  VARCHAR(20) NOT NULL,
	PRIMARY KEY (clienteId)
) ENGINE = innodb;

CREATE TABLE plan(
		planId    INTEGER NOT NULL,
		clienteId INTEGER NOT NULL,
		costo     REAL    NOT NULL,
		PRIMARY KEY (planId),
		FOREIGN KEY fk_plan_cliente(clienteId)
			REFERENCES      cliente(clienteId)
			ON DELETE RESTRICT,
		CONSTRAINT ch_costo CHECK(costo > 0)
) ENGINE = innodb;

CREATE TABLE reservacion(
	reservacionId INTEGER     NOT NULL,
	corridaId     INTEGER     NOT NULL,
	nombreReserva VARCHAR(50) NOT NULL,
	planId        INTEGER     NOT NULL,
	asiento       VARCHAR(10) NOT NULL,
	PRIMARY KEY(reservacionId, corridaId),
	FOREIGN KEY fk_reservacion_corrida(corridaId)
		REFERENCES             corrida(corridaId)
		ON DELETE RESTRICT,
	FOREIGN KEY fk_reervacion_plan(planId)
		REFERENCES            plan(planId)
		ON DELETE RESTRICT
) ENGINE = innodb;

CREATE TABLE telefono(
	empresaId INTEGER,
	clienteId INTEGER,

	telefono  VARCHAR(15),
	CONSTRAINT fk_telefono_empresa 
		FOREIGN KEY (empresaId)
		REFERENCES empresa(empresaId)
		ON DELETE RESTRICT,
	CONSTRAINT fk_telefono_cliente
		FOREIGN KEY (clienteId)
		REFERENCES cliente(clienteId)
		ON DELETE RESTRICT,
	CONSTRAINT ck_telefono_empresa_cliente
		CHECK (empresaId IS NOT NULL AND clienteId IS NOT NULL)

) ENGINE = innodb;

INSERT INTO estado (estadoId, nombre)
	VALUES(1, 'Chihuahua');

INSERT INTO municipio(nombre, estadoId)
	VALUES ('Chihuahua',          1),
	       ('Juarez',             1),
	       ('Cuautemoc',          1),
	       ('Delicias',           1),
	       ('Hidalgo del Parral', 1),
	       ('Bocoyna',            1);

INSERT INTO locacion(nombre, municipioId)
	VALUES ('Chihuahua',          1),
	       ('Juarez',             2),
	       ('Cuautemoc',          3),
	       ('Delicias',           4),
	       ('Hidalgo del Parral', 5),
	       ('Bocoyna',            6),
	       ('Creel',              6),
	       ('San Juanito',        6);

INSERT INTO transporte (nombre)
	VALUES('Autobus') ,('Avion'), ('Tren'), ('Ferry');

INSERT INTO empresa (nombre, transporteId, rfc)
	VALUES ('Estrella Blanca', 1, 'AEB611030SN7');
