package tema_22_12_2018_phone_app;

public class Message {
	private String phoneNumber;
	private String messageContent;

	public Message(String phoneNumber, String messageContent) {
		this.phoneNumber = phoneNumber;
		if (messageContent.length() <= 500) {
			this.messageContent = messageContent;
		}else {
			this.messageContent = messageContent.substring(0, 500);
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/*
	 * public void setPhoneNumber(String phoneNumber) { this.phoneNumber =
	 * phoneNumber; }
	 */
	public String getMessageContent() {
		return messageContent;
	}

	/*
	 * public void setMessage(String message) { this.message = message; }
	 */

}
