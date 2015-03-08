
public interface IRequestParser {
	
	public OpenFileRequest openFile(byte[] openFileRequest);
	
	public CloseFileRequest closeFile(byte[] closeFileRequest);
	
	public BlockLocationRequest getBlockLocations(byte[] getBlockLOcationsRequest);

	public AssignBlockRequest assignBlock(byte[] assignBlockRequest);
	
	public ListRequest list(byte[] listRequest);

	public BlockReportRequest blockReport(byte[] blockReportRequest);
	
	public HeartBeatRequest heartBeat(byte[] heartBeatRequest);
	
	public ReadBlockRequest readBlock(byte[] readBlockRequest);
	
	public WriteBlockRequest writeBlock(byte[] writeBockRequest);
}
