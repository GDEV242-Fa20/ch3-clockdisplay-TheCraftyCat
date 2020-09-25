/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Catherine Oldfield
 * @for RVCC GDEV242 - Fall 2020
 * @from code written by Michael Kölling and David J. Barnes
 * @version 09/25/2020
 * 
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean isAM;           // indicates morning or evening
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        // this line removed for 12-hour version of the clock...
        // hours = new NumberDisplay(24);
        
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        isAM = true;            // assume clock "starts" in the morning
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, boolean isItMorning)
    {
        // this line removed for 12-hour version of the clock...
        // hours = new NumberDisplay(24);
        
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
        isAM = isItMorning;
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
    
    /**
     * Return the current time of this display in the format HH:MM AM
     * (or HH:MM PM, if appropriate)
     */
    public String get12HourInternalDisplay()
    {
        
        if (hours.getValue() >= 12)
        {
            isAM = false; // the time is PM, not AM        
        }
        
        // this is a test block of text
        // because git desktop isn't working
        // and i am troubleshooting the connection
        
        return null; //placeholder!
    }
}
