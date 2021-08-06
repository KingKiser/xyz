package com.kosa.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UploadFileRepository implements IUploadFileRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int getMaxFileId() {
		String sql = "select nvl(max(file_id),0) from upload_file";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void uploadFile(UploadFileVO file) {
		String sql = "insert into upload_file (file_id, directory_name, "
				+ "file_name, file_size, file_content_type, "
				+ "file_upload_date, file_data) "
				+ "values (?,?,?,?,?, systimestamp,?)";
		jdbcTemplate.update(sql, file.getFileId(),
				file.getDirectoryName(),
				file.getFileName(),
				file.getFileSize(),
				file.getFileContentType(),
				file.getFileData());

	}

	@Override
	public List<UploadFileVO> getAllFileList() {
		String sql = "select "
				+"file_id as fileId, "
				+"directory_name as directoryName, "
				+"file_name as fileName, "
				+"file_size as fileSize, "
				+"file_content_type as fileContentType, "
				+"file_upload_date as fileUploadDate "
				+"from upload_file "
				+" order by fileUploadDate DESC";
		return jdbcTemplate.query(sql,new RowMapper<UploadFileVO>(){
			@Override
			public UploadFileVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				UploadFileVO file = new UploadFileVO();
				file.setFileId(rs.getInt("fileId"));
				file.setDirectoryName(rs.getString("directoryName"));
				file.setFileName(rs.getString("fileName"));
				file.setFileSize(rs.getLong("fileSize"));
				file.setFileContentType(rs.getString("fileContentType"));
				file.setFileUploadDate(rs.getTimestamp("fileUploadDate"));
				return file;
			}
		});
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		String sql = "select "
					+" file_id 				as fileId, "
					+" directory_name 		as directoryName, "
					+" file_name 			as fileName, "
					+" file_size 			as fileSize, "
					+" file_content_type 	as fileContentType, "
					+" file_data            as fileData"
					+" from upload_file where file_id=? ";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UploadFileVO>() {
			@Override
			public UploadFileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UploadFileVO file = new UploadFileVO();
				file.setFileId(rs.getInt("fileId"));
				file.setDirectoryName(rs.getString("directoryName"));
				file.setFileName(rs.getString("fileName"));
				file.setFileSize(rs.getLong("fileSize"));
				file.setFileContentType(rs.getString("fileContentType"));
				file.setFileData(rs.getBytes("fileData"));
				return file;
			}
			
		},fileId);
	}

	@Override
	public void updateFile(UploadFileVO file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFile(int fileId) {
		String sql = "delete upload_file where file_id=?";
		jdbcTemplate.update(sql, fileId);

	}

}
