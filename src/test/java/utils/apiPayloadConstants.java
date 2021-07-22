package utils;

public class apiPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Jason\",\n" +
                "  \"emp_lastname\": \"Steitem\",\n" +
                "  \"emp_middle_name\": \"Middle\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1966-07-13\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Cloud Comsultant\"\n" +
                "}";

        return createEmployeePayload;
    }
}
