import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLoggerFactory {
  public static Logger getSimplestLogger() {
    Logger logger = Logger.getLogger(MyLoggerFactory.class.getName());
    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.ALL);
    logger.addHandler(consoleHandler);
    logger.setLevel(Level.ALL);
    return logger;
  }
}
