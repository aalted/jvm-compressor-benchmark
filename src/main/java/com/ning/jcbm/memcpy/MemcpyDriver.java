package com.ning.jcbm.memcpy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ning.jcbm.DriverBase;

public class MemcpyDriver extends DriverBase {

	public MemcpyDriver() {
		super("Memcpy");
	}

	// No native Block API; but need some impl for test framework

	@Override
	protected int compressBlock(byte[] uncompressed, byte[] compressBuffer) throws IOException {
		System.arraycopy(uncompressed, 0, compressBuffer, 0, uncompressed.length);
		return uncompressed.length;
	}

	@Override
	protected int uncompressBlock(byte[] compressed, byte[] uncompressBuffer) throws IOException {
		System.arraycopy(compressed, 0, uncompressBuffer, 0, compressed.length);
		return compressed.length;
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
