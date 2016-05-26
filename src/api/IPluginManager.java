package api;


import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface IPluginManager {
	
	/**
	 * Gets the channel name that the bot is connected to
	 * @return Returns the name of the channel this manager is connected to
	 */
	String getChannelName();
	
	/**
	 * Gets the bot's logged in username
	 * @return the bot's username
	 */
	String getBotUsername();
	
	/**
	 * Gets the current quiet level for the chat. This number represents how verbose the bot should be in Twitch chat
	 * 0 - No talking. No output will be printed. the SendMessage will ensure this, but your plugin should as well this is the only enforced quiet level
	 * 1 - absolute minumum but keep everything working. No spammy messages
	 * 2 - default mode, everything at a plugin's discression
	 * 3 - verbose mode, mostly debug stuff
	 * @return The int representing the current chat's quiet level
	 */
	int getQuietLevel();
	
	/**
	 * Checks if the given plugin is enabled
	 * @param pluginName The name of the plugin to look for
	 * @return true if the specified plugin is enabled, false otherwise
	 */
	boolean isPluginEnabled(String pluginName);
	
	/**
	 * Checks if the given user is a mod for the current channel
	 * @param username The username to check
	 * @return true if the user is a mod, false if not
	 */
	boolean isMod(String username);
	
	/**
	 * Returns a list of the channel's moderators
	 * @return the list of moderators
	 */
	List<String> getModList();
	
	/**
	 * Checks if the given user is a SuperMod for the current channel
	 * @param username The username to check
	 * @return true if the user is a SuperMod, false if not
	 */
	boolean isSuperMod(String username);
	
	/**
	 * Returns a list of the channel's SuperMods
	 * @return the list of SuperMods
	 */
	List<String> getSuperModList();
	
	/**
	 * Checks if the given user is a subscriber for the current channel, the user has to have spoken in chat to be registered
	 * @param username The username to check
	 * @return true if the user is a subscriber, false if not
	 */
	boolean isSubscriber(String username);
	
	/**
	 * Returns a list of the channel's subscribers that have talked in chat so far
	 * @return the list of subscribers that have talked so far
	 */
	List<String> getSubscriberList();
	
	/**
	 * Puts data passed in from a plugin into a Map that allows other
	 * Plugins to read the data from the map via {@link #getGlobalData(String)}
	 * @param key The key to be used for the {@link Map}
	 * @param val the value to insert using the given key
	 * @see #getGlobalData(String)
	 */
	void putGlobalData(String key, String val);
	
	/**
	 * Access data that is shared between multiple plugins that was inserted using {@link #putGlobalData(String, String)}
	 * @param key the key used for the Map
	 * @return returns the Map value associated with the given key
	 * @see #putGlobalData(String, String)
	 */
	String getGlobalData(String key);
	
	/**
	 * Sends a message to the channel's public chat. Appearing as the bot's logged in user
	 * @param message The message to send to chat
	 */
	void sendChatMessage(String message);
	
	/**
	 * Sends A private message via Twitch's whisper/private message system
	 * @param username The user to send the message to
	 * @param message the message to send to the user
	 */
	void sendWhisperMessage(String username, String message);
	
	
	String[] requestPluginDataPipe(String myPluginName, String targetPluginName, HashMap<String, String> data);
	
	/**
	 * Forces an update to the current mod list
	 * @return true if the list was updated, false if the list is being updated too quickly
	 */
	boolean reloadModList();
	
	/**
	 * Sends a message to the console
	 * @param prefix the text to be put inside [] to identify the sender
	 * @param message the message to send to the console
	 */
	void sendConsoleMessage(String prefix, String message);
	
	/**
	 * Get the database connection that all plugins share
	 * @return a connection to this bot's database. Possibility of being invalid
	 */
	Connection getDatabaseConnection();
	
	/**
	 * Registers a scheduled event to happen using the given id
	 * @param plugin this plugin so the timer has a refrence
	 * @param id the id to identify a specific event, so different time intervals can be told apart
	 * @return true if it was registered successfully, false if that id already exists for this plugin
	 */
	boolean registerTimer(IBotPlugin plugin, int id, TimeUnit time, int units);
	
}
