package com.learn.第2章;

import java.security.InvalidParameterException;

/**
 * 本章:在类的属性过多,但不是每一个都是必须参数.怎么创建实例比较合理?
 */
class Production {
    private double price; //价格  必填
    private long timeStamp;  //生产日志 必填
    private String orgin;  //产地 选填
    private String company;  //生产公司  选填
    private String seller;  //卖它的超市 选填

    private Production(Builder builder) {
        this.price = builder.price;
        this.timeStamp = builder.timeStamp;
        this.orgin = builder.orgin;
        this.company = builder.company;
        this.seller = builder.seller;
    }

    public static class Builder {
        //必填参数
        private final double price;
        private final long timeStamp;

        //选填,使用默认值
        private String orgin = null;
        private String company = null;
        private String seller = null;


        public Builder(double price, long timeStamp) {
            this.price = price;
            this.timeStamp = timeStamp;
        }

        public Builder addOrgin(String orgin) {
            if (this.orgin != null) throw new InvalidParameterException("参数重复:orgin");
            this.orgin = orgin;
            return this;
        }

        public Builder addCompany(String company) {
            if (this.company != null) throw new InvalidParameterException("参数重复:company");
            this.company = company;
            return this;
        }

        public Builder addSeller(String seller) {
            if (this.seller != null) throw new InvalidParameterException("参数重复:seller");
            this.seller = seller;
            return this;
        }

        public Production build() {
            return new Production(this);
        }


    }

    @Override
    public String toString() {
        return "Builder{" +
                "price=" + price +
                ", timeStamp=" + timeStamp +
                ", orgin='" + orgin + '\'' +
                ", company='" + company + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }

}


public class tip2 {

    public static void main(String[] args) {
        //先建立基础属性,然后慢慢添加,最后生成真正的类
        Production.Builder base = new Production.Builder(1.2, System.currentTimeMillis());
        Production apple = base.addCompany("小米").addOrgin("荆州").addSeller("周昂").build();
        System.out.println(apple);

        //若重复设置,直接抛出
        Production.Builder base1 = new Production.Builder(1.2, System.currentTimeMillis());
        Production apple1 = base1.addSeller("周昂").addSeller("张煦").build();
        System.out.println(apple1);

    }
}
