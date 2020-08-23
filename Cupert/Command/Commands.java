package Cupert.Command;

public abstract class Commands {
	public abstract String getAlias();
	public abstract String getDescription();
	public abstract String getSynstax();
	public abstract void onCommand(String command, String[] args)throws Exception; 
	public int FlyMode;
}
