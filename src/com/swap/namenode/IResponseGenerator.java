package com.swap.namenode;

import com.swap.namenode.Helper.*;

public interface IResponseGenerator {
	
	public byte[] openFile(OpenFileResponse openFileResponse);
	
	public byte[] closeFile(CloseFileResponse closeFileResponse);
	
	public byte[] getBlockLocations(BlockLocationResponse getBlockLocationsResponse);

	public byte[] assignBlock(AssignBlockResponse assignBlockResponse);
	
	public byte[] list(ListResponse listResponse);

	public byte[] blockReport(BlockReportResponse blockReportResponse);
	
	public byte[] heartBeat(HeartBeatResponse heartBeatResponse);
	
	public byte[] readBlock(ReadBlockResponse readBlockResponse);
	
	public byte[] writeBlock(WriteBockResponse writeBockResponse);
	
}
