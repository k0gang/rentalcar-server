package rentalcarServer.car.model;

public class CarResponseDto {
	private int car_code;
	private String car_num;
	private String car_abroad;
	private String car_brand;
	private String car_name;
	private String car_type;
	private int car_seat;
	private String car_oil;
	private int car_year;
	private int car_price;
	private String imageUrl;
	
	public CarResponseDto(int car_code, String car_num, String car_abroad, String car_brand, String car_name,
			String car_type, int car_seat, String car_oil, int car_year, int car_price, String imageUrl) {
		super();
		this.car_code = car_code;
		this.car_num = car_num;
		this.car_abroad = car_abroad;
		this.car_brand = car_brand;
		this.car_name = car_name;
		this.car_type = car_type;
		this.car_seat = car_seat;
		this.car_oil = car_oil;
		this.car_year = car_year;
		this.car_price = car_price;
		this.imageUrl = imageUrl;
	}

	public int getCar_code() {
		return car_code;
	}

	public void setCar_code(int car_code) {
		this.car_code = car_code;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getCar_abroad() {
		return car_abroad;
	}

	public void setCar_abroad(String car_abroad) {
		this.car_abroad = car_abroad;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public int getCar_seat() {
		return car_seat;
	}

	public void setCar_seat(int car_seat) {
		this.car_seat = car_seat;
	}

	public String getCar_oil() {
		return car_oil;
	}

	public void setCar_oil(String car_oil) {
		this.car_oil = car_oil;
	}

	public int getCar_year() {
		return car_year;
	}

	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}

	public int getCar_price() {
		return car_price;
	}

	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
}