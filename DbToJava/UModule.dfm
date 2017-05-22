object DTModule: TDTModule
  OldCreateOrder = False
  Height = 187
  Width = 129
  object Conn: TSQLConnection
    ConnectionName = 'MySQLConnection'
    DriverName = 'MySQL'
    LoginPrompt = False
    Params.Strings = (
      'DriverName=MySQL'
      'HostName=192.168.25.7'
      'Database=db'
      'User_Name=root'
      'Password=ana13bia'
      'ServerCharSet='
      'BlobSize=-1'
      'ErrorResourceFile='
      'LocaleCode=0000'
      'Compressed=False'
      'Encrypted=False'
      'ConnectTimeout=60')
    Left = 40
    Top = 32
  end
  object QR_Origem: TSQLQuery
    MaxBlobSize = -1
    Params = <>
    SQL.Strings = (
      'SELECT column_name,'
      '       is_nullable,'
      '       data_type,'
      '       column_key,'
      
        '       IFNULL(numeric_precision, character_maximum_length) taman' +
        'ho'
      '  FROM information_schema.columns'
      '')
    SQLConnection = Conn
    Left = 40
    Top = 96
  end
end
