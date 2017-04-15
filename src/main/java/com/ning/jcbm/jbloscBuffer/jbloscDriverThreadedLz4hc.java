package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverThreadedLz4hc extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverThreadedLz4hc() {
		super();
		bw.init();
		bw.setNumThreads(4);
		bw.setCompressor("lz4hc");
	}
}
