package org.dc.sd.input;

import org.apache.log4j.Logger;
import org.dc.sd.input.SDInput.SDInputType;
import org.dc.sd.input.impl.SDInputFileImpl;

public class SDInputFactory {

	private static Logger logger = Logger.getLogger(SDInputFactory.class);
	
	public static SDInput createSDInput(SDInputType type, String configFilePath) {
		SDInput sdInput = null;
		
		try {
			if(SDInputType.FILE.equals(type)) {
				sdInput = new SDInputFileImpl(configFilePath);
			} else if(SDInputType.TABLE.equals(type)) {
				
			}
		}catch(Exception e) {
			logger.error(e);
		}
		
		return sdInput;
	}
}
