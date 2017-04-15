package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverLz4hc extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverLz4hc() {
		super();
		bw.init();
		bw.setNumThreads(1);
		bw.setCompressor("lz4hc");
	}
}
