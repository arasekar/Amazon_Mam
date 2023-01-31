package com.property;

import java.io.IOException;

public class Configurationhelper {

	private Configurationhelper() {
		
	}

	public static ConfgurationReader getInstanceCR() throws IOException {
		ConfgurationReader reader = new ConfgurationReader();
		return reader;

	}

}
