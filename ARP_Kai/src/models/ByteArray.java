package models;

import java.io.Serializable;

public class ByteArray implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9055868641989020066L;
	private String string;
	private byte[] bytes;
	private Integer[] ints;
	boolean mac;

	public String getString() {
		return string;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public ByteArray(byte[] bytes, boolean mac) {
		this.bytes = bytes;
		this.mac = mac;
		if (mac) {
			
			makeInts(6);

			this.string = Integer.toHexString(this.ints[0]) + ":"
					+ Integer.toHexString(this.ints[1]) + ":"
					+ Integer.toHexString(this.ints[2]) + ":"
					+ Integer.toHexString(this.ints[3]) + ":"
					+ Integer.toHexString(this.ints[4]) + ":"
					+ Integer.toHexString(this.ints[5]);

		} else {
		
			makeInts(4);
			this.string = (this.ints[0]) + "." + (this.ints[1]) + "." + (this.ints[2]) + "."
					+ (this.ints[3]);
		}

	}

	private void makeInts(int n) {
		
		this.ints = new Integer[n];
		for (int i = 0; i < n; i++) {
			this.ints[i] = (int) this.bytes[i];
			if ((int) this.ints[i] < 0) {
				this.ints[i] += 256;
			}

		}

		
	}

	public ByteArray(String string, boolean mac) {
		this.mac = mac;
		this.string = string;

		if (mac) {
			String[] s = this.string.split(":");
			byte[] b = { (byte) (int) Integer.parseInt(s[0], 16),
					(byte) (int) Integer.parseInt(s[1], 16),
					(byte) (int) Integer.parseInt(s[2], 16),
					(byte) (int) Integer.parseInt(s[3], 16),
					(byte) (int) Integer.parseInt(s[4], 16),
					(byte) (int) Integer.parseInt(s[5], 16) };
			this.bytes = b;
			makeInts(6);
			

		} else {
			String[] s = this.string.split("\\.");
			byte[] b = { (byte) (int) Integer.parseInt(s[0]),
					(byte) (int) Integer.parseInt(s[1]),
					(byte) (int) Integer.parseInt(s[2]),
					(byte) (int) Integer.parseInt(s[3]) };
			this.bytes = b;
			makeInts(4);

		}
	}

	public Integer[] getInts() {
		return ints;
	}

}
