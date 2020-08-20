/**
 * 
 */
package bean;

/**
 * @project: 
 * @author: Zuohaonan
 * @date: 
 * @desc: ҩƷʵ����
 **/
public class Drug {

	private String id;      //ҩƷ����
	private String code;    //ҩƷ����
	
	private String name;     //ҩƷ����
	private String helpId;  //ҩƷ������
	private String spec;     //ҩƷ���
	private String unit;     //ҩƷ��λ
	private double price;    //ҩƷ����
	private String type;     //ҩƷ����
	
	public Drug(){}
	
	/**
	 * @param id
	 * @param name
	 * @param helpId
	 * @param spec
	 * @param unit
	 * @param price
	 * @param type
	 */
	public Drug(String id, String name, String helpId, String spec, String unit, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.helpId = helpId;
		this.spec = spec;
		this.unit = unit;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHelpId() {
		return helpId;
	}
	public void setHelpId(String helpId) {
		this.helpId = helpId;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	

	@Override
	public String toString() {
		return "Drug [id=" + id + ", Code = "+code+", name=" + name + ", spec=" + spec + ", unit=" + unit
				+ ", type=" + type + ",price=" + price + ",helpId=" + helpId + ",  ]";
	}
}
