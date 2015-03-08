public interface IResponseParser {
	
	public OpenFileResponse openFile(byte[] openFileResponse);
	
	public CloseFileResponse closeFile(byte[] closeFileResponse);
	
	public BlockLocationResponse getBlockLocations(byte[] getBlockLocationsResponse);

	public AssignBlockResponse assignBlock(byte[] assignBlockResponse);
	
	public ListResponse list(byte[] listResponse);

	public BlockReportResponse blockReport(byte[] blockReportResponse);
	
	public HeartBeatResponse heartBeat(byte[] heartBeatResponse);
	
	public ReadBlockResponse readBlock(byte[] readBlockResponse);
	
	public WriteBlockResponse writeBlock(byte[] writeBlockResponse);
	
}
