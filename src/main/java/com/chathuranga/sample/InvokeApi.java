package com.chathuranga.sample;

import org.springframework.http.HttpHeaders;

public class InvokeApi {
    public HttpHeaders getHttpHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJ4NXQiOiJJV19MWld0SVpWSnRZdU5MQ0FZZjkzUW9fQnMiLCJraWQiOiJZVGt3TmpZNE1URXdZalZrT0RoaE1UQm1OREl6TVdaak5EUTFZV0V4TVRZeVlqUTFOamcxWlRZek5EQXlaakpqT0RrNU16aGtNamd3T0RnMlkyTmhOd19SUzI1NiIsInR5cCI6ImF0K2p3dCIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJZRVJfTW93NnFUZnR3V2pTTnZSYU80QUpyaXdhIiwiYXV0IjoiQVBQTElDQVRJT04iLCJpc3MiOiJodHRwczpcL1wvYXBpLmFzZ2FyZGVvLmlvXC90XC9jaGF0aHVyYW5nYXBcL29hdXRoMlwvdG9rZW4iLCJjbGllbnRfaWQiOiJZRVJfTW93NnFUZnR3V2pTTnZSYU80QUpyaXdhIiwiYXVkIjoiWUVSX01vdzZxVGZ0d1dqU052UmFPNEFKcml3YSIsIm5iZiI6MTczMjk4NTE5NiwiYXpwIjoiWUVSX01vdzZxVGZ0d1dqU052UmFPNEFKcml3YSIsIm9yZ19pZCI6ImU5ZTA2ZTRhLWQ4NjQtNGFhOS1hNDA0LWFmY2FkM2YyY2IzNCIsInNjb3BlIjoiaW50ZXJuYWxfdXNlcl9tZ3RfY3JlYXRlIGludGVybmFsX3VzZXJfbWd0X2RlbGV0ZSBpbnRlcm5hbF91c2VyX21ndF9saXN0IGludGVybmFsX3VzZXJfbWd0X3VwZGF0ZSBpbnRlcm5hbF91c2VyX21ndF92aWV3IiwiZXhwIjoxNzMyOTg4Nzk2LCJvcmdfbmFtZSI6ImNoYXRodXJhbmdhcCIsImlhdCI6MTczMjk4NTE5NiwianRpIjoiZDA3MDAyZGYtZDVhNS00OGJiLWFiOGMtYzQyZTkzNzhmZjFiIn0.W8XYkiixjcRjXuGxaETYlkuDwmYiNKYTiTVaeJLDU2K6u0SCsi_yejwIIqxsPVru3tt6jLCJtWhdAvmBRqSBVGhD5-nT6L8soBQzUhSsEuU6aNxy3Pobo5gsJYaoF_4az6-rvk_3iNanSK7tqz3gl2aBmUDjLK3Ta-k7sXTV3Zw-QRI26gOFLDz1YUij-cioONbSS7hGzLeW4abCWhbjeAP2RHSWSfLg7nm3z13cO577pcBDV57XpF4AVFyAeZe4-ExJdhMXMzkLK0KgYuBpCakKUHBZQiJsA4GAn_z8Q0I4zZA5bZY8w4LhYIEfnlLDiDaEwfd-aGpYEn2LkKEU9g");
        headers.add("accept", "application/scim+json");
        return headers;
    }
}
