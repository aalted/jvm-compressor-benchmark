package com.ning.jcbm.jbloscBuffer;

import com.jblosc.BloscWrapper;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriverBloscLz extends jbloscDriver {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriverBloscLz() {
		super();
		bw.init();
		bw.setNumThreads(1);
		bw.setCompressor("blosclz");
	}
}
