package API;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.List;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTc5NTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjY2MTE1MCwidXNlcklkIjoiMjk1MSJ9.qZtrYNrwZjDS60jT3Hwd4Fe-oKdQ7eE9Uwb-fQ17AC4";
    static String employee_id;

    //@Test
    public void sampleTest() {
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", "14016");

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());
    }

    @Test
    public void aPostCreateEmployee() {
        RequestSpecification preparedRequest = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Jason\",\n" +
                        "  \"emp_lastname\": \"Steitem\",\n" +
                        "  \"emp_middle_name\": \"Middle\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1966-07-13\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"Cloud Comsultant\"\n" +
                        "}");//.log().all(); //prints all log that was sent with request

        Response response = preparedRequest.when().post("/createEmployee.php");
        //response.prettyPrint(); //converts json request to a string and prints it out

        /*
        * allows us to retrieve specific data from json object - just like xpath in selenium*/

        employee_id = response.jsonPath().getString("Employee.employee_id");
        //System.out.println(employee_id);

        response.then().assertThat().statusCode(201);
        /*
        * using Hamcrest Matchers class equalsTo */
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Jason"));
        /*
        * Verifying Server */

        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bGetCreatedEmployee() {
        RequestSpecification preparedRequest = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        //response.prettyPrint();

        String empID = response.jsonPath().getString("employee.employee_id");
        boolean comparingEmpIDS = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpIDS);

        String firstname = response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstname.contentEquals("Jason"));
    }

    //@Test
    public void cGetAllEmployees() {
        RequestSpecification preparedRequest = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json");

        Response response = preparedRequest.when().get("/getAllEmployees.php");
        String allEmployees = response.prettyPrint();

        JsonPath js = new JsonPath(allEmployees);
        int count = js.getInt("Employees.size()");
        System.out.println(count);

        //print out all employee ids
        for (int i = 0; i < count; i++) {
           String empployeeIDs = js.getString("Employees[" + i + "].employee_id");
           //System.out.println(empployeeIDs);
            if (empployeeIDs.contentEquals(employee_id)) {
                System.out.println("Employee ID " + employee_id + " is present");
                String firstname= js.getString("Employees["+ i +"].emp_firstname");
                System.out.println("Employee's firstname is " + firstname);
                break;
            }
        }
    }

    @Test
    public void dPutUpdateCreatedEmployee() {
        RequestSpecification preparedRequest = given()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Jason\",\n" +
                        "  \"emp_lastname\": \"Smith\",\n" +
                        "  \"emp_middle_name\": \"The Second\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1967-07-13\",\n" +
                        "  \"emp_status\": \"Worker\",\n" +
                        "  \"emp_job_title\": \"Cloud Architect\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
    }
}
