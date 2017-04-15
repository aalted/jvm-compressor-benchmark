package com.ning.jcbm.jblosc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jblosc.BloscWrapper;
import com.jblosc.PrimitiveSizes;
import com.ning.jcbm.DriverBase;

/**
 * Driver for jblosc codec from [https://github.com/blosc/jblosc].
 */
public class jbloscDriver extends DriverBase {
	BloscWrapper bw = new BloscWrapper();

	public jbloscDriver() {
		super("jblosc");
		bw.init();
		bw.setNumThreads(1);
		bw.setCompressor("lz4");
	}

	@Override
	protected int compressBlock(byte[] uncompressed, byte[] compressBuffer) throws IOException {
		int SIZE = uncompressed.length;
		int oBufferSize = SIZE + BloscWrapper.OVERHEAD;
		int iReturn = bw.compress(7, 0, PrimitiveSizes.BYTE_FIELD_SIZE, uncompressed, SIZE, compressBuffer,
				oBufferSize);
		return iReturn;
	}

	@Override
	protected int uncompressBlock(byte[] compressed, byte[] uncompressBuffer) throws IOException {
		int SIZE = uncompressBuffer.length;
		int iReturn = bw.decompress(compressed, uncompressBuffer, SIZE);
		return iReturn;
	}

	@Override
	protected void compressToStream(byte[] uncompressed, OutputStream rawOut) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected int uncompressFromStream(InputStream compIn, byte[] inputBuffer) throws IOException {
		throw new UnsupportedOperationException();
	}
}
