package test.catan;


//all tests use "John"as username and "Doe" as password
public class JunitTestDriver {
    public static void main(String[] args) {

        String[] testClasses = new String[] {
                "test.CatanModelTest",
                "test.PollerTest",
                "test.MockServerTest",
                "test.ServerFacadeTest",
                "test.ServerCommunicatorTest"
        };

        org.junit.runner.JUnitCore.main(testClasses);
    }
}