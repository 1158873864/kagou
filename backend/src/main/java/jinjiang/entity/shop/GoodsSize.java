package jinjiang.entity.shop;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="size")//商品尺寸
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class GoodsSize {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	private String id; //编号

	@Column
	private String name;//color名称

	@Column
	private String image; //对应价格

	public GoodsSize() {
	}

	public GoodsSize(String name, String image) {
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
