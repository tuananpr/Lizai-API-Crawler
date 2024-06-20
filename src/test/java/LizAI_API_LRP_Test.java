import Request.*;
import core.core.RequestBuilder;
import io.restassured.response.Response;

public class LizAI_API_LRP_Test {
    static String userSig;
    static String tokenUser = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImxpemFpIn0.BmRqkGVso-DVXTCUEwHHrCOT3lLFfaaA8HIq-SGBPx0";
    static String tokenAdmin;

    public static void main(String[] args) {
        Response response;

        //Contain_Classification
        {
            ContentClassificationRQ contentClassificationRQ = new ContentClassificationRQ();
            contentClassificationRQ.setQuery("Obesity Statistics");

            response = RequestBuilder.given()
                    .post("https://dev-content-classification-api.lizai.co/v1/parse")
                    .body(contentClassificationRQ,ContentClassificationRQ.class)
                    .auth("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImxpemFpIn0.BmRqkGVso-DVXTCUEwHHrCOT3lLFfaaA8HIq-SGBPx0")
                    .send();







//            SignInRQ signInRQ = new SignInRQ();
//            signInRQ.setDeviceId("eedxAkZ3d3zUxcWzZztEmaq2BXWwCeO2qQOUrNdw7YOm7bipqFi5DuIT+dkhu+pg");
//            signInRQ.setSignUpType("0");
//            signInRQ.setAccessToken("");
//            signInRQ.setAppleCode("");
//            signInRQ.setLanguage("");
//            signInRQ.setFromIOS("");
//            signInRQ.setAuthorizationCodeZalo("");
//            signInRQ.setCodeVerifierZalo("");
//            signInRQ.setEmail("matrixtest15@gmail.com");
//            signInRQ.setPassword("123456");
//            response = RequestBuilder.given()
//                    .post("https://dev-research-platform-apis.lizai.co/api/v1/User/SignIn")
//                    .body(signInRQ, SignInRQ.class)
//                    .encrypt()
//                    .send();
//
//            tokenAdmin = response.jsonPath().get("data.accessToken");
//            System.out.println("Token Admin " + tokenAdmin);
        }

    }}


