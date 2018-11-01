import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Allen Yang
 * 2018/5/28 22:55
 */
public class TestLog4j {
    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/yangjun/Documents/practice/5,12/springmybatismission1/src/main/resources/log4j.properties");
        Logger logger = Logger.getLogger("TestLog4j.class");
        logger.debug("debug");
        logger.error("error");
    }
}
