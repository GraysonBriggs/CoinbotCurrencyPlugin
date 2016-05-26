import java.util.HashMap;
import java.util.List;

import api.IBotPlugin;
import api.IPluginManager;



public class Currency implements IBotPlugin {

	private IPluginManager manager;
	
	public Currency() {
		//unused
	}
	
	@Override
	public int getPluginVersion() {
		return 1;
	}

	@Override
	public String getPluginName() {
		return "currency";
	}

	@Override
	public List<String> getPluginDependencies() {
		return null;
	}

	@Override
	public void preInit(IPluginManager manager) {
		this.manager = manager;
	}

	@Override
	public void onDatabaseConnectionRefreashed() {
//		this.updateCoinStatement = this.conn.prepareStatement("INSERT INTO coins (username, coins) VALUES (?, 10) ON DUPLICATE KEY UPDATE coins = coins+1");
//		this.makeItRainStatement = this.conn.prepareStatement("INSERT INTO coins (username, coins) VALUES (?, 10) ON DUPLICATE KEY UPDATE coins = coins+?");
//		this.addCoinStatement = this.conn.prepareStatement("INSERT INTO coins (username, coins) VALUES (?, ?) ON DUPLICATE KEY UPDATE coins = coins+?");
//		this.getCoins = this.conn.prepareStatement("SELECT coins FROM coins WHERE username = ?");
		
	}

	@Override
	public void postInit() {
		//Do nothing
		
	}

	@Override
	public void onMessage(String username, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCommandLineMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSubscription(String username, int months) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWhisper(String username, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNotification(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPluginNotification(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRequestShutdown(String reason) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onForceShutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTimerTick(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBotPlugin getNewInstanceOfThis() {
		return new Currency();
	}

	@Override
	public String getPluginDescription() {
		return "Adds a currency to chat!\nAllows other plugins to interface with a common currency.";
	}

	@Override
	public String getPluginAuthor() {
		return "Grayson Briggs";
	}

	@Override
	public String[] onPluginDataPipe(String requester, HashMap<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
