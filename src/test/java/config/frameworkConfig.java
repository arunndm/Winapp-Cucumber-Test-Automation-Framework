package config;

public abstract class frameworkConfig {

    //Set the location of the windows application in the variable applicationLocation
    public static String applicationLocation = "Microsoft.SkypeApp_kzf8qxf38zg5c!App";

    //Set the remote adddress of Windows Driver in the variable winappRemoteDriver
    public static String winappRemoteDriver = "http://127.0.0.1:4723";

    //Set the Framework level global implicit wait time (in seconds) to the variable winappDefaultWaitTime
    public static long winappDefaultWaitTime = 30;

}
