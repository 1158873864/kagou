package jinjiang.entity.shop;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="color")//商品颜色
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class GoodsColor {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	private String id; //编号

	@Column
	private String name;//color名称

	@Column
	private String image; //对应主图

	public GoodsColor() {
	}


	public GoodsColor(String name, String image) {
		this.name = name;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
