package com.swap.namenode;

class OpenFileResponse
{
	
}

class CloseFileResponse
{
	
}

class GetBlockLocationResponse
{
	
}


class AssignBlockResponse
{
	
}


class ListResponse
{
	
}

class BlockReportResponse
{
	
}

class HeartBeatResponse
{
	
}


public interface IRequestParser {
	
	public OpenFileResponse openFile(byte[] openFileRequest);
	
	public CloseFileResponse closeFile(byte[] closeFileRequest);
	
	public GetBlockLocationResponse getBlockLocations(byte[] getBlockLOcationsRequest);

	public AssignBlockResponse assignBlock(byte[] assignBlockRequest);
	
	public ListResponse list(byte[] listRequest);

	public BlockReportResponse blockReport(byte[] blockReportRequest);
	
	public HeartBeatResponse heartBeat(byte[] heartBeatRequest);
}
