CREATE TABLE prueba.persona
(
    persona_id BIGINT       NOT NULL,
    nombre     VARCHAR(255) NULL,
    apellido   VARCHAR(255) NULL,
    genero     VARCHAR(255) NULL,
    edad       INT          NOT NULL,
    dni        INT          NOT NULL,
    direccion  VARCHAR(255) NULL,
    telefono   VARCHAR(255) NULL,
    CONSTRAINT pk_persona PRIMARY KEY (persona_id)
);

INSERT INTO persona(persona_id,nombre, apellido,genero,edad,dni,direccion,telefono) VALUES (1,'Jose', 'Lema','Masculino',35,98765421,'Otavalo sn y principal','098254785');
INSERT INTO persona(persona_id,nombre, apellido,genero,edad,dni,direccion,telefono) VALUES (2,'Marianela', 'Montalvo','Femenino',31,46628403,'Jr.Asuncion','097548965');
INSERT INTO persona(persona_id,nombre, apellido,genero,edad,dni,direccion,telefono) VALUES (3,'Juan', 'Osorio','Masculino',18,70020869,'Jr.Jose Martí','098874587');

CREATE TABLE prueba.cliente
(
    cliente_id BIGINT       NOT NULL,
    password   VARCHAR(255) NULL,
    estado     BIT(1)       NULL,
    fk_persona BIGINT       NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (cliente_id)
);

ALTER TABLE prueba.cliente
    ADD CONSTRAINT FK_CLIENTE_ON_FK_PERSONA FOREIGN KEY (fk_persona) REFERENCES prueba.persona (persona_id);

INSERT INTO cliente(cliente_id,password,estado,fk_persona) VALUES (1,'1234', true,1);
INSERT INTO cliente(cliente_id,password,estado,fk_persona) VALUES (2,'5678', true,2);
INSERT INTO cliente(cliente_id,password,estado,fk_persona) VALUES (3,'1245', true,3);



CREATE TABLE prueba.cuenta
(
    cuenta_id     BIGINT       NOT NULL,
    numero_cuenta VARCHAR(255) NULL,
    tipo_cuenta   VARCHAR(255) NULL,
    saldo_inicial DOUBLE       NULL,
    estado        BIT(1)       NULL,
    tipo_tarjeta  VARCHAR(255) NULL,
    fk_cliente    BIGINT       NULL,
    CONSTRAINT pk_cuenta PRIMARY KEY (cuenta_id)
);

ALTER TABLE prueba.cuenta
    ADD CONSTRAINT FK_CUENTA_ON_FK_CLIENTE FOREIGN KEY (fk_cliente) REFERENCES prueba.cliente (cliente_id);


INSERT INTO cuenta(cuenta_id,numero_cuenta,tipo_cuenta,saldo_inicial,estado,tipo_tarjeta,fk_cliente) VALUES (1,'478758', 'Ahorro',2000, true ,'Credito',1);
INSERT INTO cuenta(cuenta_id,numero_cuenta,tipo_cuenta,saldo_inicial,estado,tipo_tarjeta,fk_cliente) VALUES (2,'225487', 'Corriente',100, true ,'Debito',2);
INSERT INTO cuenta(cuenta_id,numero_cuenta,tipo_cuenta,saldo_inicial,estado,tipo_tarjeta,fk_cliente) VALUES (3,'495878', 'Ahorros',0,true,'Debito',3);
INSERT INTO cuenta(cuenta_id,numero_cuenta,tipo_cuenta,saldo_inicial,estado,tipo_tarjeta,fk_cliente) VALUES (4,'496825', 'Ahorros',540,true,'Credito',3);

CREATE TABLE movimientos_bancarios
(
    movimiento_id   BIGINT       NOT NULL,
    fecha           datetime     NULL,
    tipo_movimiento VARCHAR(255) NULL,
    saldo           DOUBLE       NULL,
    valor           DOUBLE       NULL,
    fk_cuenta       BIGINT       NULL,
    CONSTRAINT pk_movimientos_bancarios PRIMARY KEY (movimiento_id)
);

ALTER TABLE movimientos_bancarios
    ADD CONSTRAINT FK_MOVIMIENTOS_BANCARIOS_ON_FK_CUENTA FOREIGN KEY (fk_cuenta) REFERENCES prueba.cuenta (cuenta_id);

select * from persona;
select * from cliente;
select * from cuenta;
select * from movimientos_bancarios;