
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
	HDFS.CloseFileRequest closeFileRequest;
}


class AssignBlockRequest
{
	HDFS.AssignBlockRequest asgnBlockRequest;
}


class ListRequest
{
	HDFS.ListFilesRequest listFilesRequest;
}

class BlockReportRequest
{
	HDFS.BlockReportRequest blockReportRequest;
}

class HeartBeatRequest
{
	HDFS.HeartBeatRequest hrtBeatRequest;
}

class ReadBlockRequest
{
	int blockNumber;
}

class WriteBlockRequest
{
	HDFS.WriteBlockRequest wrBlockRequest;
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
	HDFS.AssignBlockRequest asgnBlockRequest;
}


class ListResponse
{
	HDFS.ListFilesResponse listFilesResponse;
}

class BlockReportResponse
{
	HDFS.BlockReportResponse blockReportResponse;
}

class HeartBeatResponse
{
	HDFS.HeartBeatResponse hrtBeatResponse;
}

class WriteBlockResponse
{
	HDFS.WriteBlockRequest wrBlockResponce;
}

class ReadBlockResponse
{
	HDFS.ReadBlockResponse rdBlockResponse;
}
