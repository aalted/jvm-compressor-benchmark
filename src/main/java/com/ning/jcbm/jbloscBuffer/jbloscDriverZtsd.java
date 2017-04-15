package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverZtsd extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverZtsd() {
		super();
		bw.init();
		bw.setNumThreads(1);
		bw.setCompressor("ztsd");
	}
}
