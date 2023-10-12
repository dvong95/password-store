/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.utilities;

import java.util.Random;

import ca.sheridancollege.vongda.database.DatabaseAccessImpl;

public class RandomNumberGenerator {

	public static Long generateID(DatabaseAccessImpl da) {
		Long id;
		Random r = new Random();

		do {
			id = r.nextLong(100000000, 1000000000); //Always 9 digits
		} while (isExistingID(id, da)); //Rare but ensure unique

		return id;
	}

	public static boolean isExistingID(Long id, DatabaseAccessImpl da) {
		//Using Java stream (learned during summer, use anyMatch() to return
		//boolean where each record in list, if the id given matches with
		//any id already in the list
		return da.getRecordList().stream()
				.anyMatch(p -> p.getId() != null && p.getId().equals(id));
	}
}
