import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.protobuf.InvalidProtocolBufferException;


public class ProtoRequestParser implements IRequestParser{

	@Override
	public ReadBlockRequest readBlock(byte[] readBlockRequest) {
		// TODO Auto-generated method stub
		
		ReadBlockRequest currentReadBlockRequest = new ReadBlockRequest();
		try {
			
			InputStream in = new ByteArrayInputStream(readBlockRequest);
			HDFS.ReadBlockRequest input = HDFS.ReadBlockRequest.parseFrom(in);
			int temp =0;
			temp = input.getBlockNumber();
			currentReadBlockRequest.blockNumber=temp;
			
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentReadBlockRequest;
	}

	@Override
	public WriteBlockRequest writeBlock(byte[] writeBlockRequest) {
		// TODO Auto-generated method stub
		WriteBlockRequest currentWriteBlockRequest = new WriteBlockRequest();
		
		InputStream in = new ByteArrayInputStream(writeBlockRequest);
		try {
			currentWriteBlockRequest.wrBlockRequest = HDFS.WriteBlockRequest.parseFrom(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return currentWriteBlockRequest;
	}

	@Override
	public OpenFileRequest openFile(byte[] openFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CloseFileRequest closeFile(byte[] closeFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockLocationRequest getBlockLocations(
			byte[] getBlockLOcationsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssignBlockRequest assignBlock(byte[] assignBlockRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListRequest list(byte[] listRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockReportRequest blockReport(byte[] blockReportRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeartBeatRequest heartBeat(byte[] heartBeatRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
