package com.kosa.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService implements IUploadFileService {
	
	@Autowired
	IUploadFileRepository uploadFileRepository;

	@Override
	public void uploadFile(UploadFileVO file) {
		int maxFileId = uploadFileRepository.getMaxFileId();
		file.setFileId(maxFileId+1);
		uploadFileRepository.uploadFile(file);
	}
	
	@Override
	public List<UploadFileVO> getAllFileList(){
		return uploadFileRepository.getAllFileList();
	}
	
	@Override
	public UploadFileVO getFile(int fileId){
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public void deleteFile(int fileId) {
		uploadFileRepository.deleteFile(fileId);
		
	}

}
