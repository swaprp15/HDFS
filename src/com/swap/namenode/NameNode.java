package com.swap.namenode;

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

	static IRequestParser requestParser = new ProtoRequestParser();
	
	static Blocks blocks = new Blocks();
	
	static HashMap<String, List<Integer> > fileBlockMapping = new HashMap<>();
	
	static String fileBlocksMapFileName;
	
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
		int blockNumber = blocks.getFreeBlockNumber();
		
		
		
		// Increment free block number
		
		
		
		return null;
	}

	@Override
	public byte[] closeFile(byte[] closeFileRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBlockLocations(byte[] getBlockLOcationsRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] assignBlock(byte[] assignBlockRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] list(byte[] listRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] blockReport(byte[] blockReportRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] heartBeat(byte[] hearBeatRequest) {
		// TODO Auto-generated method stub
		return null;
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
