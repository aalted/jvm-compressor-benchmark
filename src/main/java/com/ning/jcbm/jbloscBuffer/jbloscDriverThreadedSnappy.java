package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverThreadedSnappy extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverThreadedSnappy() {
		super();
		bw.init();
		bw.setNumThreads(4);
		bw.setCompressor("snappy");
	}
}
