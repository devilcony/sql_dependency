package org.dc.sd.input;

import java.util.List;

public interface SDInput {
	
	public static enum SDInputType {
		FILE,TABLE
	}

	public List<String> getInput();
}
