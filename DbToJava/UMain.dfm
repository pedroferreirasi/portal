object FrPrincipal: TFrPrincipal
  Left = 0
  Top = 0
  Caption = 'FrPrincipal'
  ClientHeight = 531
  ClientWidth = 1096
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  WindowState = wsMaximized
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object PN_Top: TPanel
    Left = 0
    Top = 0
    Width = 1096
    Height = 193
    Align = alTop
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 16
      Width = 22
      Height = 13
      Caption = 'Host'
    end
    object BT_Carregar: TSpeedButton
      Left = 316
      Top = 104
      Width = 177
      Height = 57
      Caption = 'Carregar'
      Flat = True
      OnClick = BT_CarregarClick
    end
    object Label2: TLabel
      Left = 316
      Top = 16
      Width = 32
      Height = 13
      Caption = 'Tabela'
    end
    object Label3: TLabel
      Left = 316
      Top = 58
      Width = 22
      Height = 13
      Caption = 'Alias'
    end
    object BT_Gerar: TSpeedButton
      Left = 499
      Top = 104
      Width = 177
      Height = 57
      Caption = 'Gerar'
      Flat = True
      OnClick = BT_GerarClick
    end
    object BT_Conectar: TSpeedButton
      Left = 16
      Top = 104
      Width = 289
      Height = 57
      Caption = 'Conectar'
      Flat = True
      OnClick = BT_ConectarClick
    end
    object Label4: TLabel
      Left = 16
      Top = 58
      Width = 41
      Height = 13
      Caption = 'Caminho'
    end
    object Edt_Host: TEdit
      Left = 16
      Top = 35
      Width = 289
      Height = 21
      TabOrder = 0
    end
    object Edt_Tabela: TEdit
      Left = 316
      Top = 35
      Width = 360
      Height = 21
      TabOrder = 1
    end
    object Edt_Alias: TEdit
      Left = 316
      Top = 77
      Width = 360
      Height = 21
      TabOrder = 2
    end
    object Edt_Caminho: TEdit
      Left = 16
      Top = 77
      Width = 289
      Height = 21
      TabOrder = 3
    end
    object GroupBox1: TGroupBox
      Left = 697
      Top = 16
      Width = 112
      Height = 145
      Caption = 'Filtro'
      TabOrder = 4
      object ckModelo: TCheckBox
        Left = 14
        Top = 21
        Width = 97
        Height = 17
        Caption = 'Modelo'
        Checked = True
        State = cbChecked
        TabOrder = 0
      end
      object ckRepositorio: TCheckBox
        Left = 14
        Top = 41
        Width = 97
        Height = 17
        Caption = 'Reposit'#243'rio'
        Checked = True
        State = cbChecked
        TabOrder = 1
      end
      object ckServico: TCheckBox
        Left = 14
        Top = 62
        Width = 97
        Height = 17
        Caption = 'Servi'#231'o'
        Checked = True
        State = cbChecked
        TabOrder = 2
      end
      object ckController: TCheckBox
        Left = 14
        Top = 83
        Width = 97
        Height = 17
        Caption = 'Controller'
        Checked = True
        State = cbChecked
        TabOrder = 3
      end
      object ckXthml: TCheckBox
        Left = 14
        Top = 105
        Width = 97
        Height = 17
        Caption = 'XHTML'
        Checked = True
        State = cbChecked
        TabOrder = 4
      end
    end
  end
  object PN_Bottom: TPanel
    Left = 0
    Top = 490
    Width = 1096
    Height = 41
    Align = alBottom
    TabOrder = 1
  end
  object PN_Grid: TPanel
    Left = 0
    Top = 193
    Width = 1096
    Height = 297
    Align = alClient
    TabOrder = 2
    object PageControl1: TPageControl
      Left = 1
      Top = 1
      Width = 1094
      Height = 295
      ActivePage = TabSheet1
      Align = alClient
      TabOrder = 0
      object TabSheet1: TTabSheet
        Caption = 'Principal'
        object DBGrid1: TDBGrid
          Left = 0
          Top = 0
          Width = 1086
          Height = 267
          Align = alClient
          DataSource = ds
          TabOrder = 0
          TitleFont.Charset = DEFAULT_CHARSET
          TitleFont.Color = clWindowText
          TitleFont.Height = -11
          TitleFont.Name = 'Tahoma'
          TitleFont.Style = []
          Columns = <
            item
              Expanded = False
              FieldName = 'campo'
              Title.Caption = 'Campo'
              Width = 150
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'obrigatorio'
              Title.Caption = 'Null'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'datatype'
              Title.Caption = 'Tipo'
              Width = 80
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'chaveprimaria'
              Title.Caption = 'Prim'#225'ria'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'tamanhocampo'
              Title.Caption = 'Tamnho'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'alias'
              Title.Caption = 'Alias'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'incluirnogrid'
              Title.Caption = 'Grid'
              Visible = True
            end>
        end
      end
    end
  end
  object cds: TClientDataSet
    Aggregates = <>
    Params = <>
    Left = 1010
    Top = 283
    object cdscampo: TStringField
      FieldName = 'campo'
      Size = 70
    end
    object cdsobrigatorio: TBooleanField
      FieldName = 'obrigatorio'
    end
    object cdsdatatype: TStringField
      FieldName = 'datatype'
      Size = 30
    end
    object cdschaveprimaria: TBooleanField
      FieldName = 'chaveprimaria'
    end
    object cdstamanhocampo: TIntegerField
      FieldName = 'tamanhocampo'
    end
    object cdsalias: TStringField
      FieldName = 'alias'
      Size = 50
    end
    object cdsincluirnogrid: TBooleanField
      FieldName = 'incluirnogrid'
    end
  end
  object ds: TDataSource
    DataSet = cds
    Left = 1016
    Top = 335
  end
end
