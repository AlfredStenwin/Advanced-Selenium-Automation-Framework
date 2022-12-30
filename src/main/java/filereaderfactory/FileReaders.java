package filereaderfactory;

import enums.FileType;

public class FileReaders {
	
	public static ReaderManager getFileReader(FileType readerType) {
        ReaderManager readerManager; 
             
        switch (readerType.name().toLowerCase()) {
		case "property":
			readerManager = new PropertyFileReader();
			break;
		case "json":
			readerManager = new JsonFileReader();
        	break;
		default:
			throw new IllegalArgumentException(readerType.name());
		}
        
        return readerManager;
    }
    
}
