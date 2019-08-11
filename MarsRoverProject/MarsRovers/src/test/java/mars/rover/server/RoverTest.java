package mars.rover.server;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vedzah
 */
public class RoverTest {
    
    public RoverTest() {
    }

    /**
     * Test of establishConnection method, of class Rover.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        Rover instance = new RoverImpl();
        instance.establishConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recieveTelemetryData method, of class Rover.
     */
    @Test
    public void testRecieveTelemetryData() {
        System.out.println("recieveTelemetryData");
        Rover instance = new RoverImpl();
        instance.recieveTelemetryData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendCrushMessage method, of class Rover.
     */
    @Test
    public void testSendCrushMessage() {
        System.out.println("sendCrushMessage");
        Rover instance = new RoverImpl();
        instance.sendCrushMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendSuccessMessage method, of class Rover.
     */
    @Test
    public void testSendSuccessMessage() {
        System.out.println("sendSuccessMessage");
        Rover instance = new RoverImpl();
        instance.sendSuccessMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Rover.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Rover.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RoverImpl extends Rover {
    }
    
}
