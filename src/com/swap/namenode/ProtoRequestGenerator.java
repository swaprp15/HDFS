public class ProtoRequestGenerator implements IRequestGenerator
{

	@Override
	public byte[] openFile(OpenFileRequest openFileRequest) {
		// TODO Auto-generated method stub
		
		HDFS.OpenFileRequest.Builder op = HDFS.OpenFileRequest.newBuilder();
		op.setFileName(openFileRequest.fileName);
		op.setForRead(openFileRequest.forRead);
		
		return op.build().toByteArray();
	}

	@Override
	public byte[] closeFile(CloseFileRequest closeFileRequest) {
		// TODO Auto-generated method stub
		
		return closeFileRequest.closeFileRequest.toByteArray();
	}

	@Override
	public byte[] getBlockLocations(
			BlockLocationRequest getBlockLocationsRequest) {
		// TODO Auto-generated method stub
		HDFS.BlockLocationRequest.Builder op = HDFS.BlockLocationRequest.newBuilder();
		
		for(int temp : getBlockLocationsRequest.blockNums){
			op.addBlockNums(temp);
		}
		return op.build().toByteArray();		
	}

	@Override
	public byte[] assignBlock(AssignBlockRequest assignBlockRequest) {
		// TODO Auto-generated method stub
		return assignBlockRequest.asgnBlockRequest.toByteArray();
	}

	@Override
	public byte[] list(ListRequest listRequest) {
		// TODO Auto-generated method stub
		return listRequest.listFilesRequest.toByteArray();
	}

	@Override
	public byte[] blockReport(BlockReportRequest blockReportRequest) {
		// TODO Auto-generated method stub
		return blockReportRequest.blockReportRequest.toByteArray();
	}

	@Override
	public byte[] heartBeat(HeartBeatRequest heartBeatRequest) {
		// TODO Auto-generated method stub
		return heartBeatRequest.hrtBeatRequest.toByteArray();
	}

	@Override
	public byte[] readBlock(ReadBlockRequest readBlockRequest) {
		// TODO Auto-generated method stub
		HDFS.ReadBlockRequest.Builder op = HDFS.ReadBlockRequest.newBuilder();
		op.setBlockNumber(readBlockRequest.blockNumber);
		return op.build().toByteArray();
	}

	@Override
	public byte[] writeBlock(WriteBlockRequest writeBlockRequest) {
		// TODO Auto-generated method stub
		return writeBlockRequest.wrBlockRequest.toByteArray();
	}

	
}
