import Request.*;
import core.core.RequestBuilder;
import io.restassured.response.Response;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;


public class LizAI_API_Crawler {

    String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImxpemFpIn0.BmRqkGVso-DVXTCUEwHHrCOT3lLFfaaA8HIq-SGBPx0";
    String query = "diseases";
    double minValue = 0.5;
    double maxValue = 1;
    boolean relevant;
    float confident_score;
    Response response;

    @DataProvider
    public Object[][] dataProvider() {
        return ExcelReader.getResponseDataFromXLSX();
    }


    @Test (priority = 1, dataProvider = "dataProvider")
    public void Content(String input, String expectedResult){
        ContentClassificationRQ contentClassificationRQ = new ContentClassificationRQ();
        contentClassificationRQ.setQuery(input);
        contentClassificationRQ.setUrl(expectedResult);


        response = RequestBuilder.given()
                .post("https://dev-content-classification-api.lizai.co/v1/parse")
                .body(contentClassificationRQ, ContentClassificationRQ.class)
                .auth(userToken)
                .send();

        System.out.println(Optional.ofNullable(response.getBody().jsonPath().get("is_relevant")));
        Assert.assertEquals(response.getBody().jsonPath().get("is_relevant"),true);

        confident_score = response.getBody().jsonPath().get("confident_score");

        Assert.assertTrue(confident_score > minValue);
        System.out.println(confident_score + " > " + minValue);
        Assert.assertTrue(confident_score < maxValue);
        System.out.println(confident_score + " < " + maxValue);
    }
}
