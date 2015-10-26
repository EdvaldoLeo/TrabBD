
CREATE TABLE tb_forn_pecas
(
	nome                 VARCHAR2(40) NOT NULL ,
	cep                  INTEGER NULL ,
	rua                  VARCHAR2(40) NULL ,
	numero               VARCHAR2(6) NULL ,
	complemento          VARCHAR2(40) NULL ,
	bairro               VARCHAR2(40) NULL ,
	cidade               VARCHAR2(40) NULL ,
	uf                   VARCHAR2(2) NULL ,
	fone1                INTEGER NULL ,
	fone2                INTEGER NULL ,
	status               VARCHAR2(20) NULL ,
	dt_cadastro          DATE NULL ,
	cnpj_fornecedor      VARCHAR2(14) NOT NULL ,
	contato              VARCHAR2(20) NULL ,
	observacao           LONG VARCHAR NULL 
);

CREATE UNIQUE INDEX XPKtb_fornecedor ON tb_forn_pecas
(cnpj_fornecedor   ASC);

ALTER TABLE tb_forn_pecas
	ADD CONSTRAINT  XPKtb_fornecedor PRIMARY KEY (cnpj_fornecedor);

CREATE TABLE tb_veiculo
(
	placa                VARCHAR2(7) NOT NULL ,
	chassi               VARCHAR2(20) NULL ,
	marca                VARCHAR2(20) NULL ,
	modelo               VARCHAR2(20) NULL ,
	ano_fab              INTERVAL YEAR TO MONTH NULL ,
	ano_mod              INTERVAL YEAR TO MONTH NULL ,
	status               VARCHAR2(20) NULL 
);

CREATE UNIQUE INDEX XPKtb_veiculo ON tb_veiculo
(placa   ASC);

ALTER TABLE tb_veiculo
	ADD CONSTRAINT  XPKtb_veiculo PRIMARY KEY (placa);

CREATE TABLE tb_servico
(
	data_servico         DATE NOT NULL ,
	servico              VARCHAR2(20) NULL ,
	descricao            VARCHAR2(400) NULL ,
	km_servico           INTEGER NULL ,
	placa                VARCHAR2(7) NOT NULL 
);

CREATE UNIQUE INDEX XPKtb_despesa ON tb_servico
(placa   ASC,data_servico   ASC);

ALTER TABLE tb_servico
	ADD CONSTRAINT  XPKtb_despesa PRIMARY KEY (placa,data_servico);

CREATE TABLE tb_peca
(
	nfiscal              INTEGER NOT NULL ,
	nome                 VARCHAR2(200) NULL ,
	valor                DECIMAL(6,2) NULL ,
	qtde                 INTEGER NULL ,
	cnpj_fornecedor      VARCHAR2(14) NOT NULL ,
	codigo               INTEGER NOT NULL ,
	placa                VARCHAR2(7) NOT NULL ,
	data_servico         DATE NOT NULL 
);

CREATE UNIQUE INDEX XPKtb_peca ON tb_peca
(cnpj_fornecedor   ASC,codigo   ASC,nfiscal   ASC,placa   ASC,data_servico   ASC);

ALTER TABLE tb_peca
	ADD CONSTRAINT  XPKtb_peca PRIMARY KEY (cnpj_fornecedor,codigo,nfiscal,placa,data_servico);

ALTER TABLE tb_servico
	ADD (CONSTRAINT R_21 FOREIGN KEY (placa) REFERENCES tb_veiculo (placa));

ALTER TABLE tb_peca
	ADD (CONSTRAINT R_20 FOREIGN KEY (cnpj_fornecedor) REFERENCES tb_forn_pecas (cnpj_fornecedor));

ALTER TABLE tb_peca
	ADD (CONSTRAINT R_22 FOREIGN KEY (placa, data_servico) REFERENCES tb_servico (placa, data_servico));

