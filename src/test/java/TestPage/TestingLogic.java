package TestPage;

import Base.Base;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestingLogic extends Base {

    @Test
    public void CheckRole(String role) throws IOException, ParseException {
        String a = getLoginCredentials(role,"Role");
        System.out.println(a);
        String b = getLoginCredentials(role,"Email");
        System.out.println(b);
        String c = getLoginCredentials(role,"Password");
        System.out.println(c);

    }


}
