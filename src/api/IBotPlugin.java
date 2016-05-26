package api;


import java.util.HashMap;
import java.util.List;

//any plugins implement this interface and put a @Extension before the class
public interface IBotPlugin {
	
	int getPluginVersion();
	String getPluginName();
	String getPluginDescription();
	String getPluginAuthor();
	List<String> getPluginDependencies();
	void preInit(IPluginManager manager);
	void onDatabaseConnectionRefreashed();
	void postInit();
	void onMessage(String username, String message);
	void onCommandLineMessage(String message);
	String[] onPluginDataPipe(String requester, HashMap<String, String> data);
	void onSubscription(String username, int months);
	void onWhisper(String username, String message);
	void onNotification(String data);
	void onPluginNotification(String data);
	void onRequestShutdown(String reason);
	void onForceShutdown();
	/**
	 * gets called when a timer that was registered get triggered
	 * @param id The id this timer was registered with
	 */
	void onTimerTick(int id);
	/**
	 * 
	 * @return a newly constructed instance of this class ie return new MyPlugin();
	 */
	IBotPlugin getNewInstanceOfThis();
	
}
