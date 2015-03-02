package com.swap.namenode;

public class NameNode implements INameNode {

	IRequestParser requestParser = new ProtoRequestParser();
	
	@Override
	public byte[] openFile(byte[] openFileRequest) {
		
		// call openFile on requestParser to get the response OpenFileRsponse.
		
		return null;
	}

	@Override
	public byte[] closeFile(byte[] closeFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBlockLocations(byte[] getBlockLOcationsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] assignBlock(byte[] assignBlockRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] list(byte[] listRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] blockReport(byte[] blockReportRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] heartBeat(byte[] hearBeatRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Here code should be to set this up as remote object
		// which would be called from client
		// Should be multithreaded..
		
		
		// For now just call individual methods from here..
		
	}

}
