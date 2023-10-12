/* 
 * David Vong
 * 991423258
 */
package ca.sheridancollege.vongda.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRecord {
	@NonNull
	private Long id;
	private String title;
	private String username;
	private String password;
	private String url;
	private String email;
	private String notes;
	

}
