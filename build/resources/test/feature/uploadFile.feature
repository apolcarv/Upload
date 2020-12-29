Feature: Pagina web Basic

  @UploadFile
  Scenario Outline: Ingresar a la pagina web y montar un archivo
    Given El cliente ingresa a la pagina
    And Visualia el home <Inicio>
    When el cliente carga el archivo
    Then visualiza la carga exitosa <Resultado>

    Examples:
     |Inicio|Resultado|
     |File Uploader|Info.txt|

