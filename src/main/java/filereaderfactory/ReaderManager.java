package filereaderfactory;

public interface ReaderManager {
	
	public ReaderManager readFile(String filePath);
	public String get(String key); 
	public Object[] getObject();

}
