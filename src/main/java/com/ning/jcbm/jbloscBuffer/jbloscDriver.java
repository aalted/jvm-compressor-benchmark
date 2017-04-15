package com.ning.jcbm.jbloscBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

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
		ByteBuffer bbi = ByteBuffer.allocateDirect(uncompressed.length);
		bbi.put(uncompressed);
		int oBufferSize = SIZE + BloscWrapper.OVERHEAD;
		ByteBuffer bbo = ByteBuffer.allocateDirect(oBufferSize);
		int iReturn = bw.compress(7, 0, PrimitiveSizes.BYTE_FIELD_SIZE, bbi, SIZE, bbo, oBufferSize);
		bbo.get(compressBuffer, 0, iReturn);
		return iReturn;
	}

	@Override
	protected int uncompressBlock(byte[] compressed, byte[] uncompressBuffer) throws IOException {
		int SIZE = uncompressBuffer.length;
		ByteBuffer bbi = ByteBuffer.allocateDirect(compressed.length);
		bbi.put(compressed);
		ByteBuffer bbo = ByteBuffer.allocateDirect(SIZE);
		int iReturn = bw.decompress(bbi, bbo, SIZE);
		bbo.get(uncompressBuffer, 0, SIZE);
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

	@Override
	protected int compressBuffer(ByteBuffer in, ByteBuffer out) throws IOException {
		return bw.compress(7, 0, PrimitiveSizes.BYTE_FIELD_SIZE, in, in.capacity(), out, in.capacity() + bw.OVERHEAD);
	}

	@Override
	protected int uncompressBuffer(ByteBuffer in, ByteBuffer out) throws IOException {
		return bw.decompress(in, out, out.capacity());
	}
}
