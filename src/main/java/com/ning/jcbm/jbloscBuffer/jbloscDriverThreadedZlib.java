package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverThreadedZlib extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverThreadedZlib() {
		super();
		bw.init();
		bw.setNumThreads(4);
		bw.setCompressor("zlib");
	}
}
