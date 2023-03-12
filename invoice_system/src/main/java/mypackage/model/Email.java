package mypackage.model;

public class Email {

	private String recipient;
	private String subject;
	private String msg;
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(String recipient, String subject, String msg) {
		super();
		this.recipient = recipient;
		this.subject = subject;
		this.msg = msg;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