CREATE  TRIGGER  tD_tb_forn_pecas AFTER DELETE ON tb_forn_pecas for each row
-- ERwin Builtin Trigger
-- DELETE trigger on tb_forn_pecas 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* tb_forn_pecas  tb_peca on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000de9d", PARENT_OWNER="", PARENT_TABLE="tb_forn_pecas"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_20", FK_COLUMNS="cnpj_fornecedor" */
    SELECT count(*) INTO NUMROWS
      FROM tb_peca
      WHERE
        /*  %JoinFKPK(tb_peca,:%Old," = "," AND") */
        tb_peca.cnpj_fornecedor = :old.cnpj_fornecedor;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete tb_forn_pecas because tb_peca exists.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_tb_forn_pecas AFTER UPDATE ON tb_forn_pecas for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on tb_forn_pecas 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* tb_forn_pecas  tb_peca on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00011042", PARENT_OWNER="", PARENT_TABLE="tb_forn_pecas"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_20", FK_COLUMNS="cnpj_fornecedor" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.cnpj_fornecedor <> :new.cnpj_fornecedor
  THEN
    SELECT count(*) INTO NUMROWS
      FROM tb_peca
      WHERE
        /*  %JoinFKPK(tb_peca,:%Old," = "," AND") */
        tb_peca.cnpj_fornecedor = :old.cnpj_fornecedor;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update tb_forn_pecas because tb_peca exists.'
      );
    END IF;
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_tb_veiculo AFTER DELETE ON tb_veiculo for each row
-- ERwin Builtin Trigger
-- DELETE trigger on tb_veiculo 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* tb_veiculo  tb_servico on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000da4f", PARENT_OWNER="", PARENT_TABLE="tb_veiculo"
    CHILD_OWNER="", CHILD_TABLE="tb_servico"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="placa" */
    SELECT count(*) INTO NUMROWS
      FROM tb_servico
      WHERE
        /*  %JoinFKPK(tb_servico,:%Old," = "," AND") */
        tb_servico.placa = :old.placa;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete tb_veiculo because tb_servico exists.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_tb_veiculo AFTER UPDATE ON tb_veiculo for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on tb_veiculo 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* tb_veiculo  tb_servico on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="000103c9", PARENT_OWNER="", PARENT_TABLE="tb_veiculo"
    CHILD_OWNER="", CHILD_TABLE="tb_servico"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="placa" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.placa <> :new.placa
  THEN
    SELECT count(*) INTO NUMROWS
      FROM tb_servico
      WHERE
        /*  %JoinFKPK(tb_servico,:%Old," = "," AND") */
        tb_servico.placa = :old.placa;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update tb_veiculo because tb_servico exists.'
      );
    END IF;
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER  tD_tb_servico AFTER DELETE ON tb_servico for each row
-- ERwin Builtin Trigger
-- DELETE trigger on tb_servico 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* tb_servico  tb_peca on parent delete restrict */
    /* ERWIN_RELATION:CHECKSUM="0000e6f0", PARENT_OWNER="", PARENT_TABLE="tb_servico"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_22", FK_COLUMNS="placa""data_servico" */
    SELECT count(*) INTO NUMROWS
      FROM tb_peca
      WHERE
        /*  %JoinFKPK(tb_peca,:%Old," = "," AND") */
        tb_peca.data_servico = :old.data_servico AND
        tb_peca.placa = :old.placa;
    IF (NUMROWS > 0)
    THEN
      raise_application_error(
        -20001,
        'Cannot delete tb_servico because tb_peca exists.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tI_tb_servico BEFORE INSERT ON tb_servico for each row
-- ERwin Builtin Trigger
-- INSERT trigger on tb_servico 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* tb_veiculo  tb_servico on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="0000efcd", PARENT_OWNER="", PARENT_TABLE="tb_veiculo"
    CHILD_OWNER="", CHILD_TABLE="tb_servico"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="placa" */
    SELECT count(*) INTO NUMROWS
      FROM tb_veiculo
      WHERE
        /* %JoinFKPK(:%New,tb_veiculo," = "," AND") */
        :new.placa = tb_veiculo.placa;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert tb_servico because tb_veiculo does not exist.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_tb_servico AFTER UPDATE ON tb_servico for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on tb_servico 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* tb_servico  tb_peca on parent update restrict */
  /* ERWIN_RELATION:CHECKSUM="00022d23", PARENT_OWNER="", PARENT_TABLE="tb_servico"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_22", FK_COLUMNS="placa""data_servico" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.data_servico <> :new.data_servico OR 
    :old.placa <> :new.placa
  THEN
    SELECT count(*) INTO NUMROWS
      FROM tb_peca
      WHERE
        /*  %JoinFKPK(tb_peca,:%Old," = "," AND") */
        tb_peca.data_servico = :old.data_servico AND
        tb_peca.placa = :old.placa;
    IF (NUMROWS > 0)
    THEN 
      raise_application_error(
        -20005,
        'Cannot update tb_servico because tb_peca exists.'
      );
    END IF;
  END IF;

  /* ERwin Builtin Trigger */
  /* tb_veiculo  tb_servico on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="tb_veiculo"
    CHILD_OWNER="", CHILD_TABLE="tb_servico"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_21", FK_COLUMNS="placa" */
  SELECT count(*) INTO NUMROWS
    FROM tb_veiculo
    WHERE
      /* %JoinFKPK(:%New,tb_veiculo," = "," AND") */
      :new.placa = tb_veiculo.placa;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update tb_servico because tb_veiculo does not exist.'
    );
  END IF;


