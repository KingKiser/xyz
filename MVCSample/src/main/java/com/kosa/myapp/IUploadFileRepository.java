package com.kosa.myapp;

import java.util.List;

public interface IUploadFileRepository {
	int getMaxFileId();
	void uploadFile(UploadFileVO file);
	
	List<UploadFileVO> getAllFileList();
	UploadFileVO getFile(int fileId);
	
	void updateFile(UploadFileVO file);
	void deleteFile(int fileId);
}
