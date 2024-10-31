import Request.*;
import core.core.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class LizAI_API_LRP {
    String tokenSysAdmin;
    String userAdminName;
    String userAdminSig;
    String groupAdminFullPermissionsName;
    String groupAdminFullPermissionsSig;
    Response response;
    @Test (priority = 1)
    public void SignIn() {

        Request.SignInRQ signInRQ = new Request.SignInRQ();
        signInRQ.setDeviceId("eedxAkZ3d3zUxcWzZztEmaq2BXWwCeO2qQOUrNdw7YOm7bipqFi5DuIT+dkhu+pg");
        signInRQ.setSignUpType("0");
        signInRQ.setAccessToken("");
        signInRQ.setAppleCode("");
        signInRQ.setLanguage("");
        signInRQ.setFromIOS("");
        signInRQ.setAuthorizationCodeZalo("");
        signInRQ.setCodeVerifierZalo("");
        signInRQ.setEmail("matrixmax22@gmail.com");
        signInRQ.setPassword("Matrix@Tuan@9525");

        response = RequestBuilder.given()
                .post("https://dev-research-platform-apis.lizai.co/api/v1/User/SignIn")
                .body(signInRQ, Request.SignInRQ.class)
                .encrypt()
                .send();

        tokenSysAdmin = response.jsonPath().get("data.accessToken");
        System.out.println("Token Admin-" + tokenSysAdmin);

        response = RequestBuilder.given()
                .get("https://dev-research-platform-apis.lizai.co/api/v1/User/Functions")
                .auth(tokenSysAdmin)
                .send();
    }

    @Test (priority = 2)
    public void LoadUser() throws InterruptedException {
        LoadUserRQ loadUserRQ = new LoadUserRQ();
        loadUserRQ.setUserLogin("");
        loadUserRQ.setAccount("");
        loadUserRQ.setType(null);
        loadUserRQ.setStatus(63);
        loadUserRQ.setAttributes(null);
        loadUserRQ.setSearchName("");
        loadUserRQ.setGender(null);
        loadUserRQ.setFromCreateDate("");
        loadUserRQ.setRegion("");
        loadUserRQ.setFromCreateDate(null);
        loadUserRQ.setToCreateDate(null);
        loadUserRQ.setPage(1);
        loadUserRQ.setPageSize(5);

        response = RequestBuilder.given()
                .post("https://dev-research-platform-apis.lizai.co/api/v1/UserManager/LoadUsers")
                .body(loadUserRQ, Request.LoadUserRQ.class)
                .encrypt()
                .auth(tokenSysAdmin)
                .send();

        userAdminSig = response.jsonPath().get("data.list[2].userSig");
        userAdminName = response.jsonPath().get("data.list[2].userLogin");
        System.out.println("UserAdminName-"+ userAdminName +"-" +userAdminSig);
    }

    @Test(priority = 3)
    public void LoadTemplateUserFunctions() throws InterruptedException{

        TemplateUserFunctions templateUserFunctions = new TemplateUserFunctions();
        templateUserFunctions.setUserLogin("");
        templateUserFunctions.setAccount("");
        templateUserFunctions.setType(null);
        templateUserFunctions.setStatus(null);
        templateUserFunctions.setAttributes(null);
        templateUserFunctions.setSearchName("");
        templateUserFunctions.setGender(null);
        templateUserFunctions.setCountry("");
        templateUserFunctions.setRegion("");
        templateUserFunctions.setFromCreateDate(null);
        templateUserFunctions.setToCreateDate(null);
        templateUserFunctions.setPage(0);
        templateUserFunctions.setPageSize(20);

        response = RequestBuilder.given()
                .post("https://dev-research-platform-apis.lizai.co/api/v1/UserManager/TemplateUserFunctions")
                .body(templateUserFunctions, Request.TemplateUserFunctions.class)
                .encrypt()
                .auth(tokenSysAdmin)
                .send();

        groupAdminFullPermissionsName = response.jsonPath().get("data.list[4].name");
        groupAdminFullPermissionsSig = response.jsonPath().get("data.list[4].signaure");
        System.out.println("GroupTestPermissions-"+ groupAdminFullPermissionsName + "-" + groupAdminFullPermissionsSig);
    }

//    @Test(priority = 2)
//    public void CreateGroupPermissions(){
//        Response response;
//        CreateTemplateUserFunction createTemplateUserFunction = new CreateTemplateUserFunction();
//
//    }


//    @Test (priority = 2)
//    public void Functions(){
//        Response response;
//        response = RequestBuilder.given()
//                .get("https://dev-research-platform-apis.lizai.co/api/v1/User/Functions")
//                .auth(tokenSysAdmin)
//                .send();
//    }

//    @Test (priority = 2)
//    public void LoadUser() {
//        Request.LoadUserRQ loadUserRQ = new Request.LoadUserRQ();
//        loadUserRQ.setType("");
//        loadUserRQ.setStatus("63");
//        loadUserRQ.setAttributes("");
//        loadUserRQ.setFromOnDate("");
//        loadUserRQ.setToOnDate("");
//        loadUserRQ.setFromCreateDate("");
//        loadUserRQ.setToCreateDate("");
//        loadUserRQ.setPage("1");
////        loadUserRQ.setPagesize("10");
//        RequestBuilder.given()
//                .post("https://dev-research-platform-apis.lizai.co/api/v1/UserManager/LoadUsers")
//                .auth(tokenAdmin)
//                .body(loadUserRQ, Request.LoadUserRQ.class)
//                .encrypt()
//                .send();
//    }
//
//    @Test (priority = 3)
//    public void GrantPermissionsFunction() {
//
//
//
//        Functions functions = new Functions();
//        functions.setGrantPermissions(false);
//        functions.setLevel("2");
//        functions.setType(1);
//        functions.setEnable(false);
//
//        Permissions permissions = new Permissions();
//        permissions.setFunctions(functions);
//        permissions.setName("?userManager");
//        permissions.setGroup("1");
//
//        Request.GrantPermissionsFunction grantPermissionsFunction = new Request.GrantPermissionsFunction();
//        grantPermissionsFunction.setPermissions(permissions);
//        grantPermissionsFunction.setUserSig("73716F65503650545058653854546F4831616E5A46513D3D");
//
//        RequestBuilder.given()
//                .post("https://dev-research-platform-apis.lizai.co/api/v1/UserManager/LoadUsers")
//                .auth(tokenAdmin)
//                .body(grantPermissionsFunction, Request.GrantPermissionsFunction.class)
//                .encrypt()
//                .send();
//
//    }

//        Request.CreateUserRQ CreateUser = new Request.CreateUserRQ();
//        CreateUser.setEmail("matrixtest1@gmail.com");
//        CreateUser.setPassword("123456");
//        CreateUser.setName("MatrixTest");
//        CreateUser.setFirstName("Matrix");
//        CreateUser.setLastName("Test1");
//        CreateUser.setPhone("0908070605");
//        RequestBuilder.given()
//                .post("https://dev-research-platform-apis.lizai.co/api/v1/UserManager/CreateUser")
//                .auth(token)
//                .body(CreateUser, Request.CreateUserRQ.class)
//                .encrypt()
//                .send();
//    }
//}


//        Request.UpdateInfoRQ bodyUpdate = new Request.UpdateInfoRQ();
//        bodyUpdate.setDisplayName("Tuan");
//        bodyUpdate.setAddress("73 Rạch Bùng Binh");
//        bodyUpdate.setDob("2000-11-09T00:00:00.000");
//        bodyUpdate.setPhone("09090909090");
//        bodyUpdate.setGender("2");
//        bodyUpdate.setCountry("VN");
//
//        RequestBuilder.given()
//                .put("https://apis1.globedr.com/api/v1/Account/EUpdatePersonalInfo")
//                .auth(token)
//                .body(bodyUpdate, Request.UpdateInfoRQ.class)
//                .encrypt()
//                .send();
//
//        RequestBuilder.given()
//                .get("https://apis1.globedr.com/api/v1/Account/GetPersonalInfo")
//                .auth(token)
//                .send();
//    public static login (Map<String,Object> ){};
//
//        Map<String,Object> loginBody = new HashMap<>();
//        loginBody.put("gdrLogin","0392777320");
//        loginBody.put("password","123456");
//        loginBody.put("country","VN");
//        loginBody.put("deviceId","3m4ihc9y8TqoZ2cAbF3yUEmGeLCbGdkV6ohmasp5/us=");

//        Map<String, Object> encryptBody = new HashMap<>();
//        encryptBody.put("k",encryptDESKeyWithRSA());
//        encryptBody.put("d",encryptDataWithDesKey(loginBody));

//        RequestBuilder.given()
//                .post("https://apis1.globedr.com/api/v1/Account/ESignIn")
//                .body(loginBody)
//                .encrypt()
//                .send();
//
//    }


//        Map<String,Object> map = new HashMap<>();
//        map.put("chunkNumber", 1);
//        map.put("resumableTotalChunks",1);
//        map.put("fileName", "hinh");
//        map.put("file",new File("D:\\BT\\JavaBT\\restAssureEx\\File\\hinh.png"));
//        map.put("resumableType", "png");
//        map.put("resumableIdentifier", "hinh.png");
//
//        Request.AddFilesRQ addFilesRQ = new Request.AddFilesRQ();
//        addFilesRQ.setFile(new File("D:\\BT\\JavaBT\\restAssureEx\\File\\hinh.png"));
//        addFilesRQ.setFileName("hinh");
//        addFilesRQ.setResumableType("png");
//        addFilesRQ.setResumableIdentifier("hinh.png");
//
//        RequestBuilder.given()
//                .post("https://apis1.globedr.com/api/v1/Consult/AddFiles")
//                .auth("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoidzk2N3FWV1U3VVplVE15akg2VWFMajd2V1huenNuVEdSeUt1bndlNHpNZzhBaU5xS1hLcjZhVHJCMzByck1tSDEzbFpmVlhGaEVrQmV6eUVJOXF0ZDZGLy9ZcWsrdTBVU2xLMTRKNWlpcVdVMW52S1owcmVPc0wxc3BBbmhpR3JPalNNb3JvMS9PQTQxUzZPbEdZdFRrcE9hbm9La2dQLzh3emVPSVlnZWJheWYyR3g0N3RCTWlUU3UrN0dFUG5KSkFtYzlDRzdNaXp3a0IwdEVOSWRseEtyMHEvQlQvL0lHTDZ2Z2RrdjJpSjVFb3FZTEducVZ2NHJwamhZcTdQamRPQXZOV0RxMm1ialpvdmZjUVBkSCtTQkIxQWxrU2tZIiwianRpIjoiNDNiODBmM2EtNjI5Yi00OWJhLWIwNWQtOTU4MGFiMjMyZmE3IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiMiIsImNyZWF0ZWREYXRlIjoiMDMvMTUvMjAyMiAwNjoxMTo0OCIsImlzcyI6Imdsb2JlZHIiLCJhdWQiOiJnbG9iZWRyIn0.14_GKGuwSDlIMJ4OJBwIJ-nz5MgrKYoYQxr4mwuKBOw")
//                .body(addFilesRQ)
//                .send();


}

