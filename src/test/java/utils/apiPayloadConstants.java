package utils;

import org.json.JSONObject;

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

    public static String createEmployeeBody() {

        /*
         * We imported dependency for JSON Object
         * */

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Jason");
        obj.put("emp_lastname", "Statham");
        obj.put("emp_middle_name", "Middle");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1966-07-13");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "Cloud Consultant");

        return obj.toString();
    }

    public static String createEmployeeDynamic(String firstName, String lastName,
                                               String middleName, String empGender, String empBirthday,
                                               String empStatus, String empJobTitle) {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", empGender);
        obj.put("emp_birthday", empBirthday);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title", empJobTitle);

        return obj.toString();
    }
}
