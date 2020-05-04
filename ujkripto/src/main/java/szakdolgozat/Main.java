package szakdolgozat;

import org.apache.log4j.BasicConfigurator;
import szakdolgozat.ujkripto.application.UjkriptoApplication;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        UjkriptoApplication.main(args);
    }
}
