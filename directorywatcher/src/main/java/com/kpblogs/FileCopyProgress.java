package com.kpblogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author kpal
 *
 */
interface ProgressCallBack {
	public void callback(CallbackByteChannel rbc, double progress);
}

public class FileCopyProgress implements ReadableByteChannel {
	public static void main(String[] args) {

		ProgressCallBack callBack = new ProgressCallBack() {

			public void callback(CallbackByteChannel rbc, double progress) {
				//System.out.println(rbc.getReadSoFar());
				System.out.println(progress);

				if (progress == 100) {
					System.out.println("File copied complted");
					// Write the logic here it will be called once file copied completed
				}

			}
		};

		try {
			copy("c:\\kpblogs\\src\\Watcher.png", "c:\\kpblogs\\dest\\Watcher.png", callBack);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void copy(String source, String destination, ProgressCallBack callBack) throws IOException {
		FileOutputStream fos = null;
		FileChannel sourceChannel = null;
		try {
			sourceChannel = new FileInputStream(new File(source)).getChannel();
			ReadableByteChannel rbc = new CallbackByteChannel(sourceChannel, Files.size(Paths.get(source)), callBack);
			fos = new FileOutputStream(destination);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sourceChannel.isOpen()) {
				sourceChannel.close();
			}
			fos.close();
		}
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public int read(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
}

class CallbackByteChannel implements ReadableByteChannel {
	ProgressCallBack delegate;
	long size;
	ReadableByteChannel rbc;
	long sizeRead;

	CallbackByteChannel(ReadableByteChannel rbc, long expectedSize, ProgressCallBack delegate) {
		this.delegate = delegate;
		this.size = expectedSize;
		this.rbc = rbc;
	}

	public void close() throws IOException {
		rbc.close();
	}

	public long getReadSoFar() {
		return sizeRead;
	}

	public boolean isOpen() {
		return rbc.isOpen();
	}

	public int read(ByteBuffer bb) throws IOException {
		int n;
		double progress;
		if ((n = rbc.read(bb)) > 0) {
			sizeRead += n;
			progress = size > 0 ? (double) sizeRead / (double) size * 100.0 : -1.0;
			delegate.callback(this, progress);
		}
		return n;
	}
}
