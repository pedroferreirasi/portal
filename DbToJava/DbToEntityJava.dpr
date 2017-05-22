program DbToEntityJava;

uses
  Vcl.Forms,
  UMain in 'UMain.pas' {FrPrincipal},
  UModule in 'UModule.pas' {DTModule: TDataModule};

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TFrPrincipal, FrPrincipal);
  Application.Run;
end.
