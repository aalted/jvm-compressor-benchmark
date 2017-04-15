package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverSnappy extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverSnappy() {
		super();
		bw.init();
		bw.setNumThreads(1);
		bw.setCompressor("snappy");
	}
}
