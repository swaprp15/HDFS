package com.swap.namenode;

public interface IRequestGenerator {
	
	public byte[] openFile(OpenFileRequest openFileRequest);
	
	public byte[] closeFile(CloseFileRequest closeFileRequest);
	
	public byte[] getBlockLocations(BlockLocationRequest getBlockLOcationsRequest);

	public byte[] assignBlock(AssignBlockRequest assignBlockRequest);
	
	public byte[] list(ListRequest listRequest);

	public byte[] blockReport(BlockReportRequest blockReportRequest);
	
	public byte[] heartBeat(HeartBeatRequest heartBeatRequest);
	
	public byte[] readBlock(ReadBlockRequest readBlockRequest);
	
	public byte[] writeBlock(WriteBockRequest writeBockRequest);
}
