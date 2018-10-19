package re.kr.keti.lcy.device.maxfor.packet;

import java.util.Arrays;

public class MaxforPacketBuffer {
	private static final int HEADER_SIZE = 4;
	private static final int TAIL_SIZE = 1;
	private static final int MAX_BUFFUR_SIZE = 1024;
	private static final byte MAXFOR_START_END_DATA = 0x7e;
	
	private byte[] buffer;
	private int front;
	private int rear;
	
	public MaxforPacketBuffer() {
		buffer = new byte[MAX_BUFFUR_SIZE];
		front = 0;
		rear = -1;
	}

	public synchronized void append(byte[] append, int length) {
	    for(int i=0; i<length; i++) {
	    	if(rear >= MAX_BUFFUR_SIZE-1) {
	    		rear = -1;
	    	}
	    	
	    	buffer[++rear] = append[i];
	    }
	}

	public synchronized byte[] extract() {
		boolean findStart = false;
		boolean findEnd = false;
		int startIndex = -1;
		int endIndex = -1;
		int length = 0;
		int extCount = 0;
		int packetCount = 0;
		
		if(rear - front >= 0) {
			length = rear - front;
		} else {
			length = (MAX_BUFFUR_SIZE - front) + rear;
		}
		
		for(int i=0; i<length+1; i++) {
			int index = i + front;
			if(index >= MAX_BUFFUR_SIZE) {
				index = index % MAX_BUFFUR_SIZE;
			}
			
			byte p = buffer[index];

			if(p == MAXFOR_START_END_DATA) {
				if(!findStart) {
					startIndex = index;
					int lengthIndex = index + 1;
					if(lengthIndex >= MAX_BUFFUR_SIZE) {
						lengthIndex = lengthIndex % MAX_BUFFUR_SIZE;
					}
					
					// header size (4) + payload size + tail size(1)
					packetCount = HEADER_SIZE + buffer[lengthIndex] + TAIL_SIZE;	
					findStart = true;
				} else if(!findEnd) {
					extCount++;
					if(extCount+1 < packetCount) {
						continue;
					}
					
					endIndex = index;
					front = endIndex+1;
					findEnd = true;
					break;
				}
			}
			
			if(findStart) {
				extCount++;
			}
		}
		
		if(findStart && findEnd) {
			if(endIndex - startIndex >= 0) {
				int packLen = endIndex - startIndex;
				byte[] nPack = new byte[packLen + 1];
				
				System.arraycopy(buffer, startIndex, nPack, 0, nPack.length);
				Arrays.fill(buffer, startIndex, endIndex+1, (byte) 0);
				
				return nPack;
			} else {
				int packLen = (MAX_BUFFUR_SIZE - startIndex) + endIndex;
				byte[] nPack = new byte[packLen + 1];
				
				System.arraycopy(buffer, startIndex, nPack, 0, MAX_BUFFUR_SIZE - startIndex);
				Arrays.fill(buffer, startIndex, MAX_BUFFUR_SIZE, (byte) 0);
				System.arraycopy(buffer, 0, nPack, MAX_BUFFUR_SIZE - startIndex, endIndex+1);
				Arrays.fill(buffer, 0, endIndex+1, (byte) 0);
				
				return nPack;
			}
		}
		
		return null;
	}
}