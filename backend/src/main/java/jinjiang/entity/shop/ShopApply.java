package jinjiang.entity.shop;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop_apply")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class ShopApply {//门店
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

    @Column(name = "status")
    private String status; //状态,通过,未通过,待审核

    @Column(name = "userId")
    private String userId; //id，申请人id

    @Column(name = "license")
    private String license; //营业执照

    @Column(name = "cardFront")
    private String cardFront; //法人身份证正面

    @Column(name = "cardBack")
    private String cardBack; //法人身份证反面

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> other; //

    public ShopApply() {
    }

    public ShopApply(String name, String mobilePhone, String password, String workTime, String province, String city, String district, String detail, double balance, String faceUrl, String showUrl, String status, String userId, String license, String cardFront, String cardBack, List<String> other) {
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
        this.status = status;
        this.userId = userId;
        this.license = license;
        this.cardFront = cardFront;
        this.cardBack = cardBack;
        this.other = other;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setCardFront(String cardFront) {
        this.cardFront = cardFront;
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack;
    }

    public List<String> getOther() {
        return other;
    }

    public void setOther(List<String> other) {
        this.other = other;
    }
}