-- ERwin Builtin Trigger
END;
/


CREATE  TRIGGER tI_tb_peca BEFORE INSERT ON tb_peca for each row
-- ERwin Builtin Trigger
-- INSERT trigger on tb_peca 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin Trigger */
    /* tb_servico  tb_peca on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00020ff1", PARENT_OWNER="", PARENT_TABLE="tb_servico"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_22", FK_COLUMNS="placa""data_servico" */
    SELECT count(*) INTO NUMROWS
      FROM tb_servico
      WHERE
        /* %JoinFKPK(:%New,tb_servico," = "," AND") */
        :new.data_servico = tb_servico.data_servico AND
        :new.placa = tb_servico.placa;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert tb_peca because tb_servico does not exist.'
      );
    END IF;

    /* ERwin Builtin Trigger */
    /* tb_forn_pecas  tb_peca on child insert restrict */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="tb_forn_pecas"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_20", FK_COLUMNS="cnpj_fornecedor" */
    SELECT count(*) INTO NUMROWS
      FROM tb_forn_pecas
      WHERE
        /* %JoinFKPK(:%New,tb_forn_pecas," = "," AND") */
        :new.cnpj_fornecedor = tb_forn_pecas.cnpj_fornecedor;
    IF (
      /* %NotnullFK(:%New," IS NOT NULL AND") */
      
      NUMROWS = 0
    )
    THEN
      raise_application_error(
        -20002,
        'Cannot insert tb_peca because tb_forn_pecas does not exist.'
      );
    END IF;


-- ERwin Builtin Trigger
END;
/

CREATE  TRIGGER tU_tb_peca AFTER UPDATE ON tb_peca for each row
-- ERwin Builtin Trigger
-- UPDATE trigger on tb_peca 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin Trigger */
  /* tb_servico  tb_peca on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="0002147d", PARENT_OWNER="", PARENT_TABLE="tb_servico"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_22", FK_COLUMNS="placa""data_servico" */
  SELECT count(*) INTO NUMROWS
    FROM tb_servico
    WHERE
      /* %JoinFKPK(:%New,tb_servico," = "," AND") */
      :new.data_servico = tb_servico.data_servico AND
      :new.placa = tb_servico.placa;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update tb_peca because tb_servico does not exist.'
    );
  END IF;

  /* ERwin Builtin Trigger */
  /* tb_forn_pecas  tb_peca on child update restrict */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="tb_forn_pecas"
    CHILD_OWNER="", CHILD_TABLE="tb_peca"
    P2C_VERB_PHRASE="", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_20", FK_COLUMNS="cnpj_fornecedor" */
  SELECT count(*) INTO NUMROWS
    FROM tb_forn_pecas
    WHERE
      /* %JoinFKPK(:%New,tb_forn_pecas," = "," AND") */
      :new.cnpj_fornecedor = tb_forn_pecas.cnpj_fornecedor;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update tb_peca because tb_forn_pecas does not exist.'
    );
  END IF;


-- ERwin Builtin Trigger
END;
/

