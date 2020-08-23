package Cupert.Settings;

import java.util.Arrays;
import java.util.List;

public class ModeSettings extends setting {
	public List<String> modes;
	public int index;
	public ModeSettings( String name, String defaultMode, String... modes) {
		this.name = name; 
		this.modes = Arrays.asList(modes);
		index = this.modes.indexOf(defaultMode);
	}
	public String getModes() {
		return modes.get(index);
	}
	public boolean is(String mode) {
		return index == modes.indexOf(mode);
		
	}
	public void cycle() {
		if(index > modes.size() - 1) {
			index++;
		}else {
			index = 0;
		}
	}
}

