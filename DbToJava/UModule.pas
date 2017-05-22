unit UModule;

interface

uses
  System.SysUtils, System.Classes, Data.DBXMySQL, Data.DB, Data.SqlExpr,
  Data.FMTBcd;

type
  TDTModule = class(TDataModule)
    Conn: TSQLConnection;
    QR_Origem: TSQLQuery;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  DTModule: TDTModule;

implementation

{%CLASSGROUP 'Vcl.Controls.TControl'}

{$R *.dfm}

end.
