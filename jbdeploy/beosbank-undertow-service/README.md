**Test the service using 

http  http://localhost:8080/beosbank-undertow-service/api/MoneyTransfer/1


HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json
Date: Tue, 11 Apr 2017 23:16:43 GMT
Set-Cookie: JSESSIONID=BWQN5v63IZA3LnVF6QI2aM6HNGWLqPRTamEMy4m_; path=/beosbank-undertow-service
Transfer-Encoding: chunked
```json
{
    "amountExcludingFees": 100.0,
    "amountExcludingFeesInReceiverCurrency": null,
    "amountIncludingFees": null,
    "creditCardNumber": "1111-2222-3333-4444",
    "fees": null,
    "id": 1,
    "keyCode": null,
    "receiver": {
        "address": {
            "city": null,
            "country": "Cameroon",
            "street": null,
            "zipcode": null
        },
        "birthDate": null,
        "firstName": "Orphelinat",
        "id": 1,
        "lastName": "1234"
    },
    "receiverCurrencyCode": "XAF",
    "sender": {
        "address": {
            "city": null,
            "country": "France",
            "street": null,
            "zipcode": null
        },
        "birthDate": null,
        "firstName": "Association ",
        "id": 2,
        "lastName": "URSO"
    },
    "senderCurrencyCode": "EUR",
    "sendingDate": "2017-04-11",
    "status": "DRAFT",
    "totalAmountExcludingVat": null,
    "totalAmountIncludingVat": null,
    "vatRate": null,
    "withdrawalDate": null
}
```
