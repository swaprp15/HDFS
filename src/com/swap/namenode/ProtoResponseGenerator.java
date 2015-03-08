
public class ProtoResponseGenerator implements IResponseGenerator {

	@Override
	public byte[] openFile(OpenFileResponse openFileResponse) {
		// TODO Auto-generated method stub
		HDFS.OpenFileResponse.Builder op = HDFS.OpenFileResponse.newBuilder();
		//System.out.println("11111111111111  ");
		op.setStatus(openFileResponse.status);
		op.setHandle(openFileResponse.handle);
		//System.out.println("22222222222222  ");
		
		for(int num: openFileResponse.blockNums){
			op.addBlockNums(num);
		//	System.out.println(num);
		}
		/*for(int i=0; i< openFileResponse.blockNums.size();i++){
			int num = openFileResponse.blockNums.get(i);
			op.addBlockNums(num);
			System.out.println(num);
		}*/
		
		return op.build().toByteArray();
	}

	@Override
	public byte[] closeFile(CloseFileResponse closeFileRequest) {
		// TODO Auto-generated method stub
		HDFS.CloseFileResponse.Builder op = HDFS.CloseFileResponse.newBuilder();
		op.setStatus(closeFileRequest.status);
				
		return op.build().toByteArray();
	}

	@Override
	public byte[] getBlockLocations(
			BlockLocationResponse getBlockLocationsRequest) {
		// TODO Auto-generated method stub
		HDFS.BlockLocationResponse.Builder op = HDFS.BlockLocationResponse.newBuilder();
		op.setStatus(getBlockLocationsRequest.status);
		
		for(BlockLocations temp : getBlockLocationsRequest.blockLocations){
			HDFS.BlockLocations.Builder ab = HDFS.BlockLocations.newBuilder();
			ab.setBlockNumber(temp.blockNumber);
			
			for(DataNodeLocation dnl: temp.locations){
				HDFS.DataNodeLocation.Builder cd = HDFS.DataNodeLocation.newBuilder();
				cd.setIp(dnl.ip);
				cd.setPort(dnl.port);
				cd.build();
				ab.addLocations(cd);
			}
			ab.build();
			op.addBlockLocations(ab);
			
		}
		return op.build().toByteArray();
		
	}

	@Override
	public byte[] assignBlock(AssignBlockResponse assignBlockRequest) {
		// TODO Auto-generated method stub
				
		return assignBlockRequest.asgnBlockRequest.toByteArray();
	}

	@Override
	public byte[] list(ListResponse listRequest) {
		// TODO Auto-generated method stub
		
		return listRequest.listFilesResponse.toByteArray();
	}

	@Override
	public byte[] blockReport(BlockReportResponse blockReportRequest) {
		// TODO Auto-generated method stub
		return blockReportRequest.blockReportResponse.toByteArray();
	}

	@Override
	public byte[] heartBeat(HeartBeatResponse heartBeatRequest) {
		// TODO Auto-generated method stub
		return heartBeatRequest.hrtBeatResponse.toByteArray();
	}

	@Override
	public byte[] readBlock(ReadBlockResponse readBlockRequest) {
		// TODO Auto-generated method stub
		return readBlockRequest.rdBlockResponse.toByteArray();
	}

	@Override
	public byte[] writeBlock(WriteBlockResponse writeBlockRequest) {
		// TODO Auto-generated method stub
		return writeBlockRequest.wrBlockResponce.toByteArray();
	}

}
