package mars.rover.interfaces;

/**
 *
 * @author Vedzah
 */
public interface Messages {
    
    public void establishConnection();
    
    public void recieveTelemetryData();
    
    public void sendCrushMessage();
    
    public void sendSuccessMessage();
    
}
