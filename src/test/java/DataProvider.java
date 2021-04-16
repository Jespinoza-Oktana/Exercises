import utilities.StringFunctions;

public class DataProvider {
    @org.testng.annotations.DataProvider(name = "send data")
    public Object[][] registerOption(){
        return  new Object[][]{
                {StringFunctions.randomEmail(10), "Test","ExerciseOne","password","Javier Pradro","Lima","00000","938362123","test address"}
        };
    }
    @org.testng.annotations.DataProvider(name = "contact message")
    public Object[][] message(){
        return  new Object[][]{
                {StringFunctions.randomEmail(10), "12353","A simple test"}
        };
    }
}


