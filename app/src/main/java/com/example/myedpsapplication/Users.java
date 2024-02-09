package com.example.myedpsapplication;

public class Users {

    String name;
    String age;

    public Users() {
        // デフォルトコンストラクタはデータのデシリアライズ時にFirebaseが必要とするため、空のままにします。
    }

    public Users(String name, String age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    // nameプロパティのセッター
    public void setName(String name) {
        this.name = name;
    }

}
