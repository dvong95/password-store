/*
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.database;

import java.util.List;

import ca.sheridancollege.vongda.beans.PasswordRecord;

public interface DatabaseAccess {
	public void insertRecord(PasswordRecord record);
	public List<PasswordRecord> getRecordList();
	public void updateRecord(PasswordRecord record);
	public void deleteRecordById(Long id);
	public List<PasswordRecord> getRecordListById(Long id);
}
