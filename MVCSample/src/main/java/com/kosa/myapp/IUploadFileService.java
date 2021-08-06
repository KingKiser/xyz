package com.kosa.myapp;

import java.util.List;

public interface IUploadFileService {
	void uploadFile(UploadFileVO file);
	List<UploadFileVO> getAllFileList();
	UploadFileVO getFile(int fileId);
	void deleteFile(int fileId);

}
