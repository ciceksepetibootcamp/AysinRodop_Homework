Feature:  Turk hava yollari

  Background:
    Given navigate to website

  Scenario : Ucus listeleme
    Given Tek yon secer
    When Varis noktasina Viyana girer
    And Tarihi girer
    Then Biletler listelenir

    Scenario Outline: Invalid PNR NO
      Given Kullanici check-in sayfasini acar
      When Yanlis no "<pnr_no>" girer
      And Yanlis "<surname>" girer
      Then PNRno hata mesaji goruntulenir
      Examples:
        | 1234567898765 | ARDEN |
        | SLAMDLSAKFMCD | SA^+DFKJN |


  Scenario: Invalid FlightNo
    Given Kullanici ucak takibi sayfasını acar
    When Yanlis ucus no girer
    Then UcusNo hata mesaji goruntulenir

