package interfaces;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface EnterValue {
	public Object EnterValue(String string, String value, String attribute);	
	
	LocalDateTime dateAndTime = LocalDateTime.now();
	

	default LocalDateTime getLocalDateTime() {
		// TODO Auto-generated method stub
		return dateAndTime;
	}
	
	default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
	
    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +
                "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

}
