package stepdefinition;

import Request.SignInRQ;
import core.core.RequestBuilder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginStep {
    @When("i login with account")
//    vô đây nó sẽ thành ă cái map<>
    public void iLoginWithAccount(Map<String,String> data) {

//        SignInRQ signInRQ = new SignInRQ();
//                signInRQ.setDeviceId("eedxAkZ3d3zUxcWzZztEmaq2BXWwCeO2qQOUrNdw7YOm7bipqFi5DuIT+dkhu+pg");
//                signInRQ.setSignUpType("0");
//                signInRQ.setAccessToken("");
//                signInRQ.setAppleCode("");
//                signInRQ.setLanguage("");
//                signInRQ.setFromIOS("");
//                signInRQ.setAuthorizationCodeZalo("");
//                signInRQ.setCodeVerifierZalo("");
////                r muốn truyền vô object thì phải từ map get key ra -ok
//                signInRQ.setEmail(data.get("email"));
//                signInRQ.setPassword(data.get("password"));
//
//        Response response = RequestBuilder.given()
//                .post("https://dev-research-platform-apis.lizai.co/api/v1/User/SignIn")
//                .body(signInRQ, SignInRQ.class)
//                .encrypt()
//                .send();
//
//        String tokenAdmin = response.jsonPath().get("data.accessToken");
//        System.out.println("Token Admin " + tokenAdmin);



        // mà a nghiên cứu đưa khúc này lên thành ă class api riêng - ok
        // mình có thể quản lý theo controller vd: User thì mình tạo class user api r những cái nào thuộc nó thì quăng vô chung vd user/signin, user/signup ... -ok
        // hiện tại cái code của a chưa có maping convert cái body từ data table sang object nên nãy a thấy e truyền kiểu kia bị lỗi
        // cái web e mở có chỉ convert á a coi nha- ok em
        // nó có cconvert map sang class, data table sang class luôn, a cứ thêm cả â cái vô, mai mốt a muốn truyền kiểu nào cũng đc, thoải mái - ok
        // r còn gì nữa ko a - hết rồi, thanks em nha
    }
}

// r đó a - vay gio trinh tu là sao ta
// 1. a vo cái loginstep để post code - 2.
