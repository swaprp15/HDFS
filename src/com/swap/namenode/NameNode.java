import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class NameNode implements INameNode {

	// Request - Response
	static IRequestParser requestParser = new ProtoRequestParser();
	static IResponseGenerator responseGenerator = new ProtoResponseGenerator();
	
	// Blocks
	static Blocks blocks = new Blocks();
	
	// 
	static HashMap<String, List<Integer> > fileBlockMapping = new HashMap<>();
	static String fileBlocksMapFileName;
	
	static HashMap<Integer, DataNodeLocation> blockDatanodeMapping = new HashMap<>();
	
	static int fileHandle; // Need to persist in file
	static Object fileHandleMutex; 
	
	private static void InitialiseFileBlockMapping() throws IOException
	{
		// Read from file and fill fileBlockMapping
		BufferedReader reader = new BufferedReader(new FileReader(fileBlocksMapFileName));
		
		String line = null;
		
		fileBlockMapping.clear();
		
		while((line = reader.readLine()) != null )
		{
			String parts[] = line.split(":");
			
			if(parts.length != 2)
				continue;
			
			String fileName = parts[0];
			
			String blocks[] = parts[1].split(",");
			
			List<Integer> blockList = new LinkedList<>();
			
			for(String block : blocks)
			{
				try
				{
					blockList.add(Integer.parseInt(block));
				}
				catch(Exception e)
				{
					
				}
			}
			
			if(blockList.size() != 0)
			{
				fileBlockMapping.put(fileName, blockList);
			}
		}
	}
	
	public static void ReadConfigs() throws IOException
	{
		String result = "";
		Properties prop = new Properties();
		String propFileName = "namenode.properties";
 
		InputStream inputStream = NameNode.class.getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			//throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			
			fileBlocksMapFileName = "./FileBlcksMapFile";
			return;
		}
 
		// get the property value and print it out
		fileBlocksMapFileName = prop.getProperty("FileBlocksMapFile");
	}
	
	@Override
	public byte[] openFile(byte[] openFileRequest) {
		
		// call openFile on requestParser to get the response OpenFileRsponse.
		// Get the free block number.
		
		OpenFileRequest request = null;
		
		List<Integer> blocks = fileBlockMapping.get(request.fileName);

		OpenFileResponse response = new OpenFileResponse();
		
		if(blocks == null)
		{
			response.status = 1;  // 1 = fail
			return responseGenerator.openFile(response);
		}
		else
		{
			response.status = 0;
			
			synchronized (fileHandleMutex) {
				response.handle = fileHandle;
				fileHandle++;  // assuming it wont go over INT range.
			}
			
			response.blockNums = blocks;
			
			return responseGenerator.openFile(response);
		}
		// Increment free block number
		
	}

	@Override
	public byte[] closeFile(byte[] closeFileRequest) {
		// TODO Auto-generated method stub
		
		CloseFileRequest request = null;
		
		CloseFileResponse response = new CloseFileResponse();
		
		response.status = 0;  // What to do actually??
		
		return responseGenerator.closeFile(response);
	}

	@Override
	public byte[] getBlockLocations(byte[] getBlockLOcationsRequest) {
		
		BlockLocationRequest request = requestParser.getBlockLocations(getBlockLOcationsRequest);
		
		BlockLocationResponse response = new BlockLocationResponse();
		
		// Find the data nodes for these blocks..
		
		//........................................
		
		return responseGenerator.getBlockLocations(response);
	}

	@Override
	public byte[] assignBlock(byte[] assignBlockRequest) {

		AssignBlockRequest request = requestParser.assignBlock(assignBlockRequest);
		
		AssignBlockResponse response = new AssignBlockResponse();
		
		// Find the data nodes for these blocks..
		
		//........................................
		
		return responseGenerator.assignBlock(response);
		
	}

	@Override
	public byte[] list(byte[] listRequest) {
		
		ListRequest request = requestParser.list(listRequest);
		
		ListResponse response = new ListResponse();
		
		
		
		return responseGenerator.list(response);	
	}

	@Override
	public byte[] blockReport(byte[] blockReportRequest) {
		
		BlockReportRequest request = requestParser.blockReport(blockReportRequest);
		
		BlockReportResponse response = new BlockReportResponse();
		
		
		
		return responseGenerator.blockReport(response);	
		
	}

	@Override
	public byte[] heartBeat(byte[] heartBeatRequest) {
		
		HeartBeatRequest request = requestParser.heartBeat(heartBeatRequest);
		
		HeartBeatResponse response = new HeartBeatResponse();
		
		
		
		return responseGenerator.heartBeat(response);	
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Here code should be to set this up as remote object
		// which would be called from client
		// Should be multithreaded..
		
		ReadConfigs();
		
		
		// For now just call individual methods from here..
		blocks.restore();
		InitialiseFileBlockMapping();

	}

}
