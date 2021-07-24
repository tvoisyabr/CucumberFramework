package utils;

import APISteps.GenerateTokenSteps;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class apiCommonMethods {

    /*
     * use this method to prepare and create employee
     * */

    public static RequestSpecification createEmployeeRequest(String createEmployeePayload) {
        RequestSpecification request = given()
                .header(apiConstants.Header_Content_type, apiConstants.Content_type)
                .header(apiConstants.Header_Authorization, GenerateTokenSteps.token)
                .body(createEmployeePayload);

        return request;
    }
}
