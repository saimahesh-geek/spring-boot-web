package sm.springboot.mingleoccean.web.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sm.springboot.mingleoccean.web.model.File;

@Component
public class FileSystemService {
	
	private static List<File> files = new ArrayList<File>();
	
	static {
		files.add(new File(1, 0, "Shares.txt", "Admin", new Date(), "File"));
		files.add(new File(2, 0, "Market.ppt", "Admin", new Date(), "File"));
		files.add(new File(3, 0, "Books.doc", "User1", new Date(), "File"));
	}
	
	public void addFile(File file) {
		files.add(file);
	}
	
	public List<File> retrieveFiles(long parentId) {
		List<File> filteredFiles = new ArrayList<File>();
		for (File file : files) {
			if (file.getParentId() == parentId) {
				filteredFiles.add(file);
			}
		}
		
		return filteredFiles;
	}
	
	public void remove(long id) {
		Iterator<File> it = files.iterator();
		
		while (it.hasNext()) {
			File file = it.next();
			if (file.getId() == id) {
				it.remove();
			}
		}
	}
	
	public File retrieveFile(long id) {
		for (File file : files) {
			if (file.getId() == id) {
				return file;
			}
		}
		
		return null;
	}
}
