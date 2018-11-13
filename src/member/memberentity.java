package member;

public class memberentity {
	private String id;
	private String passwd;
	private String name;
	private String address;
	private String phone_number;
	private int point;
	private int buy_list;
	private String birth_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getBuy_list() {
		return buy_list;
	}
	public void setBuy_list(int buy_list) {
		this.buy_list = buy_list;
	}
	public String getDate() {
		return birth_date;
	}
	public void setDate(String date) {
		this.birth_date = date;
	}

}
