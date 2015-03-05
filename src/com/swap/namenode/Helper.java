package com.swap.namenode;

import java.util.List;

public class Helper {

}

class DataNodeLocation
{
	int ip, port;
}

enum mode
{
	Read,
	Write
}

class OpenFileRequest
{
	String fileName;
	Boolean forRead;
}

class CloseFileRequest
{
	
}


class AssignBlockRequest
{
	
}


class ListRequest
{
	
}

class BlockReportRequest
{
	
}

class HeartBeatRequest
{
	
}

class ReadBlockRequest
{
	
}

class WriteBockRequest
{
	
}

class OpenFileResponse
{
	int status;
	int handle;
	List<Integer> blockNums;
}

class CloseFileResponse
{
	int status;
}

class BlockLocationRequest
{
	List<Integer> blockNums;
}

class BlockLocations
{
	int blockNumber;
	List<DataNodeLocation> locations;
}

class BlockLocationResponse
{
	int status;
	List<BlockLocations> blockLocations;
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

class WriteBockResponse
{
	
}

class ReadBlockResponse
{
	
}
