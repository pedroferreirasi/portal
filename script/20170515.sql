-- **********************************************************************************************
-- TITULO
-- **********************************************************************************************


-- **********************************************************************************************
-- DROP CONSTRAINT
-- **********************************************************************************************
DROP PROCEDURE IF EXISTS db.dropconstraint;
DELIMITER $$
CREATE PROCEDURE db.dropconstraint()
BEGIN
  DECLARE contador Int DEFAULT 0;
  
  SELECT count(*) 
    INTO contador
    FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
   WHERE CONSTRAINT_NAME = 'cargo_fk';

  if (contador > 0) then
    ALTER TABLE `db`.`itemavaliacao_cargos` 
    DROP FOREIGN KEY `cargo_fk`;
  end if;
END $$;
DELIMITER ;

CALL db.dropconstraint;
DROP PROCEDURE IF EXISTS db.dropconstraint;

-- **********************************************************************************************
-- CREATE TABLES
-- **********************************************************************************************

CREATE TABLE IF NOT EXISTS `db`.`tb_grupousuario` (
  `pk_usgcad` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(70) NOT NULL,
  `tp_grupousuario` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`pk_usgcad`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db`.`tb_departamento` (
  `pk_depcad` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(70) NOT NULL,
  `ativo` SMALLINT(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pk_depcad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db`.`tb_usuario` (
  `pk_usucad` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_usgcad` INT(11) NOT NULL,
  `fk_carcad` INT(11) NULL DEFAULT NULL,
  `fk_depcad` INT(11) NULL DEFAULT NULL,
  `nomecompleto` VARCHAR(100) NULL DEFAULT NULL,
  `nome` VARCHAR(30) NULL DEFAULT NULL,
  `sobrenome` VARCHAR(30) NULL DEFAULT NULL,
  `celular` VARCHAR(25) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `login` VARCHAR(30) NOT NULL,
  `sexo` VARCHAR(1) NULL DEFAULT NULL,
  `tipousuario` VARCHAR(1) NOT NULL DEFAULT 'C',  
  `ativo` BIT(1) NOT NULL,
  PRIMARY KEY (`pk_usucad`),
  UNIQUE INDEX `UK_1vofibjsgo77e7km8wowva1qe` (`login` ASC),
  INDEX `fk_usucad_usgcad` (`fk_usgcad` ASC),
  INDEX `fk_usucad_depcad_idx` (`fk_depcad` ASC),
  INDEX `fk_usucad_carcad_idx` (`fk_carcad` ASC),
  CONSTRAINT `fk_usucad_carcad`
    FOREIGN KEY (`fk_carcad`)
    REFERENCES `db`.`cargos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usucad_depcad`
    FOREIGN KEY (`fk_depcad`)
    REFERENCES `db`.`tb_departamento` (`pk_depcad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usucad_usgcad`
    FOREIGN KEY (`fk_usgcad`)
    REFERENCES `db`.`tb_grupousuario` (`pk_usgcad`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `db`.`tb_usuario` 
DROP FOREIGN KEY `fk_usucad_carcad`;
ALTER TABLE `db`.`tb_usuario` 
CHANGE COLUMN `fk_carcad` `fk_carcad` INT(11) NOT NULL DEFAULT 36 ;
ALTER TABLE `db`.`tb_usuario` 
ADD CONSTRAINT `fk_usucad_carcad`
  FOREIGN KEY (`fk_carcad`)
  REFERENCES `db`.`cargos` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

CREATE TABLE IF NOT EXISTS `db`.`tb_dados_pessoais` (
  `pk_pescad` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_usucad` INT(11) NOT NULL,
  `cep` VARCHAR(10) NULL DEFAULT NULL,
  `tipologradouro` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(100) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(100) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `nacionalidade` VARCHAR(45) NULL DEFAULT NULL,
  `naturalidade` VARCHAR(45) NULL DEFAULT NULL,
  `datanascimento` DATE NULL DEFAULT NULL,
  `estadocivil` VARCHAR(1) NULL DEFAULT NULL,
  `raca` VARCHAR(45) NULL DEFAULT NULL,
  `nomemae` VARCHAR(100) NULL DEFAULT NULL,
  `nomepai` VARCHAR(100) NULL DEFAULT NULL,
  `nuRG` VARCHAR(10) NULL DEFAULT NULL,
  `dataemissaoRG` DATETIME NULL DEFAULT NULL,
  `orgaoemissorRG` VARCHAR(5) NULL DEFAULT NULL,
  `estadoemissorRG` VARCHAR(2) NULL DEFAULT NULL,
  `nuCPF` VARCHAR(15) NULL DEFAULT NULL,
  `emailpessoal` VARCHAR(70) NULL DEFAULT NULL,
  `telefonepessoal` VARCHAR(20) NULL DEFAULT NULL,
  `celularpessoal` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_pescad`),
  INDEX `fk_pescad_usucad_idx` (`fk_usucad` ASC),
  CONSTRAINT `fk_pescad_usucad`
    FOREIGN KEY (`fk_usucad`)
    REFERENCES `db`.`tb_usuario` (`pk_usucad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db`.`tb_dados_profissionais` (
  `pk_procad` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_usucad` INT(11) NOT NULL,
  `nuCTPS` VARCHAR(10) NULL DEFAULT NULL,
  `serieCTPS` VARCHAR(10) NULL DEFAULT NULL,
  `ufCTPS` VARCHAR(2) NULL DEFAULT NULL,
  `nuPIS` VARCHAR(15) NULL DEFAULT NULL,
  `emailprofissional` VARCHAR(70) NULL DEFAULT NULL,
  `telefoneprofissional` VARCHAR(20) NULL DEFAULT NULL,
  `ramal` VARCHAR(10) NULL DEFAULT NULL,
  `celularprofissional` VARCHAR(20) NULL DEFAULT NULL,
  `numatricula` VARCHAR(30) NULL DEFAULT NULL,
  `codigopontoeletronico` VARCHAR(30) NULL DEFAULT NULL,
  `flbateponto` SMALLINT NULL DEFAULT 1,
  `dataadminissao` DATE NULL DEFAULT NULL,
  `cargahoraria` INT(11) NULL DEFAULT NULL,
  `banco` VARCHAR(45) NULL DEFAULT NULL,
  `agencia` VARCHAR(10) NULL DEFAULT NULL,
  `conta` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_procad`),
  INDEX `fk_procad_usucad_idx` (`fk_usucad` ASC),
  CONSTRAINT `fk_procad_usucad`
    FOREIGN KEY (`fk_usucad`)
    REFERENCES `db`.`tb_usuario` (`pk_usucad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db`.`tb_tipodocumentointerno` (
  `pk_tdicad` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_tdicad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db`.`tb_documentointerno` (
  `pk_docint` INT NOT NULL AUTO_INCREMENT,
  `fk_tdicad` INT NOT NULL,
  `fk_usucad` INT NOT NULL,
  `datacadastro` DATE NOT NULL,
  `texto` BLOB NULL,
  PRIMARY KEY (`pk_docint`),
  INDEX `fk_docint_tdicad_idx` (`fk_tdicad` ASC),
  INDEX `fk_docint_usucad_idx` (`fk_usucad` ASC),
  CONSTRAINT `fk_docint_tdicad`
    FOREIGN KEY (`fk_tdicad`)
    REFERENCES `db`.`tb_tipodocumentointerno` (`pk_tdicad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_docint_usucad`
    FOREIGN KEY (`fk_usucad`)
    REFERENCES `db`.`tb_usuario` (`pk_usucad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into tb_tipodocumentointerno(descricao) values('Visao');
insert into tb_tipodocumentointerno(descricao) values('Manual do Colaborador');
insert into tb_tipodocumentointerno(descricao) values('Politica de Deslocamento');
insert into tb_tipodocumentointerno(descricao) values('Politica de Viagem');
insert into tb_tipodocumentointerno(descricao) values('Politica de Qualidade');

CREATE TABLE IF NOT EXISTS `db`.`tb_mural` (
  `pk_murcad` INT NOT NULL AUTO_INCREMENT,
  `datacadastro` DATETIME NOT NULL,
  `texto` BLOB NULL,
  `fk_usucad` INT NOT NULL,
  `fk_murcad_resposta` INT NULL,
  PRIMARY KEY (`pk_murcad`),
  INDEX `fk_murcad_usucad_idx` (`fk_usucad` ASC),
  INDEX `fk_murcad_murcad_idx` (`fk_murcad_resposta` ASC),
  CONSTRAINT `fk_murcad_usucad`
    FOREIGN KEY (`fk_usucad`)
    REFERENCES `db`.`tb_usuario` (`pk_usucad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_murcad_murcad`
    FOREIGN KEY (`fk_murcad_resposta`)
    REFERENCES `db`.`tb_mural` (`pk_murcad`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `db`.`tb_dependentes` (
  `pk_depcad` INT NOT NULL AUTO_INCREMENT,
  `fk_usucad` INT NOT NULL,
  `nome` VARCHAR(70) NULL,
  `parentesco` VARCHAR(45) NULL,
  `datanascimento` DATE NULL,
  `documento` VARCHAR(20) NULL,
  PRIMARY KEY (`pk_depcad`),
  INDEX `fk_depcad_usucad_idx` (`fk_usucad` ASC),
  CONSTRAINT `fk_depcad_usucad`
    FOREIGN KEY (`fk_usucad`)
    REFERENCES `db`.`tb_usuario` (`pk_usucad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- **********************************************************************************************
-- CRIAR CONSTRAINT
-- **********************************************************************************************
DROP PROCEDURE IF EXISTS db.criarprocedure;
DELIMITER $$
CREATE PROCEDURE db.criarprocedure()
BEGIN
  DECLARE contador Int DEFAULT 0;
  
  SELECT count(*) 
    INTO contador
    FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
   WHERE CONSTRAINT_NAME = 'fk_usucad_carcad';

  if (contador = 0) then
    ALTER TABLE `db`.`tb_usuario` 
    ADD CONSTRAINT `fk_usucad_carcad`
    FOREIGN KEY (`fk_carcad`)
    REFERENCES `db`.`cargos` (`id`)
	ON DELETE CASCADE
    ON UPDATE CASCADE;
  end if;
END $$;
DELIMITER ;

CALL db.criarprocedure;
DROP PROCEDURE IF EXISTS db.criarprocedure;

INSERT INTO cargos(id, descricao) values(36, "Nenhum");
commit;  
INSERT INTO tb_usuario (pk_usucad,ativo,celular,dataCadastro,email,login,nome,senha,sexo,sobrenome,fk_usgcad,fk_carcad) 
     VALUES (3,true,'(81) 98855-3931','2017-05-15','phferreira@informa.com.br','pedro','Pedro','03ba0cf12ee5b9a4d7da021dee54117f966d5a6944d277b6f55c151eb3f227f4','M','Ferreira',2,36);
commit;  
