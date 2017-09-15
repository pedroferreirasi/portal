unit UMain;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.ExtCtrls, Vcl.StdCtrls, Vcl.Buttons,
  Vcl.ComCtrls, UModule, Data.DB, Datasnap.DBClient, Vcl.Grids, Vcl.DBGrids;

const
  C_XHTML_TEMPLATE = '<!DOCTYPE html> '+#13+#10+
                     '<ui:composition template="/template/templatepesquisa.xhtml" '+#13+#10+
                     '	xmlns="http://www.w3.org/1999/xhtml" '+#13+#10+
                     '	xmlns:f="http://xmlns.jcp.org/jsf/core" '+#13+#10+
                     '	xmlns:h="http://xmlns.jcp.org/jsf/html" '+#13+#10+
                     '	xmlns:p="http://primefaces.org/ui" '+#13+#10+
                     '	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"> '+#13+#10+
                     ' '+#13+#10+
                     '    <ui:define name="titulo"> '+#13+#10+
                     '      <h1>Pesquisa de {ALIAS_NORMAL}</h1> '+#13+#10+
                     '      <ol class="breadcrumb"> '+#13+#10+
                     '        <li><a href="mainmenu.xhtml"><i class="fa fa-dashboard"></i> Home</a></li> '+#13+#10+
                     '        <li><a href="#">Cadastros</a></li> '+#13+#10+
                     '        <li class="active">{ALIAS_NORMAL}</li> '+#13+#10+
                     '      </ol> '+#13+#10+
                     '    </ui:define> '+#13+#10+
                     ' '+#13+#10+
                     '	<ui:define name="titulobotao"> '+#13+#10+
                     '		<ui:param name="entityBean" value="#{{ALIAS_NORMAL}Controller}" /> '+#13+#10+
                     '	</ui:define> '+#13+#10+
                     ' '+#13+#10+
                     '	</ui:define> '+#13+#10+
                     '	<ui:define name="colunasdogrid"> '+#13+#10+
                     '		<f:facet name="header"> '+#13+#10+
                     '      Lista de {ALIAS_NORMAL} '+#13+#10+
                     '		</f:facet> ';

  C_CONTROLLER = 'package br.com.informa.portalrh;'+#13+#10+
                 ''+#13+#10+
                 ''+#13+#10+
                 'import javax.faces.bean.ManagedBean; '+#13+#10+
                 'import javax.faces.bean.ViewScoped; '+#13+#10+
                 'import br.com.informa.core.GenericController; '+#13+#10+
                 'import br.com.informa.models.portalrh.{ALIAS_NORMAL}; '+#13+#10+
                 'import br.com.informa.models.dominio.EEstadoForm; '+#13+#10+
                 'import br.com.informa.negocio.core.FactoryNegocio; '+#13+#10+
                 ' '+#13+#10+
                 '@ManagedBean(name = "{ALIAS_NORMAL}Controller") '+#13+#10+
                 '@ViewScoped '+#13+#10+
                 'public class {ALIAS_NORMAL}Controller extends GenericController<{ALIAS_NORMAL}, Integer> { '+#13+#10+
                 ' '+#13+#10+
                 '	public {ALIAS_NORMAL}Controller() { '+#13+#10+
                 '		entityNegocio = FactoryNegocio.getFactory().get{ALIAS_NORMAL}(); '+#13+#10+
                 '		this.novo(); '+#13+#10+
                 '		listaEntity = this.getListAll(); '+#13+#10+
                 '	} '+#13+#10+
                 ' '+#13+#10+
                 '	public void novo() '+#13+#10+
                 '	{ '+#13+#10+
                 '  if (this.entity != null) {' +#13+#10+
                 '    this.entity = null;' +#13+#10+
                 '  } '+#13+#10+
                 '		this.entity = new {ALIAS_NORMAL}(); '+#13+#10+
                 '		this.estado = EEstadoForm.Incluir; '+#13+#10+
                 '	} '+#13+#10+
                 '} ';

  C_REPOSITORY_CLASSDAO = 'package br.com.informa.repositories.dao.portalrh;'+#13+#10+
                          ''+#13+#10+
                          ''+#13+#10+
                          'import br.com.informa.repositories.dao.hibernate.HibernateDao; '+#13+#10+
                          'import br.com.informa.models.portalrh.{ALIAS_NORMAL}; ' +#13+#10+
                          ' '+#13+#10+
                          'public class {ALIAS_NORMAL}DaoImpl extends HibernateDao<{ALIAS_NORMAL}, Integer>  implements {ALIAS_NORMAL}Dao { '+#13+#10+
                          ' '+#13+#10+
                          '} ';

  C_REPOSITORY_INTERFACEDAO = 'package br.com.informa.repositories.dao.portalrh;'+#13+#10+
                              ''+#13+#10+
                              ''+#13+#10+
                              'import br.com.informa.models.portalrh.{ALIAS_NORMAL}; '+#13+#10+
                              'import br.com.informa.repositories.dao.IDao; '+#13+#10+
                              ' '+#13+#10+
                              'public interface {ALIAS_NORMAL}Dao extends IDao<{ALIAS_NORMAL}, Integer> { '+#13+#10+
                              '} ';

  C_SERVICE_INTERFACE = 'package br.com.informa.negocio.portalrh;'+#13+#10+
                        ''+#13+#10+
                        ''+#13+#10+
                        'import br.com.informa.models.common.{ALIAS_NORMAL}; '+#13+#10+
                        'import br.com.informa.negocio.common.INegocio; '+#13+#10+
                        ' '+#13+#10+
                        'public interface {ALIAS_NORMAL}Negocio extends INegocio<{ALIAS_NORMAL}, Integer> { '+#13+#10+
                        '} ';

  C_SERVICE_CLASS = 'package br.com.informa.negocio.portalrh;'+#13+#10+
                    ''+#13+#10+
                    ''+#13+#10+
                    'import java.util.List; '+#13+#10+
                    'import br.com.informa.models.portalrh.{ALIAS_NORMAL}; '+#13+#10+
                    'import br.com.informa.repositories.dao.FactoryDao; '+#13+#10+
                    'import br.com.informa.repositories.dao.portalrh.{ALIAS_NORMAL}Dao; '+#13+#10+
                    ' '+#13+#10+
                    'public class {ALIAS_NORMAL}NegocioImpl implements {ALIAS_NORMAL}Negocio { '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public void Add({ALIAS_NORMAL} entity) { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		entityDao.Add(entity);		 '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public void Update({ALIAS_NORMAL} entity) { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		entityDao.Update(entity); '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public void delete({ALIAS_NORMAL} entity) { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		entityDao.delete(entity);		 '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public void deleteById(Integer id) { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		entityDao.deleteById(id);	 '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public {ALIAS_NORMAL} getById(Integer pk) { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		return entityDao.getById(pk); '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override '+#13+#10+
                    '	public List<{ALIAS_NORMAL}> getListAll() { '+#13+#10+
                    '		{ALIAS_NORMAL}Dao entityDao = FactoryDao.getFactory().get{ALIAS_NORMAL}Dao(); '+#13+#10+
                    '		return entityDao.getListAll(); '+#13+#10+
                    '	} '+#13+#10+
                    ' '+#13+#10+
                    '	@Override'+#13+#10+
                    '	public Boolean validacao({ALIAS_NORMAL} entity) {'+#13+#10+
                    '		// TODO Auto-generated method stub '+#13+#10+
                    '		return true; '+#13+#10+
                    ' }'+#13+#10+
                    '} ';

  C_MODEL = 'package br.com.informa.models.portalrh;'+#13+#10+
            ''+#13+#10+
            ''+#13+#10+
            'import javax.persistence.Table; '+#13+#10+
            'import javax.persistence.Id; '+#13+#10+
            'import javax.persistence.Column; '+#13+#10+
            'import javax.persistence.Entity; '+#13+#10+
            'import javax.persistence.EnumType; '+#13+#10+
            'import javax.persistence.Enumerated; '+#13+#10+
            'import javax.persistence.GeneratedValue; '+#13+#10+
            'import javax.xml.bind.annotation.XmlAccessType; '+#13+#10+
            'import javax.xml.bind.annotation.XmlAccessorType; '+#13+#10+
            'import javax.xml.bind.annotation.XmlRootElement; '+#13+#10+
            'import javax.xml.bind.annotation.XmlElement; '+#13+#10+
            'import java.io.Serializable; '+#13+#10+
            ' '+#13+#10+
            '@Entity '+#13+#10+
            '@Table(name="{ALIAS_NOME_TABELA}") '+#13+#10+
            '@XmlRootElement '+#13+#10+
            '@XmlAccessorType(XmlAccessType.FIELD) '+#13+#10+
            'public class {ALIAS_NORMAL} implements Serializable {	'+#13+#10+
            ' ';

type
  TParametro = class
    aliasTabela : String;
    alias : String;
  end;

  TFrPrincipal = class(TForm)
    PN_Top: TPanel;
    PN_Bottom: TPanel;
    PN_Grid: TPanel;
    PageControl1: TPageControl;
    TabSheet1: TTabSheet;
    Edt_Host: TEdit;
    Label1: TLabel;
    BT_Carregar: TSpeedButton;
    Label2: TLabel;
    Edt_Tabela: TEdit;
    Label3: TLabel;
    Edt_Alias: TEdit;
    cds: TClientDataSet;
    cdscampo: TStringField;
    cdsobrigatorio: TBooleanField;
    cdsdatatype: TStringField;
    cdschaveprimaria: TBooleanField;
    cdstamanhocampo: TIntegerField;
    cdsalias: TStringField;
    DBGrid1: TDBGrid;
    ds: TDataSource;
    BT_Gerar: TSpeedButton;
    BT_Conectar: TSpeedButton;
    cdsincluirnogrid: TBooleanField;
    Label4: TLabel;
    Edt_Caminho: TEdit;
    GroupBox1: TGroupBox;
    ckModelo: TCheckBox;
    ckRepositorio: TCheckBox;
    ckServico: TCheckBox;
    ckController: TCheckBox;
    ckXthml: TCheckBox;
    lblUsuario: TLabel;
    edtuser: TEdit;
    lblSenha: TLabel;
    edtpassword: TEdit;
    procedure FormCreate(Sender: TObject);
    procedure BT_CarregarClick(Sender: TObject);
    procedure BT_GerarClick(Sender: TObject);
    procedure BT_ConectarClick(Sender: TObject);
  private
    { Private declarations }
    FDataModule : TDTModule;
    FCaminho : String;
    function substituirConstantes(CStringConstante : String; PAlias, PTexto : string) : String;
    function getTipo(ATipo : String) : String;
    procedure criarRepositoryClass(AParametro : TParametro);
    procedure criarRepositoryInterface(AParametro : TParametro);
    procedure criarServiceClass(AParametro : TParametro);
    procedure criarServiceInterface(AParametro : TParametro);
    procedure criarModelo(AParametro : TParametro);
    procedure criarController(AParametro : TParametro);
    procedure criarXHTML(AParametro : TParametro);
    procedure validar;
  public
    { Public declarations }
  end;

var
  FrPrincipal: TFrPrincipal;

implementation

{$R *.dfm}

{ TFrPrincipal }

procedure TFrPrincipal.BT_ConectarClick(Sender: TObject);
begin
  if Trim(Edt_Host.Text) <> '' then
  begin
    FDataModule.Conn.Params.Values['HostName'] := Trim(Edt_Host.Text);
  end;

  if Trim(edtuser.Text) <> '' then
  begin
    FDataModule.Conn.Params.Values['user_name'] := Trim(edtuser.Text);
  end;

  if Trim(edtpassword.Text) <> '' then
  begin
    FDataModule.Conn.Params.Values['password'] := Trim(edtpassword.Text);
  end;

  FDataModule.Conn.Close;
  FDataModule.Conn.Open;
end;

procedure TFrPrincipal.BT_GerarClick(Sender: TObject);
var
  LEntity : TParametro;
begin
  Self.validar;
  LEntity := TParametro.Create;
  try
    if Trim(Edt_Caminho.Text) <> '' then
    begin
      FCaminho := Trim(Edt_Caminho.Text);
    end;

    LEntity.aliasTabela := Edt_Tabela.Text;
    LEntity.alias := Edt_Alias.Text;

    if ckRepositorio.Checked then
    begin
     Self.criarRepositoryClass(LEntity);
     Self.criarRepositoryInterface(LEntity);
    end;
    if ckServico.Checked then
    begin
      Self.criarServiceClass(LEntity);
      Self.criarServiceInterface(LEntity);
    end;
    if ckModelo.Checked then
    begin
      Self.criarModelo(LEntity);
    end;
    if ckController.Checked then
    begin
      Self.criarController(LEntity);
    end;
    if ckXthml.Checked then
    begin
      Self.criarXHTML(LEntity);
    end;
  finally
    FreeAndNil(LEntity);
  end;

  ShowMessage('Gerado com sucesso!!!');
end;

procedure TFrPrincipal.criarController(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  AssignFile(f,FCaminho+AParametro.alias+'Controller.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_CONTROLLER, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarModelo(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  LRepositoryClass := C_REPOSITORY_CLASSDAO;
  AssignFile(f,FCaminho+AParametro.alias+'.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_MODEL, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Writeln(f,'');
  cds.First;
  while not cds.Eof do
  begin
    if cds.FieldByName('chaveprimaria').AsBoolean then
    begin
      Writeln(f,'    @Id');
      Writeln(f,'    @GeneratedValue');
    end;

    if cds.FieldByName('obrigatorio').AsBoolean then
    begin
      Writeln(f,'    @Column(name="' + cds.FieldByName('campo').AsString + '", nullable=true, length=' +
              cds.FieldByName('tamanhocampo').AsString + ')');
    end
    else
    begin
      Writeln(f,'    @Column(name="' + cds.FieldByName('campo').AsString + '", nullable=false, length=' + cds.FieldByName('tamanhocampo').AsString + ')');
    end;
    if Self.getTipo(cds.FieldByName('datatype').AsString) = 'Calendar' then
    begin
      Writeln(f,'    @Temporal(TemporalType.DATE)');
    end;
    Writeln(f,'    private ' + Self.getTipo(cds.FieldByName('datatype').AsString) + ' ' + cds.FieldByName('alias').AsString + ';');
    Writeln(f,'');

    cds.Next;
  end;

  Writeln(f,'}');

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarRepositoryClass(AParametro : TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  LRepositoryClass := C_REPOSITORY_CLASSDAO;
  AssignFile(f,FCaminho+AParametro.alias+'DaoImpl.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_REPOSITORY_CLASSDAO, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarRepositoryInterface(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  AssignFile(f,FCaminho+AParametro.alias+'Dao.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_REPOSITORY_INTERFACEDAO, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarServiceClass(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  AssignFile(f,FCaminho+AParametro.alias+'NegocioImpl.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_SERVICE_CLASS, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarServiceInterface(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  AssignFile(f,FCaminho+AParametro.alias+'Negocio.java');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_SERVICE_INTERFACE, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.criarXHTML(AParametro: TParametro);
var
  F: TextFile;
  LRepositoryClass : String;
begin
  AssignFile(f,FCaminho+AParametro.alias+'.xhtml');
  Rewrite(f); //abre o arquivo para escrita

  LRepositoryClass := Self.substituirConstantes(C_XHTML_TEMPLATE, '{ALIAS_NORMAL}', AParametro.alias);
  LRepositoryClass := Self.substituirConstantes(LRepositoryClass, '{ALIAS_NOME_TABELA}', AParametro.aliasTabela);

  Writeln(f,LRepositoryClass);// escreve no arquivo e desce uma linha

  cds.First;
  while not cds.Eof do
  begin
    if cds.FieldByName('incluirnogrid').AsBoolean then
    begin
      Writeln(f,'		<p:column width="9%" sortBy="#{entity.' + cds.FieldByName('alias').AsString + '}" style="text-align: center" ');
      Writeln(f,'			headerText="' + cds.FieldByName('alias').AsString + '" filterable="#{entityBean.habilitarPesquisa}" ');
      Writeln(f,'			filterBy="#{entity.' + cds.FieldByName('alias').AsString + '}"> ');
      Writeln(f,'			<h:outputText value="#{entity.' + cds.FieldByName('alias').AsString + '}" /> ');
      Writeln(f,'		</p:column> ');
    end;
    cds.Next;
  end;

  Writeln(f,' 	</ui:define> ');
  Writeln(f,' ');
  Writeln(f,'	<ui:define name="teladecadastro"> ');
  Writeln(f,'		<p:row style="border: none"> ');

  //***************************************************************************
  // INCLUIR AQUI OS CAMPOS DO CADASTRO
  //***************************************************************************

  Writeln(f,'		<f:facet name="footer"> ');
  Writeln(f,' ');
  Writeln(f,'		</f:facet> ');
  Writeln(f,'	</ui:define> ');
  Writeln(f,' ');
  Writeln(f,'</ui:composition> ');


  Closefile(f); //fecha o handle de arquivo
end;

procedure TFrPrincipal.FormCreate(Sender: TObject);
begin
  FCaminho := 'D:\Projetos\portalrh\DbToJava\destino\';
  FDataModule := TDTModule.Create(self);
end;

function TFrPrincipal.getTipo(ATipo: String): String;
begin
  if UpperCase(ATipo) = 'VARCHAR'  then
  begin
    Result := 'String';
  end
  else if UpperCase(ATipo) = 'INT'  then
  begin
    Result := 'Integer';
  end
  else if UpperCase(ATipo) = 'FLOAT'  then
  begin
    Result := 'Float';
  end
  else if UpperCase(ATipo) = 'DATE'  then
  begin
    Result := 'Calendar';
  end
  else if UpperCase(ATipo) = 'DATETIME'  then
  begin
    Result := 'Calendar';
  end
  else if UpperCase(ATipo) = 'TIME'  then
  begin
    Result := 'Calendar';
  end;
end;

procedure TFrPrincipal.BT_CarregarClick(Sender: TObject);
begin
  if trim(Edt_Host.Text) = '' then
  begin
    //raise Exception.Create('Campo Host é obrigatório');
  end;

  Self.validar;

  if not FDataModule.Conn.Connected then
  begin
    BT_Conectar.Click;
  end;

  FDataModule.QR_Origem.SQL.Text := 'SELECT column_name, '+
                                    '       is_nullable, '+
                                    '       data_type,   '+
                                    '       column_key,   '+
                                    '       IFNULL(numeric_precision, character_maximum_length) tamanho  '+
                                    '  FROM information_schema.columns '+
                                    ' WHERE TABLE_NAME = :tabela  '+
                                    ' order by ordinal_position desc ';
  FDataModule.QR_Origem.ParamByName('tabela').AsString := Trim(Edt_Tabela.Text);
  FDataModule.QR_Origem.Open;

  cds.CreateDataSet;

  FDataModule.QR_Origem.First;
  while not FDataModule.QR_Origem.Eof do
  begin
    cds.Insert;
    cds.FieldByName('campo').AsString := FDataModule.QR_Origem.FieldByName('column_name').AsString;
    cds.FieldByName('obrigatorio').AsBoolean := (FDataModule.QR_Origem.FieldByName('is_nullable').AsString = 'YES');
    cds.FieldByName('datatype').AsString := FDataModule.QR_Origem.FieldByName('data_type').AsString;
    cds.FieldByName('chaveprimaria').AsBoolean := (FDataModule.QR_Origem.FieldByName('column_key').AsString = 'PRI');
    cds.FieldByName('tamanhocampo').AsInteger := FDataModule.QR_Origem.FieldByName('tamanho').AsInteger;
    cds.FieldByName('incluirnogrid').AsBoolean := False;
    cds.Post;
    FDataModule.QR_Origem.Next;
  end;
end;

function TFrPrincipal.substituirConstantes(CStringConstante, PAlias,
  PTexto: string): String;
begin
  Result := StringReplace(CStringConstante, PAlias, PTexto, [rfReplaceAll, rfIgnoreCase]);
end;

procedure TFrPrincipal.validar;
begin
  if trim(Edt_Tabela.Text) = '' then
  begin
    raise Exception.Create('Campo tabela é obrigatório');
  end;
  if trim(Edt_Alias.Text) = '' then
  begin
    raise Exception.Create('Campo alias é obrigatório');
  end;
end;

end.
