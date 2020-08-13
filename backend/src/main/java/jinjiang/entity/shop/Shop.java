package jinjiang.entity.shop;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "shop")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Shop {//门店
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;//编号

    @Column(name = "name")
    private String name;//商户名称

    @Column(name = "mobilePhone")
    private String mobilePhone;//商户电话

    @Column(name = "password")
    private String password;//商户密码

    @Column(name = "workTime")
    private String workTime;//商户营业时间

    @Column(name = "province")
    private String province; //省

    @Column(name = "city")
    private String city; //市

    @Column(name = "district")
    private String district; //区

    @Column(name = "detail")
    private String detail; //详细地址

    @Column(name = "balance")
    private double balance; //商户余额

    @Column(name = "faceUrl")
    private String faceUrl; //商户头像

    @Column(name = "showUrl")
    private String showUrl; //商户展示图

    @Column(name = "userId")
    private String userId; //对应微信用户的id

    public Shop() {
    }

    public Shop(String name, String mobilePhone, String password, String workTime, String province, String city, String district, String detail, double balance, String faceUrl, String showUrl, String userId) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.password = password;
        this.workTime = workTime;
        this.province = province;
        this.city = city;
        this.district = district;
        this.detail = detail;
        this.balance = balance;
        this.faceUrl = faceUrl;
        this.showUrl = showUrl;
        this.userId = userId;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
